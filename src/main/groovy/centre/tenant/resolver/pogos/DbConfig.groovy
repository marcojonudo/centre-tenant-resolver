package centre.tenant.resolver.pogos

import groovy.transform.CompileStatic

@CompileStatic
class DbConfig {

	String dataSourceName
	Map<String, Object> config

	DbConfig(int centreCode, String dataSourceName) {
		this.dataSourceName = dataSourceName

		config = [
				'username': (Object) 'root',
				'password': 'root',
				'url': "jdbc:mysql://localhost:3306/${centreCode == 9 ? 'cubo' : 'cubo2'}",
				'connectTimeout': '1000',
				'socketTimeout': '1000'
		]
	}

}
