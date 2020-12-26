package com.ashokit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CITY_MASTER")
public class CityMaster implements Serializable {
	
	@Id
	@Column(name="CITY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cityId;

	@Column(name="CITY_NAME")
	private String cityName;
	
	private StateMaster stateId;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public StateMaster getStateId() {
		return stateId;
	}

	public void setStateId(StateMaster stateId) {
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "CityMaster [cityId=" + cityId + ", cityName=" + cityName + ", stateId=" + stateId + "]";
	}

	
	
	
	
}
