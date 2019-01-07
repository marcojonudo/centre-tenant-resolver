package centre.tenant.resolver.domains

import grails.gorm.MultiTenant
import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity

@Entity
class Store implements GormEntity<Store> {

	int code
	String country
	String name
	String language
	String provincia
	String region
	String storeType

	enum Language {

		es, pt

	}

	enum Region {

		A, B, C, D, E, P

	}

	enum Type {

		AC

	}

//	static constraints = {
//		name maxSize: 45
//		language maxSize: 5
//		region maxSize: 1
//		type maxSize: 2
//	}

}
