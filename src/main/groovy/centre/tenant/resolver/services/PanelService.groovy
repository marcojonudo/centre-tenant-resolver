package centre.tenant.resolver.services

import centre.tenant.resolver.domains.Store
import centre.tenant.resolver.services.data.StoreService
import groovy.transform.CompileStatic

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@CompileStatic
class PanelService {

	private final StoreService storeService

	PanelService(StoreService storeService) {
		this.storeService = storeService
	}

	void test() {
//		Store stores = (Store) Store.createCriteria().get {
//			eq('code', 801)
//		}
//		List<Store> name = (List<Store>) Store.createCriteria().list {
//
//		}
		List<Store> tt = storeService.findAll()
//		List<Store> tttt = Store.list()
		int a = 1

	}

}
