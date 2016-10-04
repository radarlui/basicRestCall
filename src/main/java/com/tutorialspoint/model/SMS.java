package com.tutorialspoint.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SMS {
	private int id;
	private String from;
	private String to;
	private String characters;
	private String timeStamp;
	private boolean read;
	
	public SMS() {
		super();
	}

	public SMS(int id, String from, String to, String characters) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.characters = characters;
	}

	public SMS(int id, String from, String to, String characters, boolean read) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.characters = characters;
		this.read = read;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getCharacters() {
		return characters;
	}

	public void setCharacters(String characters) {
		this.characters = characters;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}


	
}
