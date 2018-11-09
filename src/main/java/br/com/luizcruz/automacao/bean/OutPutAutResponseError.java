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
    "message",
    "type",
    "code",
    "fbtrace_id"
})
public class OutPutAutResponseError {

    @JsonProperty("message")
    private String message;
    @JsonProperty("type")
    private String type;
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("fbtrace_id")
    private String fbtraceId;
    @JsonIgnore
    private Map<String, Object> mapaDadosAdicionais = new HashMap<String, Object>();

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    public OutPutAutResponseError withMessage(String message) {
        this.message = message;
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

    public OutPutAutResponseError withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("code")
    public Integer getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(Integer code) {
        this.code = code;
    }

    public OutPutAutResponseError withCode(Integer code) {
        this.code = code;
        return this;
    }

    @JsonProperty("fbtrace_id")
    public String getFbtraceId() {
        return fbtraceId;
    }

    @JsonProperty("fbtrace_id")
    public void setFbtraceId(String fbtraceId) {
        this.fbtraceId = fbtraceId;
    }

    public OutPutAutResponseError withFbtraceId(String fbtraceId) {
        this.fbtraceId = fbtraceId;
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

    public OutPutAutResponseError withMapaDadosAdicionais(String name, Object value) {
        this.mapaDadosAdicionais.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(message).append(type).append(code).append(fbtraceId).append(mapaDadosAdicionais).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OutPutAutResponseError) == false) {
            return false;
        }
        OutPutAutResponseError rhs = ((OutPutAutResponseError) other);
        return new EqualsBuilder().append(message, rhs.message).append(type, rhs.type).append(code, rhs.code).append(fbtraceId, rhs.fbtraceId).append(mapaDadosAdicionais, rhs.mapaDadosAdicionais).isEquals();
    }
}
