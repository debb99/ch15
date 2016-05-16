package com.debashish.stream;

import java.io.Serializable;

public class Memo implements Serializable{
	private String topic;
	private String dateStamp;
	private String message;
	
	public Memo(String top, String dateS, String mess) {
		topic = top;
		dateStamp = dateS;
		message = mess;
	}
	
	public String getTopic() {
		return topic;
	}
	public String getDateStamp() {
		return dateStamp;
	}
	public String getMessage() {
		return message;
	}
}
