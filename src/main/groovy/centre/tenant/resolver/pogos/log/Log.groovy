package centre.tenant.resolver.pogos.log

import groovy.json.JsonBuilder
import groovy.transform.CompileStatic
import javax.inject.Singleton

@Singleton
@CompileStatic
class Log {

	String identifier
	Object message

	@Override
	String toString() {
		return new JsonBuilder(this)
	}

}
