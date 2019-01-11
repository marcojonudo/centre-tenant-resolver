package centre.tenant.resolver.services.data

import centre.tenant.resolver.domains.cubo.Employee
import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.services.Service

@CurrentTenant
@Service(Employee)
interface EmployeeDataService {

	Employee get(String code)

}
