/*
 * Authors: Nik Floden
 * Date: April 10th, 2018
 * Overview: This is the driver of the Programming Assignment 3. 
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
        Charset chars = Charset.forName("UTF-8");
        Path input = Paths.get("..\\project3\\src\\input\\input.txt");
        try (BufferedReader reader = Files.newBufferedReader(input, chars)) {
            String line = reader.readLine();
            String split[] = line.split(",");
            Matrix za = new Matrix(split.length, split);
            int z = 0;
            split = null;
            while ((line = reader.readLine()) != null){
                split = line.split(",");
                za.insertMat(split,z);
                z++;
                split = null;
            } // and now the matrix is full, onto the algorithms
            Matrix za2 = za;
            Matrix za3 =za;
            za.PrimJarnik();
            System.out.println();
            //System.out.println("Kruskal : ");
            //za2.kruskal()
            System.out.println("Floyd-Warshall: ");
            za3.print(za3.ma);
            za3.floydwarshall(za3.ma);
            
            
            
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        
        
    }
    
}
