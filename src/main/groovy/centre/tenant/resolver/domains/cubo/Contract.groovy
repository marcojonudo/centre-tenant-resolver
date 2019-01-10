package centre.tenant.resolver.domains.cubo

import grails.gorm.MultiTenant
import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity

@Entity
class Contract implements GormEntity<Contract>, MultiTenant {

	Employee employee
	java.sql.Date start
	java.sql.Date end
	JobPosition jobPosition
	Integer weekHours

	static constraints = { 
		end nullable: true
	}

	static mapping = {
		version defaultValue: 0
	}
	
}
