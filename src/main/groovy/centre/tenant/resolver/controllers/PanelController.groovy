package centre.tenant.resolver.controllers

import centre.tenant.resolver.domains.cubo.CentreSchedule
import centre.tenant.resolver.services.PanelService
import centre.tenant.resolver.services.data.CentreScheduleDataService
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

	private final PanelService panelService
	private final CentreScheduleDataService centreScheduleDataService

	PanelController(PanelService panelService, CentreScheduleDataService centreScheduleDataService) {
		this.panelService = panelService
		this.centreScheduleDataService = centreScheduleDataService
	}

	@Get("/hello")
	Map<String, String> hello() {
		CentreSchedule centreSchedule = null
//		Configuration configuration = null
		try {
			centreSchedule = centreScheduleDataService.get(1)
		} catch (ConfigurationException e) {
			LOG.error(e.message)
		}
		return [hola: 'que tal']
	}

}
