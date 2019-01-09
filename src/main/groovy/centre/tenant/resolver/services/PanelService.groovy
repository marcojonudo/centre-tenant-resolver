package centre.tenant.resolver.services

import centre.tenant.resolver.services.data.CentreService
import centre.tenant.resolver.services.data.DatabaseNameService
import groovy.transform.CompileStatic
import org.grails.orm.hibernate.HibernateDatastore
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.inject.Singleton

@Singleton
@CompileStatic
class PanelService {

	private static final Logger LOG = LoggerFactory.getLogger(PanelService)

	private final HibernateDatastore hibernateDatastore
	private final CentreService centreService
	private final DatabaseNameService databaseNameService

	PanelService(HibernateDatastore hibernateDatastore, CentreService centreService, DatabaseNameService databaseNameService) {
		this.hibernateDatastore = hibernateDatastore
		this.centreService = centreService
		this.databaseNameService = databaseNameService
	}

	void test() {
	}

}
