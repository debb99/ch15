package com.debashish.car;

import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

public class CarData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Car> Garage;
	
	public CarData() {
		Garage = new ArrayList<>();
	}
	
	public Car getCar(int n){
		return Garage.get(n);
	}
	
	public void add(Car car){
		Garage.add(car);
	}
	
	public int getSize(){
		return Garage.size();
	}
	
	public void draw(Graphics2D g2){
		for(Car c: Garage){
			c.draw(g2);
		}
	}
}
