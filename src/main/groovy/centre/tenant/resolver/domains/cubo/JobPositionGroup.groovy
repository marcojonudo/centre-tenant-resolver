package centre.tenant.resolver.domains.cubo

import grails.gorm.MultiTenant
import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity

@Entity
class JobPositionGroup implements GormEntity<JobPositionGroup>, MultiTenant {

	JobPositionGroupCode code
	String name
	String color

	static constraints = {
		code maxSize: 15
		name maxSize: 45
		color maxSize: 10
	}

	static hasMany = [jobPositions: JobPosition, employeeSchedules: EmployeeSchedule]

	enum JobPositionGroupCode {

		GARAGE, SHOP, CASH, MANAGER

	}

	static JobPositionGroup getByCode(JobPositionGroupCode code) {
		JobPositionGroup jobPositionGroup = ((List<JobPositionGroup>) withCriteria {
			eq('code', code)
		})[0]
		return jobPositionGroup
	}

}
