package centre.tenant.resolver.pogos.dataSources

import groovy.transform.CompileStatic

@CompileStatic
class DbConfig {

	private static final Map<String, Object> CENTRE_CONFIG_CREDENTIALS = [
			'username': (Object) 'root',
			'password': 'hawai50'
	]

	private static final Map<String, Object> LOCAL_CONFIG_CREDENTIALS = [
			'username': (Object) 'root',
			'password': 'root'
	]

	Map<String, Object> config = [
			'username': (Object) 'root',
			'password': 'hawai50'
	]

	DbConfig(String database, Integer centreCode) {
		String url = "jdbc:mysql://${centreCode ? "192.9.$centreCode.1" : "localhost"}:3306/$database"
		config.url = url
	}

}
