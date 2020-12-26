package com.ashokit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "USER_MASTER")
public class UserMaster implements Serializable {
	
	 @Column(name="REG_ID")
	      @Id
	      @GeneratedValue(strategy = GenerationType.AUTO)
	      private Integer regId;
	
      @Column(name = "FNAME",length = 15)
	      private String fname;
      
      @Column(name = "LNAME",length = 15)
	     private String lname;
    
      
      @Column(name = "EMAIL",length = 15)
	    private String email;
      
      @Column(name = "PHONENO")
	     private Integer phoneNo;
      
      @Column(name="DOB")
	     private Date dob;
      
      @Column(name="GENDER",length = 15)
	    private String gender;
      
      @Column(name="COUNTRY",length = 15)
	     private Integer country;
      
      @Column(name="STATE",length = 15)
	     private Integer state;
      
      @Column(name="CITY",length = 15)
	     private Integer city;
      
      
      @Column(name="PASSWORD",length = 15)
      private String password;
      
      @Column(name="ACN_STATUS")
      private String acnStatus;

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAcnStatus() {
		return acnStatus;
	}

	public void setAcnStatus(String acnStatus) {
		this.acnStatus = acnStatus;
	}

	@Override
	public String toString() {
		return "UserDetails [regId=" + regId + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", dob=" + dob + ", gender=" + gender + ", country=" + country + ", state="
				+ state + ", city=" + city + ", password=" + password + ", acnStatus=" + acnStatus + "]";
	}
     
      
      
}
