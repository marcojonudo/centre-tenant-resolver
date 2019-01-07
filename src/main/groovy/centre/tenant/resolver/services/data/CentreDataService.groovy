package centre.tenant.resolver.services.data

import centre.tenant.resolver.domains.Centre
import grails.gorm.services.Service

import javax.inject.Singleton

@Singleton
@Service(Centre)
interface CentreDataService {

	List<Centre> findAll()

}
