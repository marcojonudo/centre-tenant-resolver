package centre.tenant.resolver.services.data

import centre.tenant.resolver.domains.Centre
import grails.gorm.services.Service

import javax.inject.Singleton

@Singleton
@Service(Centre)
abstract class CentreService implements CentreDataService {

	@Override
	List<Centre> findAll() {
		(List<Centre>) Centre.createCriteria().list {}
	}

}
