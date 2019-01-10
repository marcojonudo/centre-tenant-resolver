package centre.tenant.resolver.services.data

import centre.tenant.resolver.domains.cubo.CentreSchedule
import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.services.Service

import java.sql.Date

@CurrentTenant
@Service(CentreSchedule)
interface CentreScheduleDataService {

	CentreSchedule get(Date day)
	CentreSchedule save(Date day)

}
