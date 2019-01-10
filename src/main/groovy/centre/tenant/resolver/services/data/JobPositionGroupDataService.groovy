package centre.tenant.resolver.services.data

import centre.tenant.resolver.domains.cubo.JobPositionGroup
import centre.tenant.resolver.domains.cubo.JobPositionGroup.JobPositionGroupCode
import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.services.Service

@CurrentTenant
@Service(JobPositionGroup)
interface JobPositionGroupDataService {

	JobPositionGroup get(JobPositionGroupCode code)

}
