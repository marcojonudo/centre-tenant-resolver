package centre.tenant.resolver.controllers

import centre.tenant.resolver.domains.Configuration
import centre.tenant.resolver.services.PanelService
import centre.tenant.resolver.services.data.ConfigurationDataService
import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

import javax.inject.Inject

@CompileStatic
@Controller("/panel")
class PanelController {

	private final ConfigurationDataService configurationDataService
	private final PanelService panelService

	@Inject
	PanelController(ConfigurationDataService configurationDataService, PanelService panelService) {
		this.configurationDataService = configurationDataService
		this.panelService = panelService
	}

	@Get("/hello")
	Configuration hello() {
		Configuration configuration = configurationDataService.findByClave("planning.types")
		return configuration
	}

}
