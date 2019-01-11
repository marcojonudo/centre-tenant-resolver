package centre.tenant.resolver.services.data

import centre.tenant.resolver.domains.cubo.Schedule
import centre.tenant.resolver.domains.cubo.ScheduleWeekTemplate
import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.services.Service

@CurrentTenant
@Service(ScheduleWeekTemplate)
interface ScheduleWeekTemplateDataService {

	List<ScheduleWeekTemplate> findAll()
	ScheduleWeekTemplate find(String description)
	ScheduleWeekTemplate save(String description, Schedule day0, Schedule day1, Schedule day2, Schedule day3, Schedule day4, Schedule day5, Schedule day6)

}
