package centre.tenant.resolver.domains.cubo

import grails.gorm.MultiTenant
import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity
import java.sql.Time

@Entity
class CentreSchedule implements GormEntity<CentreSchedule>, MultiTenant {

    java.sql.Date day
    Time start
    Time end
    Date dateCreated
    Date dateUpdated
    Date dateDeleted

    static constraints = {
        day nullable: true
        dateUpdated nullable: true
        dateDeleted nullable: true
    }

    static mapping = {
        datasource 'cubo'
        version defaultValue: 0
        dateCreated defaultValue: new Date()
        dateUpdated defaultValue: new Date()
    }

//    @CompileStatic
//    static CentreSchedule getByDay(java.sql.Date day) {
//        CentreSchedule centreSchedule = (CentreSchedule) createCriteria().get {
//            eq('day', day)
//            eq('deleted', false)
//        }
//        centreSchedule = centreSchedule ?: (CentreSchedule) createCriteria().get {
//            isNull('day')
//            eq('deleted', false)
//        }
//
//        return centreSchedule
//    }
//
//    @CompileStatic
//    static CentreSchedule create(java.sql.Date day) {
//        CentreSchedule employeeSchedule = new CentreSchedule(
//                day: day
//        )
//        return employeeSchedule
//    }

}
