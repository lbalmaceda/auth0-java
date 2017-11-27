package com.auth0.client.mgmt;

import com.auth0.client.mgmt.builder.RequestBuilder;
import com.auth0.client.mgmt.filter.FieldsFilter;
import com.auth0.json.mgmt.tenants.Tenant;
import com.auth0.net.Request;
import com.auth0.utils.Asserts;
import com.fasterxml.jackson.core.type.TypeReference;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

/**
 * Class that provides an implementation of the Tenant Settings methods of the Management API as defined in https://auth0.com/docs/api/management/v2#!/Tenants
 */
@SuppressWarnings("WeakerAccess")
public class TenantsEntity {
    private final RequestBuilder requestBuilder;
    TenantsEntity(OkHttpClient client, HttpUrl baseUrl, String apiToken) {
        requestBuilder = new RequestBuilder(client, baseUrl, apiToken);
    }

    /**
     * Request the Tenant Settings. A token with scope read:tenant_settings is needed.
     * See https://auth0.com/docs/api/management/v2#!/Tenants/get_settings
     *
     * @param filter the filter to use. Can be null.
     * @return a Request to execute.
     */
    public Request<Tenant> get(FieldsFilter filter) {
        return requestBuilder.get("api/v2/tenants/settings")
                             .queryParameters(filter)
                             .request(new TypeReference<Tenant>() {
                             });
    }

    /**
     * Update the Tenant Settings. A token with scope update:tenant_settings is needed.
     * See https://auth0.com/docs/api/management/v2#!/Tenants/patch_settings
     *
     * @param tenant the tenant data to set.
     * @return a Request to execute.
     */
    public Request<Tenant> update(Tenant tenant) {
        Asserts.assertNotNull(tenant, "tenant");

        return requestBuilder.patch("api/v2/tenants/settings")
                             .body(tenant)
                             .request(new TypeReference<Tenant>() {
                             });
    }
}
