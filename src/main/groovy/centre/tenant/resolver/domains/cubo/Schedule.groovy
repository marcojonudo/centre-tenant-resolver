package centre.tenant.resolver.domains.cubo

import grails.gorm.MultiTenant
import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity

import java.sql.Time

@Entity
class Schedule implements GormEntity<Schedule>, MultiTenant {

    Time morningStart
    Time morningEnd
    Time afternoonStart
    Time afternoonEnd
    ScheduleType type
    float hours
    Date dateCreated

    static constraints = {
        morningStart nullable: true, validator: { Date value, Schedule scheduleDay ->
            if (value) {
                return scheduleDay.morningEnd as boolean
            }
        }
        morningEnd nullable: true, validator: { Date value, Schedule scheduleDay ->
            if (value) {
                return scheduleDay.morningStart as boolean
            }
        }
        afternoonStart nullable: true, validator: { Date value, Schedule scheduleDay ->
            if (value) {
                return scheduleDay.afternoonEnd as boolean
            }
        }
        afternoonEnd nullable: true, validator: { Date value, Schedule scheduleDay ->
            if (value) {
                return scheduleDay.afternoonStart as boolean
            }
        }
    }

    static mapping = {
        version defaultValue: 0
        dateCreated defaultValue: new Date()
    }

    static hasMany = [employeeSchedule: EmployeeSchedule]
    static belongsTo = [EmployeeSchedule, ScheduleWeekTemplate]

    enum ScheduleType {

        MORNING({ Schedule scheduleDay -> scheduleDay.morningStart && !scheduleDay.afternoonStart }),
        AFTERNOON({ Schedule scheduleDay -> !scheduleDay.morningStart && scheduleDay.afternoonStart }),
        FULL_TIME({ Schedule scheduleDay -> scheduleDay.morningStart && scheduleDay.afternoonStart }),
        ABSENCE({ Schedule scheduleDay -> !scheduleDay.morningStart && !scheduleDay.afternoonStart }),

        final Closure criteria

        ScheduleType(Closure criteria) {
            this.criteria = criteria
        }

    }

//    @GrailsCompileStatic
//    static Schedule getExistent(UpdateEmployeeScheduleJson.Schedule scheduleInfo) {
//        Schedule schedule = findByMorningStartAndMorningEndAndAfternoonStartAndAfternoonEndAndDeleted(
//                scheduleInfo.morningStart, scheduleInfo.morningEnd, scheduleInfo.afternoonStart, scheduleInfo.afternoonEnd, false
//        )
//        return schedule
//    }
//
//    @GrailsCompileStatic
//    static Schedule getExistent(IfvTemplate dayTemplate) {
//        Schedule schedule
//        if (!dayTemplate.morningStart) {
//            schedule = findByMorningStartIsNullAndMorningEndIsNullAndAfternoonStartAndAfternoonEndAndDeleted(
//                    CommonFunctionality.parseMinutes(dayTemplate.afternoonStart),
//                    CommonFunctionality.parseMinutes(dayTemplate.afternoonEnd),
//                    false
//            )
//        } else if (!dayTemplate.afternoonStart) {
//            schedule = findByMorningStartAndMorningEndAndAfternoonStartIsNullAndAfternoonEndIsNullAndDeleted(
//                    CommonFunctionality.parseMinutes(dayTemplate.morningStart),
//                    CommonFunctionality.parseMinutes(dayTemplate.morningEnd),
//                    false
//            )
//        } else {
//            schedule = findByMorningStartAndMorningEndAndAfternoonStartAndAfternoonEndAndDeleted(
//                    CommonFunctionality.parseMinutes(dayTemplate.morningStart),
//                    CommonFunctionality.parseMinutes(dayTemplate.morningEnd),
//                    CommonFunctionality.parseMinutes(dayTemplate.afternoonStart),
//                    CommonFunctionality.parseMinutes(dayTemplate.afternoonEnd),
//                    false
//            )
//        }
//        return schedule
//    }
//
//    @CompileStatic
//    static Schedule create(UpdateEmployeeScheduleJson.Schedule saveScheduleInfo) {
//        Schedule schedule = new Schedule(
//                morningStart: saveScheduleInfo.morningStart,
//                morningEnd: saveScheduleInfo.morningEnd,
//                afternoonStart: saveScheduleInfo.afternoonStart,
//                afternoonEnd: saveScheduleInfo.afternoonEnd,
//                type: saveScheduleInfo.type,
//                hours: saveScheduleInfo.hours
//        )
//        return schedule
//    }

}
