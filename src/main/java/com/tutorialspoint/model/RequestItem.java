package com.tutorialspoint.model;

public class RequestItem {
	private String requestName = "";
	private String requestValue = "";
	
	public RequestItem() {
		super();
	}

	public RequestItem(String requestName, String requestValue) {
		super();
		this.requestName = requestName;
		this.requestValue = requestValue;
	}	
	public String getRequestName() {
		return requestName;
	}
	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}
	public String getRequestValue() {
		return requestValue;
	}
	public void setRequestValue(String requestValue) {
		this.requestValue = requestValue;
	}
	
}
