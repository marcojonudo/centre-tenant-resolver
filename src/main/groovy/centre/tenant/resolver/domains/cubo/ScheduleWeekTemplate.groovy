package centre.tenant.resolver.domains.cubo

import grails.gorm.MultiTenant
import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity

@Entity
class ScheduleWeekTemplate implements GormEntity<ScheduleWeekTemplate>, MultiTenant {

    String description
	/* day0 is monday */
	Schedule day0
	Schedule day1
	Schedule day2
	Schedule day3
	Schedule day4
	Schedule day5
	Schedule day6
	float hours
    boolean deleted
	Date dateCreated
	Date dateUpdated

    static constraints = {
        description maxSize: 255
	    day0 nullable: true
	    day1 nullable: true
	    day2 nullable: true
	    day3 nullable: true
	    day4 nullable: true
	    day5 nullable: true
	    day6 nullable: true
    }

    static mapping = {
        version defaultValue: 0
	    dateCreated defaultValue: new Date()
	    dateUpdated defaultValue: new Date()
    }

	static hasMany = [employees: Employee]

//	@CompileStatic
//	static List<ScheduleWeekTemplate> getAll(Closure criteria) {
//		List<ScheduleWeekTemplate> templates = ((List<ScheduleWeekTemplate>) withCriteria(criteria)).findAll { !it.deleted }
//		return templates
//	}
//
//	@CompileStatic
//	static ScheduleWeekTemplate getByDescription(String description) {
//		ScheduleWeekTemplate template = (ScheduleWeekTemplate) createCriteria().get {
//			eq('description', description)
//			eq('deleted', false)
//		}
//		return template
//	}
//
//	@CompileStatic
//	static ScheduleWeekTemplate create(String description, List<Schedule> schedules) {
//		ScheduleWeekTemplate scheduleWeekTemplate = new ScheduleWeekTemplate(
//				description: description,
//				day0: schedules[0],
//				day1: schedules[1],
//				day2: schedules[2],
//				day3: schedules[3],
//				day4: schedules[4],
//				day5: schedules[5],
//				day6: schedules[6]
//		)
//		scheduleWeekTemplate.hours = (float) schedules.hours.findAll { it }.sum()
//		return scheduleWeekTemplate
//	}

}
