package centre.tenant.resolver.services.data

import centre.tenant.resolver.domains.cubo.CentreSchedule
import centre.tenant.resolver.domains.cubo.Employee
import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.services.Service

@CurrentTenant
@Service(Employee)
interface EmployeeDataService {

	CentreSchedule get(String code)

}
