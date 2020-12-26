package com.ashokit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="STATE_MASTER")
public class StateMaster implements Serializable {

	@Id
	@Column(name="STATE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer stateId;
	
	@Column(name="STATE_NAME")
	private String stateName;
	
	CountryMaster countryId;

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public CountryMaster getCountryId() {
		return countryId;
	}

	public void setCountryId(CountryMaster countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "StateMaster [stateId=" + stateId + ", stateName=" + stateName + ", countryId=" + countryId + "]";
	}

	
	
	
}
