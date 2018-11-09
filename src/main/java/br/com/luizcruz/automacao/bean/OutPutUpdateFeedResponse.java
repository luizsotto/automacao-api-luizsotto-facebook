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
    "success"
})
public class OutPutUpdateFeedResponse {

	@JsonProperty("success")
    private String success;
    @JsonProperty("error")
    private OutPutAutResponseError error;
    
    @JsonIgnore
    private Map<String, Object> mapaDadosAdicionais = new HashMap<String, Object>();

    @JsonProperty("success")
    public String getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(String id) {
        this.success = id;
    }

    public OutPutUpdateFeedResponse withSuccess(String id) {
        this.success = id;
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

    public OutPutUpdateFeedResponse withOutPutAutResponseError(OutPutAutResponseError error) {
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

    public OutPutUpdateFeedResponse withMapaDadosAdicionais(String name, Object value) {
        this.mapaDadosAdicionais.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(success).append(error).append(mapaDadosAdicionais).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OutPutUpdateFeedResponse) == false) {
            return false;
        }
        OutPutUpdateFeedResponse rhs = ((OutPutUpdateFeedResponse) other);
        return new EqualsBuilder().append(success, rhs.success).append(error, rhs.error).append(mapaDadosAdicionais, rhs.mapaDadosAdicionais).isEquals();
    }

}
