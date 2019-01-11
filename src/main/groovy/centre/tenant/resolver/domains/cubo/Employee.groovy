package centre.tenant.resolver.domains.cubo

import grails.gorm.MultiTenant
import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity

@Entity
class Employee implements GormEntity<Employee>, MultiTenant {

	String code
	String name
	String noap1
	String noap2
	String nopasswd
	Gender sex
	boolean active

	static hasMany = [scheduleWeekTemplates: ScheduleWeekTemplate]
	static belongsTo = ScheduleWeekTemplate
		
    static constraints = {
		sex nullable: true
    }

	static mapping = {
		version defaultValue: 0
	}

	enum Gender {

		NONE,
		MALE,
		FEMALE

	}

//	static Employee create(String employeeCode, String employeeName, boolean active, boolean flush = false) {
//		new Employee(code: employeeCode,
//			name: employeeName,
//			active: active,
//		).save(flush: flush, insert: true)
//	}
//
//	@CompileStatic
//	static Employee getByCode(String code) {
//		Employee employee = (Employee) createCriteria().get {
//			eq('code', code)
//		}
//		return employee
//	}

}
