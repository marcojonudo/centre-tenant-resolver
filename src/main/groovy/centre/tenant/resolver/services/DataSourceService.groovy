package centre.tenant.resolver.services

import centre.tenant.resolver.domains.Centre
import centre.tenant.resolver.domains.DatabaseName
import centre.tenant.resolver.pogos.dataSources.Datastore
import centre.tenant.resolver.pogos.dataSources.DbConfig
import centre.tenant.resolver.services.data.CentreService
import centre.tenant.resolver.services.data.DatabaseNameService
import centre.tenant.resolver.tenant.resolver.CustomTenantResolver
import groovy.transform.CompileStatic
import org.grails.orm.hibernate.HibernateDatastore
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.inject.Singleton

@Singleton
@CompileStatic
class DataSourceService {

	private static final Logger LOG = LoggerFactory.getLogger(DataSourceService)

	private static final String LOCAL_DATABASE_ID = "local"

	private final HibernateDatastore hibernateDatastore
	private final CentreService centreService
	private final DatabaseNameService databaseNameService

	DataSourceService(HibernateDatastore hibernateDatastore, CentreService centreService, DatabaseNameService databaseNameService) {
		this.hibernateDatastore = hibernateDatastore
		this.centreService = centreService
		this.databaseNameService = databaseNameService
	}

	void initTenants() {
		print("\n")
		LOG.info("Inserting centres dataSources...")
		LOG.info("Local DB dataSources names: ${databaseNameService.findAll().name.toString()}")

		List<DatabaseName> databaseNames = databaseNameService.findAll()
		List<Centre> centre = centreService.findAll()
		saveTenants(databaseNames, centre)

		Datastore.dataSourcesNames = hibernateDatastore.connectionSources.allConnectionSources.collect { it.name }
		LOG.info("Centres dataSources names: $Datastore.dataSourcesNames")
		LOG.info("Centres dataSources inserted\n")
	}

	void saveTenants(List<DatabaseName> databaseNames, List<Centre> centres) {
		databaseNames.each { DatabaseName databaseName ->
			centres.each {
				String dataSourceName = CustomTenantResolver.buildTenantId(it.code as String, databaseName.name)
				DbConfig dbConfig = new DbConfig(databaseName.name, it.code)
				addDataSource(dataSourceName, dbConfig.config)
			}

			String localDataSourceName = CustomTenantResolver.buildTenantId(LOCAL_DATABASE_ID, databaseName.name)
			addDataSource(localDataSourceName, new DbConfig(databaseName.name).config)
		}
	}

	void addDataSource(String name, Map<String, Object> config) {
		try {
			hibernateDatastore.getConnectionSources().addConnectionSource(name, config)
		} catch (all) {
			LOG.error(all.message)
		}
	}

}
