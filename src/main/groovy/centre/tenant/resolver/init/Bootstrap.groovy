package centre.tenant.resolver.init

import centre.tenant.resolver.domains.Centre
import centre.tenant.resolver.domains.DatabaseName
import centre.tenant.resolver.pogos.DbConfig
import centre.tenant.resolver.services.data.CentreService
import centre.tenant.resolver.services.data.DatabaseNameService
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.context.event.StartupEvent
import org.grails.orm.hibernate.HibernateDatastore

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Bootstrap implements ApplicationEventListener<StartupEvent> {

	@Inject HibernateDatastore hibernateDatastore
	@Inject CentreService centreService
	@Inject DatabaseNameService databaseNameService

	@Override
	void onApplicationEvent(StartupEvent event) {
		centreService.findAll().each { Centre centre ->
			databaseNameService.findAll().each {
				String dataSourceName = "$centre.code-$it.name"
				DbConfig dbConfig = new DbConfig(centre.code, dataSourceName)
				hibernateDatastore.getConnectionSources().addConnectionSource(dbConfig.dataSourceName, dbConfig.config)
			}
		}
		hibernateDatastore.connectionSources.each {
			println(it.name)
		}
	}
}
