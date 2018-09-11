package com.cleartax.beans;


public class Applicant{

	String tokenId;
	
	long arrivalTime;
	
	
	Application application;
	
	
	public String getTokenId() {
		return tokenId;
	}


	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}


	public Application getApplication() {
		return application;
	}


	public void setApplication(Application application) {
		this.application = application;
	}


	public long getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(long arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public Applicant(String tokenId) {
		this.tokenId = tokenId;
		arrivalTime = System.currentTimeMillis();
				;
	}
	
	
	

}
