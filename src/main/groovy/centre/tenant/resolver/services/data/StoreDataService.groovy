package centre.tenant.resolver.services.data

import centre.tenant.resolver.domains.Store
import grails.gorm.services.Service

import javax.inject.Singleton

@Singleton
@Service(Store)
interface StoreDataService {

	List<Store> findAll()
	Store findByCode(int code)

}
