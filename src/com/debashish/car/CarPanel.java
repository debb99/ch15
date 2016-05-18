package com.debashish.car;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CarPanel extends JPanel implements Serializable {
	private static final String newString = "New";
	private static final String openString = "Open";
	private static final String saveString = "Save";
	private static final String exitString = "Exit";

	class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals(newString)) {
				Cars = new CarData();
				repaint();
			}

			if (command.equals(openString)) {
				chooser.showOpenDialog(null);
				File selectedFile = chooser.getSelectedFile();
				try {
					if (selectedFile.exists()) {
						ObjectInputStream input = new ObjectInputStream(new FileInputStream(selectedFile));
						CarPanel.this.Cars = (CarData) input.readObject();
						input.close();
						repaint();
					}
					repaint();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}

			if (command.equals(saveString)) {
				chooser.showSaveDialog(null);
				File selectedFile = chooser.getSelectedFile();
				try {
					ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(selectedFile));
					output.writeObject(Cars);
					output.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
			
			if(command.equals(exitString)){
				System.exit(0);
			}
		}
	}

	class Mouse extends MouseAdapter {
		@Override
		public void mouseReleased(MouseEvent e) {
			Cars.add(new Car(e.getX(), e.getY()));
			repaint();
		}
	}

	// CONSTRUCTOR
	public CarPanel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		setBackground(Color.WHITE);
		
		chooser = new JFileChooser();

		Cars = new CarData();

		menuBar = new JMenuBar();
		JMenu myMenu = new JMenu("File");
		JMenuItem newItem = new JMenuItem(newString);
		JMenuItem open = new JMenuItem(openString);
		JMenuItem save = new JMenuItem(saveString);
		JMenuItem exit = new JMenuItem(exitString);

		newItem.addActionListener(new Listener());
		open.addActionListener(new Listener());
		save.addActionListener(new Listener());
		exit.addActionListener(new Listener());

		myMenu.add(newItem);
		myMenu.add(open);
		myMenu.add(save);
		myMenu.add(exit);

		menuBar.add(myMenu);

		addMouseListener(new Mouse());
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		Cars.draw(g2);
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	private CarData Cars;
	private JMenuBar menuBar;
	private JFileChooser chooser;
}
