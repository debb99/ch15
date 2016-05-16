package com.debashish.stream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class MemoList implements Serializable{
	public MemoList() {
		
	}
	
	public Memo getMemo(int n){
		return Memos.get(n);
	}
	
	public void add(String top, String mess){
		now = new Date();
		Memos.add(new Memo(top, now.toString(), mess));
	}
	
	public int getSize(){
		return Memos.size();
	}
	
	Date now;
	ArrayList<Memo> Memos;
	
}
