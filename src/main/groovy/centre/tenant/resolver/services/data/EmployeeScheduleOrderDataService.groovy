package centre.tenant.resolver.services.data

import centre.tenant.resolver.domains.cubo.Employee
import centre.tenant.resolver.domains.cubo.EmployeeScheduleOrder
import centre.tenant.resolver.domains.cubo.JobPositionGroup
import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.services.Service

@CurrentTenant
@Service(EmployeeScheduleOrder)
interface EmployeeScheduleOrderDataService {

	EmployeeScheduleOrder get(Employee employee, JobPositionGroup jobPositionGroup)
	EmployeeScheduleOrder save(Employee employee, JobPositionGroup jobPositionGroup, int employeeOrder)

}
