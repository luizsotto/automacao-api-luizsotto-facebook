package br.com.luizcruz.automacao.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "app_id",
    "type",
    "application",
    "data_access_expires_at",
    "expires_at",
    "is_valid",
    "issued_at",
    "scopes",
    "user_id"
})
public class DebugToken {

    @JsonProperty("app_id")
    private String appId;
    @JsonProperty("type")
    private String type;
    @JsonProperty("application")
    private String application;
    @JsonProperty("data_access_expires_at")
    private Integer dataAccessExpiresAt;
    @JsonProperty("expires_at")
    private Integer expiresAt;
    @JsonProperty("is_valid")
    private Boolean isValid;
    @JsonProperty("issued_at")
    private Integer issuedAt;
    @JsonProperty("scopes")
    private List<String> scopes = new ArrayList<String>();
    @JsonProperty("user_id")
    private String userId;
    @JsonIgnore
    private Map<String, Object> mapaDadosAdicionais = new HashMap<String, Object>();

    @JsonProperty("app_id")
    public String getAppId() {
        return appId;
    }

    @JsonProperty("app_id")
    public void setAppId(String appId) {
        this.appId = appId;
    }

    public DebugToken withAppId(String appId) {
        this.appId = appId;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public DebugToken withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("application")
    public String getApplication() {
        return application;
    }

    @JsonProperty("application")
    public void setApplication(String application) {
        this.application = application;
    }

    public DebugToken withApplication(String application) {
        this.application = application;
        return this;
    }

    @JsonProperty("data_access_expires_at")
    public Integer getDebugTokenAccessExpiresAt() {
        return dataAccessExpiresAt;
    }

    @JsonProperty("data_access_expires_at")
    public void setDebugTokenAccessExpiresAt(Integer dataAccessExpiresAt) {
        this.dataAccessExpiresAt = dataAccessExpiresAt;
    }

    public DebugToken withDebugTokenAccessExpiresAt(Integer dataAccessExpiresAt) {
        this.dataAccessExpiresAt = dataAccessExpiresAt;
        return this;
    }

    @JsonProperty("expires_at")
    public Integer getExpiresAt() {
        return expiresAt;
    }

    @JsonProperty("expires_at")
    public void setExpiresAt(Integer expiresAt) {
        this.expiresAt = expiresAt;
    }

    public DebugToken withExpiresAt(Integer expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }

    @JsonProperty("is_valid")
    public Boolean getIsValid() {
        return isValid;
    }

    @JsonProperty("is_valid")
    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public DebugToken withIsValid(Boolean isValid) {
        this.isValid = isValid;
        return this;
    }

    @JsonProperty("issued_at")
    public Integer getIssuedAt() {
        return issuedAt;
    }

    @JsonProperty("issued_at")
    public void setIssuedAt(Integer issuedAt) {
        this.issuedAt = issuedAt;
    }

    public DebugToken withIssuedAt(Integer issuedAt) {
        this.issuedAt = issuedAt;
        return this;
    }

    @JsonProperty("scopes")
    public List<String> getScopes() {
        return scopes;
    }

    @JsonProperty("scopes")
    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    public DebugToken withScopes(List<String> scopes) {
        this.scopes = scopes;
        return this;
    }

    @JsonProperty("user_id")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public DebugToken withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getMapaDadosAdicionais() {
        return this.mapaDadosAdicionais;
    }

    @JsonAnySetter
    public void setMapaDadosAdicionais(String name, Object value) {
        this.mapaDadosAdicionais.put(name, value);
    }

    public DebugToken withMapaDadosAdicionais(String name, Object value) {
        this.mapaDadosAdicionais.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(appId).append(type).append(application).append(dataAccessExpiresAt).append(expiresAt).append(isValid).append(issuedAt).append(scopes).append(userId).append(mapaDadosAdicionais).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DebugToken) == false) {
            return false;
        }
        DebugToken rhs = ((DebugToken) other);
        return new EqualsBuilder().append(appId, rhs.appId).append(type, rhs.type).append(application, rhs.application).append(dataAccessExpiresAt, rhs.dataAccessExpiresAt).append(expiresAt, rhs.expiresAt).append(isValid, rhs.isValid).append(issuedAt, rhs.issuedAt).append(scopes, rhs.scopes).append(userId, rhs.userId).append(mapaDadosAdicionais, rhs.mapaDadosAdicionais).isEquals();
    }

}
