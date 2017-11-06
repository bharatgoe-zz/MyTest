
package com.test.target.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "manager",
    "junior-executives",
    "senior-executives"
})
public class Performance {

    @JsonProperty("manager")
    private Manager manager;
    @JsonProperty("junior-executives")
    private List<JuniorExecutive> juniorExecutives = null;
    @JsonProperty("senior-executives")
    private List<SeniorExecutive> seniorExecutives = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("manager")
    public Manager getManager() {
        return manager;
    }

    @JsonProperty("manager")
    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @JsonProperty("junior-executives")
    public List<JuniorExecutive> getJuniorExecutives() {
        return juniorExecutives;
    }

    @JsonProperty("junior-executives")
    public void setJuniorExecutives(List<JuniorExecutive> juniorExecutives) {
        this.juniorExecutives = juniorExecutives;
    }

    @JsonProperty("senior-executives")
    public List<SeniorExecutive> getSeniorExecutives() {
        return seniorExecutives;
    }

    @JsonProperty("senior-executives")
    public void setSeniorExecutives(List<SeniorExecutive> seniorExecutives) {
        this.seniorExecutives = seniorExecutives;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
