package centre.tenant.resolver.init

import centre.tenant.resolver.domains.DatabaseName
import centre.tenant.resolver.pogos.dataSources.DbConfig
import centre.tenant.resolver.services.data.CentreService
import centre.tenant.resolver.services.data.DatabaseNameService
import centre.tenant.resolver.tenant.resolver.CustomTenantResolver
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.context.event.StartupEvent
import org.grails.orm.hibernate.HibernateDatastore
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Bootstrap implements ApplicationEventListener<StartupEvent> {

	private static final Logger LOG = LoggerFactory.getLogger(Bootstrap)
	private static final String DEFAULT_DATABASE_NAME = "default"

	@Inject HibernateDatastore hibernateDatastore
	@Inject CentreService centreService
	@Inject DatabaseNameService databaseNameService

	@Override
	void onApplicationEvent(StartupEvent event) {
		LOG.info(databaseNameService.findAll().toString())
		databaseNameService.findAll().each { DatabaseName databaseName ->
			LOG.info(databaseName.name)
			centreService.findAll().each {
				String dataSourceName = CustomTenantResolver.buildTenantId(it.code, databaseName.name)
				DbConfig dbConfig = new DbConfig(databaseName.name, it.code)
				addDataSource(dataSourceName, dbConfig.config)
			}
//			addDataSource(DEFAULT_DATABASE_NAME, new DbConfig(databaseName.name).config)
		}
		List<String> connectionSourcesNames = hibernateDatastore.connectionSources.allConnectionSources.collect { it.name }
		LOG.info("Connection sources names: $connectionSourcesNames")
	}

	void addDataSource(String name, Map<String, Object> config) {
		try {
			hibernateDatastore.getConnectionSources().addConnectionSource(name, config)
		} catch (all) {
			LOG.error(all.message)
		}
	}

}
