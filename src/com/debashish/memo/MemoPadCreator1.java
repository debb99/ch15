package com.debashish.memo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;


public class MemoPadCreator1 {
	public static void main(String[ ] args)
   {
      Date now;
      Scanner console = new Scanner(System.in);
      System.out.print("Output file: ");
      String fileName = console.nextLine( );
      
      try
      {
         PrintWriter output = new PrintWriter(fileName);
         
         boolean done = false;
         while (!done)
         {
            System.out.print("Memo topic (enter Q to quit): ");
            String topic = console.nextLine( );
            if (topic.equalsIgnoreCase("Q"))
               done = true;
            else
            {
               System.out.print("Memo text: ");
               String message = console.nextLine( );

               /** Create the new date object and obtain a dateStamp */
               now = new Date();
               String dateStamp = now.toString();
               output.println(topic + "\n" + dateStamp + "\n" + message);
            }
         }
         /** Close the output file*/
         output.close();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }
}
