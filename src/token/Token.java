/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package token;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import vn.hus.nlp.tokenizer.VietTokenizer;

/**
 *
 * @author ducthang
 */
public class Token {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        try(FileWriter fw = new FileWriter("output.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
            {
                //Read file input
                Scanner input = new Scanner(new File("input.txt"));
                while(input.hasNextLine())
                {
                    //System.out.println("Chuoi: " + input.nextLine());
                    String originString = input.nextLine();
                    StringBuilder str = new StringBuilder(originString);
                    while(str.length() != 1)
                    {
                        System.out.println("Old String: " + str);
                        int indexDelete = str.indexOf(" ");
                        System.out.println(str.length());
                        String cutedString = str.substring(0, indexDelete);
                        if(cutedString.indexOf("_") != -1)
                        {
                            StringBuilder strbuilder = new StringBuilder(cutedString);
                            strbuilder.setCharAt(cutedString.indexOf("_"), ' ');
                            cutedString = strbuilder.toString();
                        }
                        System.out.println("Cuted String: " + cutedString);
                        out.println(cutedString);
                        str.delete(0, indexDelete+1);
                        System.out.println("Deleted String: " + str);
                    }
                    //System.out.println("Length: " + str.length());
                    //System.out.println(originString.indexOf(" ", 0));
                }
            } catch (IOException e) {
                System.out.println("Error : " + e.getMessage());
            }
    }
    
}
