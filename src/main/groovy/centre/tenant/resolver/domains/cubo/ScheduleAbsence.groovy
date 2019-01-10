package centre.tenant.resolver.domains.cubo

import grails.gorm.MultiTenant
import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity

@Entity
class ScheduleAbsence implements GormEntity<ScheduleAbsence>, MultiTenant {

    String code
    String description
    Date dateCreated
    Date dateUpdated
    boolean deleted

    static constraints = {
        code maxSize: 45
        description maxSize: 255
    }

    static mapping = {
        version defaultValue: 0
        dateCreated defaultValue: new Date()
        dateUpdated defaultValue: new Date()
        deleted defaultValue: false
    }

    static hasMany = [employeeSchedule: EmployeeSchedule]

}
