package com.debashish.car;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CarShapes {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		JFrame myFrame = new JFrame("Car Shapes");
		myFrame.setSize(600, 600);
		
		CarPanel myPanel = new CarPanel();
		myFrame.add(myPanel);
		myFrame.setResizable(false);
		myFrame.setLocationRelativeTo(null);
		myFrame.setJMenuBar(myPanel.getMenuBar());
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}
}
