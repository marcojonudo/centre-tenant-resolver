package centre.tenant.resolver.pogos.dataSources

import groovy.transform.CompileStatic
import javax.inject.Singleton

@Singleton
@CompileStatic
class DbConfig {

	private static final LOCALHOST = "localhost"

	private static final Map<String, Object> CENTRE_CONFIG_CREDENTIALS = [
			'username': (Object) 'root',
			'password': 'hawai50'
	]

	private static final Map<String, Object> LOCAL_CONFIG_CREDENTIALS = [
			'username': (Object) 'root',
			'password': 'root'
	]

	Map<String, Object> config

	DbConfig(String database, Integer centreCode = null) {
		String url = "jdbc:mysql://${centreCode ? "192.9.$centreCode.1" : LOCALHOST}:3306/$database?useSSL=false"
		config = centreCode ? CENTRE_CONFIG_CREDENTIALS : LOCAL_CONFIG_CREDENTIALS
		config.url = url
	}

}
