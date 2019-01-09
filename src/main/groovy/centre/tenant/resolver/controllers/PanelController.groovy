package centre.tenant.resolver.controllers

import centre.tenant.resolver.domains.Configuration
import centre.tenant.resolver.services.PanelService
import centre.tenant.resolver.services.data.ConfigurationDataService
import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import org.grails.datastore.mapping.core.exceptions.ConfigurationException
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@CompileStatic
@Controller("/panel")
class PanelController {

	private static final Logger LOG = LoggerFactory.getLogger(PanelController)

	private final ConfigurationDataService configurationDataService
	private final PanelService panelService

	PanelController(ConfigurationDataService configurationDataService, PanelService panelService) {
		this.configurationDataService = configurationDataService
		this.panelService = panelService
	}

	@Get("/hello")
	Configuration hello() {
		Configuration configuration = null
		try {
			configuration = configurationDataService.find("planning.types")
		} catch (ConfigurationException e) {
			LOG.error(e.message)
		}
		return configuration
	}

}
