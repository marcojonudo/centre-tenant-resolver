package centre.tenant.resolver.domains.cubo

import grails.gorm.MultiTenant
import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity

@Entity
class EmployeeSchedule implements GormEntity<EmployeeSchedule>, MultiTenant {

    java.sql.Date day
    Employee employee
    Integer restMinutes
    String panelPosition
    String jobLineType
    boolean showInPanel
    Date dateCreated
    Date dateUpdated
	String userUpdated
    boolean deleted

    static constraints = {
	    day nullable: true
        restMinutes nullable: true
        jobLineType nullable: true, maxSize: 10
        panelPosition nullable: true, maxSize: 1
        schedule nullable: true
        absence nullable: true
	    userUpdated nullable: true, maxSize: 45
    }

    static mapping = {
        version defaultValue: 0
        showInPanel defaultValue: true
        dateCreated defaultValue: new Date()
        dateUpdated defaultValue: new Date()
        deleted defaultValue: false
    }

    static hasOne = [schedule: Schedule, absence: ScheduleAbsence, jobPositionGroup: JobPositionGroup]

//    @CompileStatic
//    static EmployeeSchedule get(java.sql.Date day, Employee employee) {
//        EmployeeSchedule employeeSchedule = (EmployeeSchedule) createCriteria().get {
//            eq('day', day)
//            eq('employee', employee)
//            eq('deleted', false)
//        }
//
//        return employeeSchedule
//    }
//
//    @GrailsCompileStatic
//    static List<EmployeeSchedule> getAllByDay(java.sql.Date day) {
//        List<EmployeeSchedule> employeesSchedules = findAllByDayAndShowInPanelAndDeleted(day, true, false).sort {
//            ((EmployeeSchedule) it).panelPosition
//        }
//        return employeesSchedules
//    }
//
//    @GrailsCompileStatic
//    static List<EmployeeSchedule> getFixedSchedules() {
//        List<EmployeeSchedule> employeesSchedules = findAllByDayIsNullAndShowInPanelAndDeleted(true, false).sort {
//            ((EmployeeSchedule) it).panelPosition
//        }
//        return employeesSchedules
//    }
//
//    @CompileStatic
//    static EmployeeSchedule getByDayAndEmployee(java.sql.Date day, Employee employee) {
//        EmployeeSchedule employeesSchedules = (EmployeeSchedule) createCriteria().get {
//            eq('day', day)
//	        eq('employee', employee)
//            eq('deleted', false)
//        }
//        return employeesSchedules
//    }
//
//    @CompileStatic
//    static EmployeeSchedule create(java.sql.Date day, Employee employee, JobPositionGroup jobPositionGroup, EmployeeScheduleOrder employeeOrder) {
//        EmployeeSchedule employeeSchedule = new EmployeeSchedule(
//                day: day,
//                employee: employee,
//                jobPositionGroup: jobPositionGroup,
//                employeeOrder: employeeOrder
//        )
//        return employeeSchedule
//    }

}
