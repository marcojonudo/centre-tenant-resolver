package centre.tenant.resolver.services.data

import centre.tenant.resolver.domains.cubo.Schedule
import centre.tenant.resolver.domains.cubo.Schedule.ScheduleType
import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.services.Service

import java.sql.Time

@CurrentTenant
@Service(Schedule)
interface ScheduleDataService {

	Schedule find(Time morningStart, Time morningEnd, Time afternoonStart, Time afternoonEnd, boolean deleted)
	Schedule save(Time morningStart, Time morningEnd, Time afternoonStart, Time afternoonEnd, ScheduleType type)

}
