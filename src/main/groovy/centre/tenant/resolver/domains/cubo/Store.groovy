package centre.tenant.resolver.domains.cubo

import grails.gorm.MultiTenant
import grails.gorm.annotation.Entity
import groovy.transform.CompileStatic
import org.grails.datastore.gorm.GormEntity

@Entity
class Store implements GormEntity<Store>, MultiTenant {

	int code
	String name
	String region
	StoreType storeType
	Country country
	String provincia
	String language

    static constraints = {		
		name blank: false, maxLength: 40
		region nullable: true, blank: true
		provincia nullable: true, blank: true
    }
	
	static mapping = {
		version false
		id name:'code', generator : 'assigned'		
	}

	enum StoreType {

		AC,
		CS,
		ACF,
		CSF

	}

	enum Country {

		SP,
		PT,
		FR,
		FV

	}

	String getCode3() {
		return String.format("%03d", code)
	}
	
	public String toString(){
		return String.format("%03d", code)
	}

	@CompileStatic
	static Store getByCode(int code) {
		Store store = (Store) createCriteria().get {
			eq('code', code)
		}
		return store
	}

}
