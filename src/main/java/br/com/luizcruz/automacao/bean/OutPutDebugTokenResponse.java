package br.com.luizcruz.automacao.bean;

import java.util.HashMap;
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
    "data"
})
public class OutPutDebugTokenResponse {

	   @JsonProperty("data")
	    private DebugToken debugToken;
	    @JsonIgnore
	    private Map<String, Object> mapaDadosAdicionais = new HashMap<String, Object>();

	    @JsonProperty("data")
	    public DebugToken getData() {
	        return debugToken;
	    }

	    @JsonProperty("data")
	    public void setData(DebugToken debugToken) {
	        this.debugToken = debugToken;
	    }

	    public OutPutDebugTokenResponse withData(DebugToken debugToken) {
	        this.debugToken = debugToken;
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

	    public OutPutDebugTokenResponse withMapaDadosAdicionais(String name, Object value) {
	        this.mapaDadosAdicionais.put(name, value);
	        return this;
	    }

	    @Override
	    public int hashCode() {
	        return new HashCodeBuilder().append(debugToken).append(mapaDadosAdicionais).toHashCode();
	    }

	    @Override
	    public boolean equals(Object other) {
	        if (other == this) {
	            return true;
	        }
	        if ((other instanceof OutPutDebugTokenResponse) == false) {
	            return false;
	        }
	        OutPutDebugTokenResponse rhs = ((OutPutDebugTokenResponse) other);
	        return new EqualsBuilder().append(debugToken, rhs.debugToken).append(mapaDadosAdicionais, rhs.mapaDadosAdicionais).isEquals();
	    }
}
