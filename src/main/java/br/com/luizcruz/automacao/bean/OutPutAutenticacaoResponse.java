package br.com.luizcruz.automacao.bean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "access_token",
    "token_type",
    "expires_in"
})
public class OutPutAutenticacaoResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("expires_in")
    private Integer expiresIn;
    
    @JsonProperty("error")
    private OutPutAutResponseError error;
    
    @JsonIgnore
    private Map<String, Object> mapaDadosAdicionais = new HashMap<String, Object>();

    @JsonProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    @JsonProperty("access_token")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public OutPutAutenticacaoResponse withAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    @JsonProperty("token_type")
    public String getTokenType() {
        return tokenType;
    }

    @JsonProperty("token_type")
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public OutPutAutenticacaoResponse withTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    @JsonProperty("expires_in")
    public Integer getExpiresIn() {
        return expiresIn;
    }

    @JsonProperty("expires_in")
    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public OutPutAutenticacaoResponse withExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }
    
    @JsonProperty("error")
    public OutPutAutResponseError getOutPutAutResponseError() {
        return error;
    }

    @JsonProperty("error")
    public void setOutPutAutResponseError(OutPutAutResponseError error) {
        this.error = error;
    }

    public OutPutAutenticacaoResponse withOutPutAutResponseError(OutPutAutResponseError error) {
        this.error = error;
        return this;
    }
    
    @JsonAnyGetter
    public Map<String, Object> getMapaDadosAdicionais() {
		return mapaDadosAdicionais;
	}

    @JsonAnySetter
	public void setMapaDadosAdicionais(Map<String, Object> mapaDadosAdicionais) {
		this.mapaDadosAdicionais = mapaDadosAdicionais;
	}
	
    public OutPutAutenticacaoResponse withMapaDadosAdicionais(Map<String, Object> mapaDadosAdicionais) {
        this.mapaDadosAdicionais = mapaDadosAdicionais;
        return this;
    }

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(accessToken).append(tokenType).append(expiresIn).append(error).append(mapaDadosAdicionais).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OutPutAutenticacaoResponse) == false) {
            return false;
        }
        OutPutAutenticacaoResponse rhs = ((OutPutAutenticacaoResponse) other);
        return new EqualsBuilder().append(accessToken, rhs.accessToken).append(tokenType, rhs.tokenType).append(expiresIn, rhs.expiresIn).append(error, rhs.error).append(mapaDadosAdicionais, rhs.mapaDadosAdicionais).isEquals();
    }

}

