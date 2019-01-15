package centre.tenant.resolver.services

import centre.tenant.resolver.domains.DatabaseName
import centre.tenant.resolver.pogos.log.Log
import centre.tenant.resolver.services.data.CentreService
import centre.tenant.resolver.services.data.DatabaseNameService
import centre.tenant.resolver.utils.Constants
import groovy.transform.CompileStatic
import org.grails.orm.hibernate.HibernateDatastore
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.inject.Singleton

@Singleton
@CompileStatic
class TenantService {

	private static final Logger LOG = LoggerFactory.getLogger(TenantService)

	private final HibernateDatastore hibernateDatastore
	private final CentreService centreService
	private final DatabaseNameService databaseNameService

	TenantService(HibernateDatastore hibernateDatastore, CentreService centreService, DatabaseNameService databaseNameService) {
		this.hibernateDatastore = hibernateDatastore
		this.centreService = centreService
		this.databaseNameService = databaseNameService
	}

	void saveDatabase(String database) {
		DatabaseName databaseName = databaseNameService.save(null)
		LOG.info(new Log(identifier: Constants.Log.SAVE_DATABASE_NAME, message: 'hola').toString())

//		if (!databaseName.save()) {
//			LOG.error(new Log(identifier: Constants.Log.SAVE_DATABASE_NAME, message: databaseName).toString())
//		}
//		centreService.findAll()
	}

}
