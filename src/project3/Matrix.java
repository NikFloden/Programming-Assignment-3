/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/**
 *
 * @author Nik
 */
public class Matrix {
    int[][] ma;
    
    public Matrix(int size){
        ma = new int[size + 1][size];
    }
    
    public void insertMat(String[] len, int id){
        for(int i = 0; i < len.length; i++){
            if(len[i].equals("∞")){
                ma[id][i] = Integer.MAX_VALUE;
            }else{
                ma[id][i] = Integer.parseInt(len[i]);
            }
        }
    }
}
