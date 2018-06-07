package TercerCorte;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/** @author Camila Chacon   **/
import java.util.StringTokenizer;

import Graphs.*;
/**@author Camila Chacon**/
public class AntsColony {

    public static void main(String[] args) throws IOException{
       
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());//number of colonies 
       
        do {
        	
        
	        int Ai; //conection with
	        int Li ; // price 
	        
	        Graph g = new Graph(); //object of class graph
	        g.crearGrafo(N, N-1); //edges and  vertices
	        for (int i = 1; i < N; i++) { 
	        	 String cases[] = br.readLine().split(" ");
	        	 g.insertaArista(i, Ai= Integer.parseInt(cases[0]), Li= Integer.parseInt(cases[1])); //read the cases 
				
			}
	              
	       int Q= Integer.parseInt(br.readLine()); //read the queries
	       int S, T; // vertex to find
	       for (int i = 0; i < Q; i++) {
	    	   String cases[] = br.readLine().split(" ");
	    	   S=Integer.parseInt(cases[0]);
	    	   T=Integer.parseInt(cases[1]);
	    	  
	    	   System.out.println(g.dijkstra(S)[T]); // call the function 
		}
        }while(N==0); // do all while N be different of 0
    }
}