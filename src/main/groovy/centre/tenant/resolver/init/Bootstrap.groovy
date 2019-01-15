package centre.tenant.resolver.init

import centre.tenant.resolver.services.DataSourceService
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.context.event.StartupEvent

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Bootstrap implements ApplicationEventListener<StartupEvent> {

	@Inject DataSourceService dataSourceService

	@Override
	void onApplicationEvent(StartupEvent event) {
		dataSourceService.initTenants()
	}

}
