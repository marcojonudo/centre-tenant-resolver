package centre.tenant.resolver.services.data

import centre.tenant.resolver.domains.cubo.Employee
import centre.tenant.resolver.domains.cubo.EmployeeSchedule
import centre.tenant.resolver.domains.cubo.EmployeeScheduleOrder
import centre.tenant.resolver.domains.cubo.JobPositionGroup
import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.services.Service

import java.sql.Date

@CurrentTenant
@Service(EmployeeSchedule)
interface EmployeeScheduleDataService {

	EmployeeSchedule get(Date day, Employee employee, boolean deleted)
	List<EmployeeSchedule> findAll(Date day)
	List<EmployeeSchedule> findAllByDayIsNullAndShowInPanelAndNotDeleted(boolean showInPanel)
	EmployeeSchedule save(Date day, Employee employee, JobPositionGroup jobPositionGroup, EmployeeScheduleOrder employeeScheduleOrder)

}
