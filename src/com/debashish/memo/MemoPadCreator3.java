package com.debashish.memo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class MemoPadCreator3
{
   public static void main(String[ ] args)
   {
      // get the file to read
      JFileChooser chooser = new JFileChooser( );
      if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION)
         System.exit(0);
      File selectedFile = chooser.getSelectedFile();

      try
      {
         FileReader reader = new FileReader(selectedFile);
         Scanner input = new Scanner(reader);

         boolean done = false;
         while (input.hasNextLine( ) && !done)
         {
            String topic = input.nextLine();   // read the topic
            String dateStamp = input.nextLine();   // read the date
            String message = input.nextLine();   // read the message

            System.out.println(topic + "\n" + dateStamp + "\n" + message + "\n");
         }
         
         // close the file
         input.close();
      }
      catch (IOException io)
      {
         io.printStackTrace();
      }
   }
}
