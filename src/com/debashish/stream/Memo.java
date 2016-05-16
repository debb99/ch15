package com.debashish.stream;

import java.io.Serializable;

public class Memo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String topic;
	private String dateStamp;
	private String message;
	
	public Memo(String top, String dateS, String mess) {
		topic = top;
		dateStamp = dateS;
		message = mess;
	}
	
	@Override
	public String toString(){
		return String.format("Topic: %s%nDate: %s%nMessage: %s%n", topic, dateStamp, message);
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
