
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
    "escalated"
})
public class JuniorExecutive {

    @JsonProperty("id")
    private String id;
    @JsonProperty("timeTakenInMinutes")
    private String timeTakenInMinutes;
    @JsonProperty("callsAttended")
    private String callsAttended;
    @JsonProperty("resolved")
    private String resolved;
    @JsonProperty("escalated")
    private String escalated;
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

    @JsonProperty("escalated")
    public String getEscalated() {
        return escalated;
    }

    @JsonProperty("escalated")
    public void setEscalated(String escalated) {
        this.escalated = escalated;
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
