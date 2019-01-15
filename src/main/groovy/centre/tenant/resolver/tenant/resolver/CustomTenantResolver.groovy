package centre.tenant.resolver.tenant.resolver

import centre.tenant.resolver.pogos.dataSources.Datastore
import io.micronaut.http.HttpRequest
import io.micronaut.http.context.ServerRequestContext
import org.grails.datastore.mapping.multitenancy.TenantResolver
import org.grails.datastore.mapping.multitenancy.exceptions.TenantNotFoundException
import org.grails.orm.hibernate.HibernateDatastore

import javax.inject.Inject
//@Singleton
class CustomTenantResolver implements TenantResolver {

	private static final TENANTS_KEYS = ['centre', 'database']
	@Inject HibernateDatastore hibernateDatastore

	/**
	 * Resolve the tenantId from the HTTP request
	 * @return Tenant ID if resolved
	 * @throws TenantNotFoundException if tenant not found
	 */
	@Override
	Serializable resolveTenantIdentifier() throws TenantNotFoundException {
		Optional<HttpRequest<Object>> currentRequest = ServerRequestContext.currentRequest()
		if (currentRequest.isPresent()) {
			HttpRequest<Object> httpRequest = currentRequest.get()
			return resolveTenantIdentifierAtRequest(httpRequest)
		} else {
			throw new TenantNotFoundException("Tenant could not be resolved from HttpRequest")
		}
	}

	/**
	 * Build the tenantId from header fields
	 * @param request HttpRequest with headers
	 * @return Tenant ID if both necessary values are found
	 * @throws TenantNotFoundException if one or both values are not found
	 */
	private static Serializable resolveTenantIdentifierAtRequest(HttpRequest<Object> request) throws TenantNotFoundException {
		if (request.headers) {
			List<String> tenantIds = TENANTS_KEYS.collect { request.headers.get(it) }
			int nullIndex = tenantIds.findIndexOf { !it }
			if (nullIndex != -1) {
				throw new TenantNotFoundException("Tenant could not be resolved. Header '${TENANTS_KEYS[nullIndex]}' value is null")
			}
			String tenantId = buildTenantId(tenantIds[0], tenantIds[1])
			tenantId = tenantId in Datastore.dataSourcesNames ? tenantId : tenantIds[1]
			return tenantId
		}
		throw new TenantNotFoundException("Tenant could not be resolved from HTTP Header: ${TENANTS_KEYS.collect { "'$it'" }.join(", ")}")
	}

	/**
	 * Build tenantId based on centre code and database
	 * @param centreCode int centre code
	 * @param database Database name
	 * @return String tenantId
	 */
	static String buildTenantId(String serverId, String database) {
		return "$serverId-$database"
	}

}
