package centre.tenant.resolver.domains.cubo

import grails.gorm.MultiTenant
import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity

@Entity
class EmployeeScheduleOrder implements GormEntity<EmployeeScheduleOrder>, MultiTenant {

    Employee employee
    JobPositionGroup jobPositionGroup
    int employeeOrder

    static mapping = {
        version defaultValue: 0
    }

//    @GrailsCompileStatic
//    static EmployeeScheduleOrder get(Employee employee, JobPositionGroup jobPositionGroup) {
//        EmployeeScheduleOrder employeeScheduleOrder = findByEmployeeAndJobPositionGroup(employee, jobPositionGroup)
//        return employeeScheduleOrder
//    }
//
//    @CompileStatic
//    static EmployeeScheduleOrder create(Employee employee, JobPositionGroup jobPositionGroup, int employeeOrder) {
//        EmployeeScheduleOrder employeeScheduleOrder = new EmployeeScheduleOrder(
//                employee: employee,
//                jobPositionGroup: jobPositionGroup,
//                employeeOrder: employeeOrder
//        )
//        return employeeScheduleOrder
//    }

}
