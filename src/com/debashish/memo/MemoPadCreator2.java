package com.debashish.memo;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MemoPadCreator2
{
   public static void main(String[ ] args)
   {
      Scanner console = new Scanner(System.in);
      System.out.print("Input file: ");
      String inputFileName = console.nextLine( );
      
      try
      {
         FileReader reader = new FileReader(inputFileName);
         Scanner input = new Scanner(reader);
         
         boolean done = false;
         while (input.hasNextLine( ) && !done)
         {
            String topic = input.nextLine();
            String dateStamp = input.nextLine();
            String message = input.nextLine();
            System.out.println(topic + "\n" + dateStamp + "\n" + message + "\n");
            
            // You should only ask to display the next memo if there are more memos in the file
            if (input.hasNextLine())
            {
               System.out.print("Do you want to read the next memo (y/n): ");
               String ans = console.nextLine( );
               if (ans.equalsIgnoreCase("n"))
                  done = true;
            }
         }
         
         reader.close( );
      }
      catch (IOException io)
      {
         io.printStackTrace();
      }
   }
}

