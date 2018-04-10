/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Nik
 */
public class Matrix {
    int[][] ma;
    String[] ids;
    int vertices = 0;
    
    public Matrix(int size, String[] split){
        ma = new int[size][size];
        ids = split;
    }
    
    public void insertMat(String[] len, int id){
        System.out.println(len.length);
        for(int i = 0; i < len.length; i++){
            if(len[i].equals("∞")){
                ma[id][i] = Integer.MAX_VALUE;
            }else{
                ma[id][i] = Integer.parseInt(len[i]);
            }
        }
    }
    
    public boolean isEdge(int src, int tgt){
        return ma[src][tgt]>0;
    }
    public void removeEdge(int src, int tgt) {
        ma[src][tgt] = 0;
    }
    public void PrimJarnik(){
        int min;
        int w = 0;
        List<Integer> visited = new ArrayList<>();
        visited.add(0);
        while(visited.size() != ids.length){
            min = Integer.MAX_VALUE;
            for(int i : visited){
                for(int j = 0; j < ids.length;++j){
                    if(min > ma[i][j] && !visited.contains(j)){
                        min = ma[i][j];
                        w = j;
                    }
                }
            }
            visited.add(w);
        }
        for(int i = 0; i < visited.size(); i++){
            System.out.print(visited.get(i));
        }
    }
    
    public class element{
        String start, end;
        int weight;
        
        public element(String start, String end, int weight, int priority){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        
        public int getWeight(){
            return weight;
        }
    }
}
