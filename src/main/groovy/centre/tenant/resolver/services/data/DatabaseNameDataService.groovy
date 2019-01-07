package centre.tenant.resolver.services.data

import centre.tenant.resolver.domains.DatabaseName
import grails.gorm.services.Service

import javax.inject.Singleton

@Singleton
@Service(DatabaseName)
interface DatabaseNameDataService {

	List<DatabaseName> findAll()

}
