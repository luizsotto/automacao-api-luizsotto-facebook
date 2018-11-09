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
    "access_token",
    "category",
    "category_list",
    "name",
    "id",
    "tasks"
})
public class Account {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("category")
    private String category;
    @JsonProperty("category_list")
    private List<Categorias> categoryList = new ArrayList<Categorias>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;
    @JsonProperty("tasks")
    private List<String> tasks = new ArrayList<String>();
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

    public Account withAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    public Account withCategory(String category) {
        this.category = category;
        return this;
    }

    @JsonProperty("category_list")
    public List<Categorias> getCategoryList() {
        return categoryList;
    }

    @JsonProperty("category_list")
    public void setCategoryList(List<Categorias> categoryList) {
        this.categoryList = categoryList;
    }

    public Account withCategoryList(List<Categorias> categoryList) {
        this.categoryList = categoryList;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Account withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Account withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("tasks")
    public List<String> getTasks() {
        return tasks;
    }

    @JsonProperty("tasks")
    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    public Account withTasks(List<String> tasks) {
        this.tasks = tasks;
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

    public Account withMapaDadosAdicionais(String name, Object value) {
        this.mapaDadosAdicionais.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(accessToken).append(category).append(categoryList).append(name).append(id).append(tasks).append(mapaDadosAdicionais).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Account) == false) {
            return false;
        }
        Account rhs = ((Account) other);
        return new EqualsBuilder().append(accessToken, rhs.accessToken).append(category, rhs.category).append(categoryList, rhs.categoryList).append(name, rhs.name).append(id, rhs.id).append(tasks, rhs.tasks).append(mapaDadosAdicionais, rhs.mapaDadosAdicionais).isEquals();
    }

}
