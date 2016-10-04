package com.tutorialspoint.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Greeting {
	private long id;
	private String content;
	private String header;
	
	public Greeting() {
		super();
	}

	public Greeting(long id, String content, String header) {
		super();
		this.id = id;
		this.content = content;
		this.header = header;
	}
    
	public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

	public String getHeader() {
		return header;
	}	

    
	@Override
	public String toString() {
		return "Greeting [id=" + id + ", content=" + content + "]";
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setHeader(String header) {
		this.header = header;
	}

}
