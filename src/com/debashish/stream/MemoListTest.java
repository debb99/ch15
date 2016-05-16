package com.debashish.stream;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class MemoListTest {
	public static void main(String[ ] args) throws IOException, ClassNotFoundException
   {
      MemoList mList = null;
      
      // get the file to read
      JFileChooser chooser = new JFileChooser( );
      if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION)
         System.exit(0);
      File selectedFile = chooser.getSelectedFile( );
      if (selectedFile.exists( ))
      {
         // declare an ObjectInputStream object to read the file
         ObjectInputStream input = new ObjectInputStream...
         
         // read in the entire array list of memos from the file
         mList = 
         
         // close the file
         input.close( );
         
         System.out.println("File of " + mList.getSize( ) + " Memos:");
         // print the entire list of memos
         System.out.println(...);
      }
      else 
      {
         System.out.println("Creating a new File of Memos:");
         mList = ...   // make an new (empty) array list
      }
      
 

      Scanner console = new Scanner(System.in);
      boolean done = false;
      while(!done)
      {
         System.out.print("(A)dd a memo, (P)rint all memos, or (Q)uit: ");
         String ans = console.nextLine( );
         if(ans.equalsIgnoreCase("Q"))
         {
            ObjectOutputStream output = ...
            
            // save the entire array list to a file
            ...
            output.close( );
            done = true;
         }
         else if(ans.equalsIgnoreCase("P"))
         {
            if(mList.getSize( ) == 0)
               System.out.println("Empty List of Memos\n");
            else
               System.out.println(...);
         }
         else if(ans.equalsIgnoreCase("A"))
         {
            System.out.print("Enter the topic: ");
            String topic = console.nextLine( );
            System.out.print("Enter the message text: ");
            String msg = console.nextLine( );

            // add a new memo to the memo list
            ...
         }
         else
         {
            System.out.println("Illegal Input.\n");
         }
      }
   }
}