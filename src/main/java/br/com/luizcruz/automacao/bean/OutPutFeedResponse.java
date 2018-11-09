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
    "id"
})
public class OutPutFeedResponse {

	@JsonProperty("id")
    private String id;
    @JsonProperty("error")
    private OutPutAutResponseError error;
    
    @JsonIgnore
    private Map<String, Object> mapaDadosAdicionais = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public OutPutFeedResponse withId(String id) {
        this.id = id;
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

    public OutPutFeedResponse withOutPutAutResponseError(OutPutAutResponseError error) {
        this.error = error;
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

    public OutPutFeedResponse withMapaDadosAdicionais(String name, Object value) {
        this.mapaDadosAdicionais.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(error).append(mapaDadosAdicionais).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OutPutFeedResponse) == false) {
            return false;
        }
        OutPutFeedResponse rhs = ((OutPutFeedResponse) other);
        return new EqualsBuilder().append(id, rhs.id).append(error, rhs.error).append(mapaDadosAdicionais, rhs.mapaDadosAdicionais).isEquals();
    }

}
