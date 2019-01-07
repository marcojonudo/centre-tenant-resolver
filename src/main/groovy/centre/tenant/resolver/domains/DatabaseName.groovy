package centre.tenant.resolver.domains

import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity

@Entity
class DatabaseName implements GormEntity<DatabaseName> {

	String name

	static constraints = {
		name maxSize: 45
	}

}
