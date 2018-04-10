/*
 * Authors: Nik Floden
 * Date: April 10th, 2018
 * Overview: This is where the magic happens. 
 */
package project3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Nik
 */
public class Matrix {
    int[][] ma;
    String[][] name;
    String[] ids;
    int edges = 0;
    
    public Matrix(int size, String[] split){
        ma = new int[size][size];
        name = new String[size][size];
        ids = split;
    }
    
    public void insertMat(String[] len, int id){
        for(int i = 0; i < len.length; i++){
            if(len[i].equals("∞")){
                ma[id][i] = Integer.MAX_VALUE;
                name[id][i] = "∞";
            }else{
                ma[id][i] = Integer.parseInt(len[i]);
                name[id][i] = ids[id] + ids[i];
                edges++;
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
        String x = "";
        List<Integer> visited = new ArrayList<>();
        List<String> what = new ArrayList<>();
        visited.add(0);
        while(visited.size() != ids.length){
            min = Integer.MAX_VALUE;
            for(int i : visited){
                for(int j = 0; j < ids.length;++j){
                    if(min > ma[i][j] && !visited.contains(j)){
                        min = ma[i][j];
                        w = j;
                        x = name[i][j];
                    }
                }
            }
            visited.add(w);
            what.add(x);
        }
        System.out.println("Prim - Jarnik Algorithm: ");
        for(int i = 0; i < what.size(); i++){
            System.out.print(what.get(i) + " ");
        }
        System.out.println();
    }
    
//    public void kruskal(){
////        //init priority queue to hold edges
////        PriorityQueue q = new PriorityQueue(edges);
////        for(int i = 0; i < ids.length; i++){
////            for(int y = 0; y < ids.length; y++){
////                //if the edge in the adjacency matrix is not 0 or infinity, add it to the queue 
////                if(ma[i][y] != 0 || ma[i][y] != Integer.MAX_VALUE){
////                    element el = new element(name[i][y], ma[i][y]);
////                    q.add(el);
////                }
////            }
////        } //priority queue should be filled
////        List<Integer> t = new ArrayList<>();
////        while(t.size() != ids.length){
////            
////        }
//
//        int tempE = 0;
//        int index = 0;
//        Edge E[] = new Edge[edges];
//        Edge results[] = new Edge[ids.length];
//        
//        for(int i = 0; i < ids.length; i++){
//            for(int y = 0; y < ids.length; y++){
//                if (ma[i][y] != 0 || ma[i][y] != Integer.MAX_VALUE) {
//                    Edge el = new Edge(name[i][y], ma[i][y]);
//                    E[index] = el;
//                    index++;
//                }
//            }
//        }
//        Arrays.sort(E);
//        while(tempE < ids.length - 1){
//            Edge curr = E[0];
//            
//        }
//        
//        for(int z = 0; z < tempE; ++z){
//            
//        }
//    }
//    
//    public class Edge implements Comparable<Edge>{
//        String edge;
//        int weight;
//        
//        public Edge(String edge, int weight){
//            this.edge = edge;
//            this.weight = weight;
//        }
//        
//        @Override
//        public int compareTo(Edge compare){
//            return this.weight-compare.weight;
//        }
//    }
//    
//    class cluster{
//        
//    }
    
  
    public void floydwarshall(int[][] d){
        
        for(int k = 0; k < d.length; k++){
            for(int i = 0; i < d.length; i++){
                for(int j = 0; j < d.length; j++){
                    if(d[i][k] == Integer.MAX_VALUE || d[k][j] == Integer.MAX_VALUE){
                        continue; // I was getting negatives and I still don't know why until I found this fix here http://www.programming-algorithms.net/article/45708/Floyd-Warshall-algorithm
                    }
                    if(d[i][j] > d[i][k] + d[k][j]){
                        d[i][j] = d[i][k] + d[k][j];
                        print(d);
                    }
                }
            }
        }
    }
    
    public void print(int a[][]){
        System.out.print("  ");
        for(int i = 0; i < ids.length; i++){
            System.out.print(ids[i] + " ");
        }
        System.out.println();
        for(int z = 0; z < ids.length; z++){
            System.out.print(ids[z] + ' ');
            for(int y = 0; y < ids.length; y++){
                if(a[z][y] == Integer.MAX_VALUE||a[z][y] == Integer.MIN_VALUE){
                    System.out.print("∞ ");
                } else {
                    System.out.print(a[z][y] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    
}
