package com.aip.ai4c.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Activity {
	
	@Id
	private String transientId;
	private String deviceId;
	private String cookieId;
	// private String userAgent;
	private String cmsId;
	private String optimizelyId;
	// private String uuIdEmail;
	private String timeStamp;
	
	
	@ManyToOne()
	@JsonProperty("uuIdEmailThirdParty")
	@JoinColumns(@JoinColumn(name = "uuIdEmail", referencedColumnName = "uuIdEmail"))
	private Person uuIdEmail;
	
	public Activity() {

	}

	public Activity(String transientId, String deviceId, String cookieId,
			String cmsId, String optimizelyId, String timeStamp, Person uuIdEmail) {
		super();
		this.transientId = transientId;
		this.deviceId = deviceId;
		this.cookieId = cookieId;
		// this.userAgent = userAgent;
		this.cmsId = cmsId;
		this.optimizelyId = optimizelyId;
		this.timeStamp = timeStamp;
		this.uuIdEmail = uuIdEmail;
	}


	public String getTransientId() {
		return transientId;
	}

	public void setTransientId(String transientId) {
		this.transientId = transientId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getCookieId() {
		return cookieId;
	}

	public void setCookieId(String cookieId) {
		this.cookieId = cookieId;
	}


	public String getCmsId() {
		return cmsId;
	}

	public void setCmsId(String cmsId) {
		this.cmsId = cmsId;
	}

	public String getOptimizelyId() {
		return optimizelyId;
	}

	public void setOptimizelyId(String optimizelyId) {
		this.optimizelyId = optimizelyId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Person getUuIdEmail() {
		return uuIdEmail;
	}

	public void setUuIdEmail(Person uuIdEmail) {
		this.uuIdEmail = uuIdEmail;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cmsId, cookieId, deviceId, optimizelyId, timeStamp, transientId, uuIdEmail);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		return Objects.equals(cmsId, other.cmsId) && Objects.equals(cookieId, other.cookieId)
				&& Objects.equals(deviceId, other.deviceId) && Objects.equals(optimizelyId, other.optimizelyId)
				&& Objects.equals(timeStamp, other.timeStamp) && Objects.equals(transientId, other.transientId)
				&& Objects.equals(uuIdEmail, other.uuIdEmail);
	}

	@Override
	public String toString() {
		return "Activity [transientId=" + transientId + ", deviceId=" + deviceId + ", cookieId=" + cookieId + ", cmsId="
				+ cmsId + ", optimizelyId=" + optimizelyId + ", timeStamp=" + timeStamp + ", uuIdEmailThirdParty="
				+ uuIdEmail + "]";
	}
	
	
	
}
