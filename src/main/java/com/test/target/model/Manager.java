
package com.test.target.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "timeTakenInMinutes",
    "callsAttended",
    "resolved",
    "unresolved"
})
public class Manager {

    @JsonProperty("id")
    private String id;
    @JsonProperty("timeTakenInMinutes")
    private String timeTakenInMinutes;
    @JsonProperty("callsAttended")
    private String callsAttended;
    @JsonProperty("resolved")
    private String resolved;
    @JsonProperty("unresolved")
    private String unresolved;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("timeTakenInMinutes")
    public String getTimeTakenInMinutes() {
        return timeTakenInMinutes;
    }

    @JsonProperty("timeTakenInMinutes")
    public void setTimeTakenInMinutes(String timeTakenInMinutes) {
        this.timeTakenInMinutes = timeTakenInMinutes;
    }

    @JsonProperty("callsAttended")
    public String getCallsAttended() {
        return callsAttended;
    }

    @JsonProperty("callsAttended")
    public void setCallsAttended(String callsAttended) {
        this.callsAttended = callsAttended;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
