
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
    "number_of_calls",
    "resolved",
    "unresolved",
    "totalTimeTakenInMinutes",
    "performance"
})
public class Example {

    @JsonProperty("number_of_calls")
    private String numberOfCalls;
    @JsonProperty("resolved")
    private String resolved;
    @JsonProperty("unresolved")
    private String unresolved;
    @JsonProperty("totalTimeTakenInMinutes")
    private String totalTimeTakenInMinutes;
    @JsonProperty("performance")
    private List<Performance> performance = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("number_of_calls")
    public String getNumberOfCalls() {
        return numberOfCalls;
    }

    @JsonProperty("number_of_calls")
    public void setNumberOfCalls(String numberOfCalls) {
        this.numberOfCalls = numberOfCalls;
    }

    @JsonProperty("resolved")
    public String getResolved() {
        return resolved;
    }

    @JsonProperty("resolved")
    public void setResolved(String resolved) {
        this.resolved = resolved;
    }

    @JsonProperty("unresolved")
    public String getUnresolved() {
        return unresolved;
    }

    @JsonProperty("unresolved")
    public void setUnresolved(String unresolved) {
        this.unresolved = unresolved;
    }

    @JsonProperty("totalTimeTakenInMinutes")
    public String getTotalTimeTakenInMinutes() {
        return totalTimeTakenInMinutes;
    }

    @JsonProperty("totalTimeTakenInMinutes")
    public void setTotalTimeTakenInMinutes(String totalTimeTakenInMinutes) {
        this.totalTimeTakenInMinutes = totalTimeTakenInMinutes;
    }

    @JsonProperty("performance")
    public List<Performance> getPerformance() {
        return performance;
    }

    @JsonProperty("performance")
    public void setPerformance(List<Performance> performance) {
        this.performance = performance;
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
