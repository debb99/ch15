package com.debashish.xor;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class XorEncryptorTest {
	public static void main(String[ ] args)
   {  
      try
      {
         // get the file to read using JFileChooser
         JFileChooser chooser = new JFileChooser();
         chooser.showOpenDialog(null);
         File inFile = chooser.getSelectedFile( );
         
         // get the file name of the encrypted file using JFileChooser
         chooser.showOpenDialog(null);
         File outFile = chooser.getSelectedFile( );
         
         byte b = -1;
         
         // get the key
         boolean done = false;
         while(!done)
         {
            try
            {
               String key = JOptionPane.showInputDialog("Key:");
               // use Byte.parseByte to change the string input into a byte
               b = Byte.parseByte(key);
               done = true;
            }
            catch (NumberFormatException e)
            {
               JOptionPane.showMessageDialog(null, "Key must contain only digits.");
            }
         }
         
         // encrypt the file by making an XorEncryptor object
         // and then calling the encryptFile method
         XorEncryptor crypt = new XorEncryptor(b);
         crypt.encryptFile(inFile, outFile);
      }
      catch (IOException exception)
      {  
         System.out.println("Error processing file: " + exception);
      }
      System.exit(0);
   }
}
