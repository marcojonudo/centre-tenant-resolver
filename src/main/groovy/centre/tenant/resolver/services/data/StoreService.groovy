package centre.tenant.resolver.services.data

import centre.tenant.resolver.domains.Store
import grails.gorm.services.Service

import javax.inject.Singleton

@Singleton
@Service(Store)
abstract class StoreService implements StoreDataService {

	@Override
	List<Store> findAll() {
		(List<Store>) Store.createCriteria().list {}
	}

}
