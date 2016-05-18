package com.debashish.cipher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Cipher {

    // Store password
    private String password;
    // References table (Letter to Position, Position to Letter)
    private int[] stateTable;

    Cipher() {
    }

   

    private void setPassword(String password) {
        this.password = this.cleanUp(password);
    }

    private int[] getStateTable() {
        return this.stateTable;
    }

     
    private String cleanUp(String str) {
        return str.replaceAll("[^a-zA-Z]", "").replaceAll(" ", "").toUpperCase();
    }

 
    private int[] getEncryptTable(String pw) {
        int[] table = new int[pw.length()];
        char[] sortmap = pw.toCharArray();
        char[] wordmap = pw.toCharArray();
     
        Arrays.sort(sortmap);

      
        for (int i = 0; i < sortmap.length; i++) {
            for (int y = 0; y < wordmap.length; y++) {
                if ((int) sortmap[i] == (int) wordmap[y]) {
                    table[i] = y;
                    wordmap[y] = (char) 0;
                    break;
                }
            }
        }

        return table;
    }

   
    private int[] getDecryptTable(String pw) {
        int[] table = this.getEncryptTable(pw);
        int[] newTable = new int[table.length];

        for (int i = 0; i < table.length; i++) {
            newTable[table[i]] = i;
        }

        return newTable;
    }


    private String encrypt(String text) {
      
        if (this.password == null) {
            return null;
        }

      
        this.stateTable = this.getEncryptTable(this.password);
        text = this.cleanUp(text);

    
        StringBuilder sb = new StringBuilder();

    
        int cols = (int) Math.ceil((double) text.length() / (double) this.password.length());
     
        for (int i = 0; i < this.password.length(); i++) {
            for (int y = 0; y < cols; y++) {
                if (this.stateTable[i] + (y * this.password.length()) >= text.length()) {
                    sb.append("X");
                } else {
                    sb.append(text.charAt(this.stateTable[i] + (y * this.password.length())));
                }
            }
        }

        return sb.toString();
    }

  
    private String decrypt(String text) {
     
        if (this.password == null) {
            return null;
        }

      
        this.stateTable = this.getDecryptTable(this.password);
        text = this.cleanUp(text);

        
        StringBuilder sb = new StringBuilder();

        
        int cols = (int) Math.ceil((double) text.length() / (double) this.password.length());
     
        for (int i = 0; i < cols; i++) {
            for (int y = 0; y < this.password.length(); y++) {
                sb.append(text.charAt((cols * this.stateTable[y]) + i));
            }
        }

        return sb.toString();
    }

   
    private String fromFile(String filename) {
        try {
            Scanner sc = new Scanner(new File(filename));
            StringBuilder sb = new StringBuilder();
            while (sc.hasNext()) {
                sb.append(sc.next());
            }

            return sb.toString();
        } catch (FileNotFoundException ex) {
            return "";
        }
    }

   
    private void saveFile(String data, String filename) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(filename);
            fw.write(data);
        } catch (IOException ex) {
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
            }
        }
    }

    public static void main(String[] args) {
        Cipher cipher = new Cipher();

        Scanner sc = new Scanner(System.in);
        String pw, text;


        System.out.println("pw: ");
        cipher.setPassword(sc.next());

        System.out.println("from file:");
        text = cipher.fromFile(sc.next());

        System.out.println("to file:");
        String filename = sc.next();

        System.out.println("choose:");
        System.out.println("1 = cypher, 2 = unscramble...");

        int type = sc.nextInt();

        if (type == 1) {
            cipher.saveFile(cipher.encrypt(text), filename);
        } else {
            cipher.saveFile(cipher.decrypt(text), filename);
        }
    }
}

