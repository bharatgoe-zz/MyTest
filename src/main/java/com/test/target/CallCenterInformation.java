package com.test.target;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CallCenterInformation {

	@JsonProperty("je")
	private List<String> je;

	public List<String> getJe() {
		return je;
	}

	public void setJe(List<String> je) {
		this.je = je;
	}

	public List<String> getSe() {
		return se;
	}

	public void setSe(List<String> se) {
		this.se = se;
	}

	public String getMgr() {
		return mgr;
	}

	public void setMgr(String mgr) {
		this.mgr = mgr;
	}

	public String getNumber_of_calls() {
		return number_of_calls;
	}

	public void setNumber_of_calls(String number_of_calls) {
		this.number_of_calls = number_of_calls;
	}

	@JsonProperty("se")
	private List<String> se;

	@JsonProperty("mgr")
	private String mgr;

	@JsonProperty("number_of_calls")
	private String number_of_calls;

}
