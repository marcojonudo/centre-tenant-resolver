package centre.tenant.resolver.controllers

import centre.tenant.resolver.pogos.tenants.SaveTenantJson
import centre.tenant.resolver.services.TenantService
import centre.tenant.resolver.services.data.CentreService
import centre.tenant.resolver.services.data.DatabaseNameService
import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@CompileStatic
@Controller("/tenant")
class TenantController {

	private static final Logger LOG = LoggerFactory.getLogger(TenantController)

	private final CentreService centreService
	private final DatabaseNameService databaseNameService
	private final TenantService tenantService

	TenantController(CentreService centreService, DatabaseNameService databaseNameService, TenantService tenantService) {
		this.centreService = centreService
		this.databaseNameService = databaseNameService
		this.tenantService = tenantService
	}

	@Post("/database/save")
	Map<String, String> saveDatabase(@Body SaveTenantJson json) {
		tenantService.saveDatabase(json.database)
//		Configuration configuration = null
//		try {
//			centreSchedule = centreScheduleDataService.get(1)
//		} catch (ConfigurationException e) {
//			LOG.error(e.message)
//		}
//		LOG.info(centre as String)
		LOG.info(json.database)
		return [hola: 'que tal']
	}

}
