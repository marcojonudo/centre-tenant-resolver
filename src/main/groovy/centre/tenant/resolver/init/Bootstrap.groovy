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
import javax.sql.DataSource

@Singleton
class Bootstrap implements ApplicationEventListener<StartupEvent> {

	private static final Logger LOG = LoggerFactory.getLogger(Bootstrap)
	private static final String DEFAULT_DATABASE_NAME = "default"

	@Inject HibernateDatastore hibernateDatastore
	@Inject CentreService centreService
	@Inject DatabaseNameService databaseNameService
	@Inject DataSource dataSource

	@Override
	void onApplicationEvent(StartupEvent event) {
		print("\n")
		LOG.info("Inserting centres dataSources...")
		LOG.info("Local dataSources names: ${databaseNameService.findAll().name.toString()}")

		List<String> centresDataSources = []
		databaseNameService.findAll().each { DatabaseName databaseName ->
			centreService.findAll().each {
				String dataSourceName = CustomTenantResolver.buildTenantId(it.code, databaseName.name)
				DbConfig dbConfig = new DbConfig(databaseName.name, it.code)
				addDataSource(dataSourceName, dbConfig.config)
				centresDataSources << dataSourceName
			}
		}
		LOG.info("Centres dataSources names: $centresDataSources")
		LOG.info("Centres dataSources inserted\n")
	}

	void addDataSource(String name, Map<String, Object> config) {
		try {
			hibernateDatastore.getConnectionSources().addConnectionSource(name, config)
		} catch (all) {
			LOG.error(all.message)
		}
	}

}
