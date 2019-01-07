package centre.tenant.resolver.controllers

import centre.tenant.resolver.domains.Configuration
import centre.tenant.resolver.domains.Store
import centre.tenant.resolver.services.PanelService
import centre.tenant.resolver.services.data.ConfigurationDataService
import centre.tenant.resolver.services.data.StoreService
import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

import javax.inject.Inject

@CompileStatic
@Controller("/panel")
class PanelController {

	private final ConfigurationDataService configurationDataService
	private final StoreService storeService
	private final PanelService panelService

	@Inject
	PanelController(ConfigurationDataService configurationDataService, StoreService storeService, PanelService panelService) {
		this.configurationDataService = configurationDataService
		this.storeService = storeService
		this.panelService = panelService
	}

	@Get("/hello")
	Configuration hello() {
		Configuration configuration = configurationDataService.findByClave("planning.types")
		return configuration
	}

}
