package centre.tenant.resolver.tenant.resolver

import io.micronaut.http.HttpRequest
import io.micronaut.http.context.ServerRequestContext
import org.grails.datastore.mapping.multitenancy.TenantResolver
import org.grails.datastore.mapping.multitenancy.exceptions.TenantNotFoundException
import javax.inject.Singleton

@Singleton
class CustomTenantResolver implements TenantResolver {

	private static final TENANTS_KEYS = ['centre', 'database']

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
			String tenantId = tenantIds.join("-")
			return tenantId
		}
		throw new TenantNotFoundException("Tenant could not be resolved from HTTP Header: ${TENANTS_KEYS.collect { "'$it'" }.join(", ")}")
	}

}
