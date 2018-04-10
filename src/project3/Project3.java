/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Nik Floden
 */
public class Project3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Charset chars = Charset.forName("US-ASCII");
        Path input = Paths.get("..\\project3\\src\\input\\input.txt");
        try (BufferedReader reader = Files.newBufferedReader(input, chars)) {
            String line = reader.readLine();
            String split[] = line.split(",");
            
            
            while ((line = reader.readLine()) != null){
            
            } // end while
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
    
}
