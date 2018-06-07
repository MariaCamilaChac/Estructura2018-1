/**
 * 5 4
1 1 3 3
1 4 2 1 2
 */
/**
@author Camila Chacon
*/
package TercerCorte;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Graphs.Graph2;
 
public class colortree {
	
	
	public static void main(String[] args) throws IOException {
		  
		   
		   BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
			
		   int N, C;
			
		   String parents, colors;
			
		   
			
		   parents = br.readLine();
			
		   N = Integer.parseInt(parents.split(" ")[0]);
			
		   C = Integer.parseInt(parents.split(" ")[1]);
			
		   Graph2 coloredTree = new Graph2(N,true);
			
		   
		   coloredTree.colors = new int[N];
			
		   coloredTree.ancesterSameColor = new int[N];
			
		   Arrays.fill(coloredTree.ancesterSameColor, -1);
						        
			
		   parents = br.readLine();
			
		   colors = br.readLine();
						        
			
		   for (int i = 0; i < N; i++) {
			
			   coloredTree.colors[i] = Integer.parseInt(colors.split(" ")[i]);
			
		   }
				
		   
			
		   for (int i = 0; i < N - 1; i++) {
			
			   coloredTree.createConection(i + 1, Integer.parseInt(parents.split(" ")[i]) - 1, 1);
				
		   }
						        
						        
		   for (int i = 0; i < N; i++) {
			
			
			   coloredTree.Color(i, i);
						        }
						        
				
		   for (int i = 0; i < N; i++) {
			
			   bw.write(coloredTree.ancesterSameColor[i] + " ");
				
			   bw.flush();
		   }
	   }
}

    
	  
		    
		 
	   	
	   