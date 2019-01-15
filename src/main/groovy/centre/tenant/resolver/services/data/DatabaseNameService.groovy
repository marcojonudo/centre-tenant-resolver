package centre.tenant.resolver.services.data

import centre.tenant.resolver.domains.DatabaseName
import grails.gorm.services.Service

import javax.inject.Singleton

@Singleton
@Service(DatabaseName)
abstract class DatabaseNameService implements DatabaseNameDataService {

	@Override
	List<DatabaseName> findAll() {
		(List<DatabaseName>) DatabaseName.createCriteria().list {}
	}
	abstract DatabaseName save(String name)


}
