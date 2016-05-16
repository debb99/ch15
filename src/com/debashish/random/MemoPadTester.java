package com.debashish.random;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class MemoPadTester {
	public static void main(String[ ] args)
  {
    Scanner console = new Scanner(System.in);
    System.out.print("Input file: ");
    String fileName = console.nextLine( );
    
    try
    {
      MemoPad memoPad = new MemoPad( );
      memoPad.open(fileName); // open the file
      
      boolean done = false;
      while (!done)
      {
        System.out.print("Enter A to add a memo, D to display an existing memo or Q to quit: ");
        String choice = console.nextLine( );
        
        if (choice.equalsIgnoreCase("A"))
        {
          System.out.print("Topic (max 25 characters): ");
          String topic = console.nextLine( );
          String dateStamp = (new Date( )).toString( );
          System.out.print("Message (max 250 characters): ");
          String message = console.nextLine( );
          memoPad.write(memoPad.size(), topic, dateStamp, message);
          System.out.println( );
        }

 

        else if (choice.equalsIgnoreCase("D"))
        {
          if (memoPad.size( ) > 0)
          {
            // Display the list of topics
            for (int i = 0; i < memoPad.size(); i++)
            {
              memoPad.read(i);
              System.out.println(String.format("%2d. ", (i + 1)) + memoPad.getTopic());
            }
            
            System.out.print("Enter the number of the memo to display: ");
            int n = Integer.parseInt(console.nextLine( )) - 1;
            memoPad.read(n);
            
            System.out.println(memoPad.getTopic()); // topic
            System.out.println(memoPad.getDateStamp()); // date stamp
            System.out.println(memoPad.getMessage()); // message
            System.out.println( );
          }
          else
          {
            System.out.println("There are no memos in the file.\n");
          }
        }
        else if (choice.equalsIgnoreCase("Q"))
         System.exit(0);
      }
      memoPad.close();   // close the file
    }
    catch (IOException exception)
    {
      System.out.println("Input/output error: " + exception);
    }
  }
}
