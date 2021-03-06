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
    "data",
    "paging"
})
public class Publicacoes {

    @JsonProperty("data")
    private List<PageUserFeed> data = new ArrayList<PageUserFeed>();
    @JsonProperty("paging")
    private PaginacaoAccounts paging;
    @JsonIgnore
    private Map<String, Object> mapaDadosAdicionais = new HashMap<String, Object>();

    @JsonProperty("data")
    public List<PageUserFeed> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<PageUserFeed> data) {
        this.data = data;
    }

    public Publicacoes withData(List<PageUserFeed> data) {
        this.data = data;
        return this;
    }

    @JsonProperty("paging")
    public PaginacaoAccounts getPaginacaoAccounts() {
        return paging;
    }

    @JsonProperty("paging")
    public void setPaginacaoAccounts(PaginacaoAccounts paging) {
        this.paging = paging;
    }

    public Publicacoes withPaginacaoAccounts(PaginacaoAccounts paging) {
        this.paging = paging;
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

    public Publicacoes withMapaDadosAdicionais(String name, Object value) {
        this.mapaDadosAdicionais.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(data).append(paging).append(mapaDadosAdicionais).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Publicacoes) == false) {
            return false;
        }
        Publicacoes rhs = ((Publicacoes) other);
        return new EqualsBuilder().append(data, rhs.data).append(paging, rhs.paging).append(mapaDadosAdicionais, rhs.mapaDadosAdicionais).isEquals();
    }

}
