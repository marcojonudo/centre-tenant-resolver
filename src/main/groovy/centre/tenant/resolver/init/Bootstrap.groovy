package centre.tenant.resolver.init

import centre.tenant.resolver.domains.Store
import centre.tenant.resolver.services.data.StoreService
import grails.gorm.multitenancy.Tenants
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.context.event.StartupEvent
import org.grails.orm.hibernate.HibernateDatastore

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Bootstrap implements ApplicationEventListener<StartupEvent> {

	@Inject HibernateDatastore hibernateDatastore
	@Inject StoreService storeService

	@Override
	void onApplicationEvent(StartupEvent event) {
		List<Store> stores = storeService.findAll()
		hibernateDatastore.connectionSources.each {
			println(it.name)
		}
	}
}
