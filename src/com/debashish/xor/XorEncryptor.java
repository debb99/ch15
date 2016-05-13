package com.debashish.xor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XorEncryptor {
	public XorEncryptor(byte aKey) {
		key = aKey;
	}

	public void encryptFile(File inFile, File outFile) throws IOException
   {
      FileInputStream input = null;
      FileOutputStream output = null;
      
      try
      {
         input = new FileInputStream(inFile);
         output = new FileOutputStream(outFile);
         encryptStream(input, output);
      }
      finally
      {
         input.close();
         output.close();
      }
   }

	public void encryptStream(FileInputStream input, FileOutputStream output) throws IOException
   {
      boolean done = false;
      while (!done)
      {
         int next = input.read();
         if (next == -1)
            done = true;
         else
         {
            byte b = (byte) next;
            byte c = encrypt(b);
            output.write(c);
         }
      }
   }

	public byte encrypt(byte b)
   {
      return (byte)(b ^ key);
   }

	private byte key;
}
