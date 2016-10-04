package com.tutorialspoint.model;

public class Geography {
	private String WORLDWIDE = "Worldwide Geographic Data";
	private String data;
	
	public Geography() {
		super();
	}

	public Geography(String data) {
		super();
		this.data = WORLDWIDE + " and data for "+data;
		
	}

	public String getData() {
		return data;
	}

	
}
