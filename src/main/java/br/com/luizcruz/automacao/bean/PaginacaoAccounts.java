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
    "cursors"
})
public class PaginacaoAccounts {

    @JsonProperty("cursors")
    private CursorPaginacao cursors;
    @JsonIgnore
    private Map<String, Object> mapaDadosAdicionais = new HashMap<String, Object>();

    @JsonProperty("cursors")
    public CursorPaginacao getCursors() {
        return cursors;
    }

    @JsonProperty("cursors")
    public void setCursors(CursorPaginacao cursors) {
        this.cursors = cursors;
    }

    public PaginacaoAccounts withCursors(CursorPaginacao cursors) {
        this.cursors = cursors;
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

    public PaginacaoAccounts withMapaDadosAdicionais(String name, Object value) {
        this.mapaDadosAdicionais.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cursors).append(mapaDadosAdicionais).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PaginacaoAccounts) == false) {
            return false;
        }
        PaginacaoAccounts rhs = ((PaginacaoAccounts) other);
        return new EqualsBuilder().append(cursors, rhs.cursors).append(mapaDadosAdicionais, rhs.mapaDadosAdicionais).isEquals();
    }

}
