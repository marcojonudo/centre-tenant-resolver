package centre.tenant.resolver.services.data

import centre.tenant.resolver.domains.Configuration
import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.services.Service

@CurrentTenant
@Service(Configuration)
interface ConfigurationDataService {

	List<Configuration> findAll()
	Configuration find(String clave)

}
