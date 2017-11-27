package com.auth0.json.mgmt;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class that represents an Auth0 Client Grant object. Related to the {@link com.auth0.client.mgmt.ClientGrantsEntity} entity.
 */
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientGrant {

    @JsonProperty("id")
    private String id;
    @JsonProperty("client_id")
    private String clientId;
    @JsonProperty("audience")
    private String audience;
    @JsonProperty("scope")
    private List<String> scope;

    public ClientGrant() {
    }

    public ClientGrant(String clientId, String audience, List<String> scope) {
        this.clientId = clientId;
        this.audience = audience;
        this.scope = scope;
    }

    /**
     * Getter for the id of the client grant.
     *
     * @return the id.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for the id of the client.
     *
     * @return the client id.
     */
    @JsonProperty("client_id")
    public String getClientId() {
        return clientId;
    }

    /**
     * Setter for the client id.
     *
     * @param clientId the client id to set.
     */
    @JsonProperty("client_id")
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * Getter for the audience.
     *
     * @return the audience.
     */
    @JsonProperty("audience")
    public String getAudience() {
        return audience;
    }

    /**
     * Setter for the audience.
     *
     * @param audience the audience to set.
     */
    @JsonProperty("audience")
    public void setAudience(String audience) {
        this.audience = audience;
    }

    /**
     * Getter for the scope.
     *
     * @return the scope.
     */
    @JsonProperty("scope")
    public List<String> getScope() {
        return scope;
    }

    /**
     * Setter for the scope.
     *
     * @param scope the scope to set.
     */
    @JsonProperty("scope")
    public void setScope(List<String> scope) {
        this.scope = scope;
    }
}
