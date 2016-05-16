package com.debashish.random;

import java.io.IOException;
import java.io.RandomAccessFile;

public class MemoPad {
	public MemoPad() {
		file = null;
	}

	/**
    * Open the file so that it can read and write
    */
   public void open(String fileName) throws IOException
   {
      file = new RandomAccessFile(fileName, "rw");
   }

	/**
      Gets the number of memos in the file.
    */
   public int size( ) throws IOException
   {
      return (int)(file.length() / RECORD_SIZE);
   }

	public void close() throws IOException {
		if (file != null)
			file.close();
		file = null;
	}

	/**
      Reads a memo record.
    */
   public void read(int n) throws IOException
   {
      file.seek(n * RECORD_SIZE);
      byte[ ] topic = new byte[MAX_CHARS_TOPIC];
      byte[ ] date = new byte[MAX_CHARS_DATE];
      byte[ ] message = new byte[MAX_CHARS_MSG];
      /* Read the topic, date and message from the file (use the method "read(byte[ ])".
         Then, convert the byte arrays to strings and store them in the variables
         currentTopic, currentDateStamp and currentMessage
       */
      
      file.read(topic);
      currentTopic = new String(topic);
      
      file.read(date);
      currentDateStamp = new String(date);
      
      file.read(message);
      currentMessage = new String(message);
   }

	public String getTopic() {
		return currentTopic; // returns the topic of the last memo read
	}

	public String getDateStamp() {
		return currentDateStamp;
	}

	public String getMessage() {
		return currentMessage;
	}

	public void write(int n, String topic, String dateStamp, String message) throws IOException
	   {
	      file.seek(n * RECORD_SIZE);
	      
	      // "topic" should have a fixed size
	      file.writeBytes(padOrTrim(topic, MAX_CHARS_TOPIC));
	      
	      // "dateStamp" should have a fixed size
	      file.writeBytes(padOrTrim(dateStamp, MAX_CHARS_DATE));
	      
	      // "message" should have a fixed size
	      file.writeBytes(padOrTrim(message, MAX_CHARS_MSG));      
	   }

	/**
	 * Adds white spaces to a string or cuts the string, so the string has a
	 * length of exactly "size".
	 */
	private String padOrTrim(String str, int size) {
		if (str.length() < size) {
			String pad = "";
			for (int i = str.length(); i < size; i++)
				pad = pad + " ";
			return str + pad;
		} else
			return str.substring(0, size);
	}

	private RandomAccessFile file;
	private String currentTopic;
	private String currentDateStamp;
	private String currentMessage;

	public static final int MAX_CHARS_TOPIC = 25;
	public static final int MAX_CHARS_DATE = 40;
	public static final int MAX_CHARS_MSG = 250;
	public static final int RECORD_SIZE = MAX_CHARS_TOPIC + MAX_CHARS_DATE + MAX_CHARS_MSG;
}
