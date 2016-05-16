package com.debashish.stream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class MemoList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	public MemoList() {
		Memos = new ArrayList<>();
	}
	
	public Memo getMemo(int n){
		return Memos.get(n);
	}
	
	public void add(String top, String mess){
		Date now = new Date();
		Memos.add(new Memo(top, now.toString(), mess));
	}
	
	public int getSize(){
		return Memos.size();
	}
	
	ArrayList<Memo> Memos;
}
