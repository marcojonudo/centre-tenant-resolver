package centre.tenant.resolver.domains.cubo

import grails.gorm.MultiTenant
import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity

@Entity
class JobPosition implements GormEntity<JobPosition>, MultiTenant {

	String code
	String name

	static constraints = {
		jobPositionGroup nullable: true
	}

	static mapping = {
		version defaultValue: 0
	}

	static hasOne = [jobPositionGroup: JobPositionGroup]

}
