package com.debashish.cypher;

import java.io.File;
import java.util.Scanner;

public class Cipher {
	public static void main(String[] args) throws Exception {
		File binary = new File("randomfile");
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a message: ");
		String message = input.nextLine();
		byte[] messageBytes = message.getBytes();

		System.out.println("Message: " + message);

		for (int i = 0; i < messageBytes.length; i++) {
			System.out.print(Integer.toBinaryString(messageBytes[i]) + " ");
		}
		System.out.println();
	}
}
