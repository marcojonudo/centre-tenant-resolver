package centre.tenant.resolver.domains

import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity

@Entity
class Centre implements GormEntity<Centre> {

	int code
	String name
	Language language
	Region region
	Type type

	enum Language {

		es, pt

	}

	enum Region {

		A, B, C, D, E, P

	}

	enum Type {

		AC

	}

	static constraints = {
		name maxSize: 45
		language maxSize: 2
		region maxSize: 1
		type maxSize: 2
	}

}
