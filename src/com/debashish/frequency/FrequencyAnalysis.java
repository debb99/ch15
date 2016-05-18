package com.debashish.frequency;

import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class FrequencyAnalysis {
	public static void main(String[] args) throws IOException {
		JFileChooser myChooser = new JFileChooser();
		myChooser.showOpenDialog(null);
		FileReader reader = new FileReader(myChooser.getSelectedFile());

		System.out.println("Letter Frequency");

		int nextChar;
		char ch;

		int[] count = new int[26];

		while ((nextChar = reader.read()) != -1) {
			ch = Character.toLowerCase((char) nextChar);

			if (ch >= 'a' && ch <= 'z')
				count[ch - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			System.out.printf("%c%7d\n", i + 'A', count[i]);
		}

		reader.close();
	}
}
