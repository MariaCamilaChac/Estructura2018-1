package TercerCorte;
/**@author Camila Chacon**/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Analogimon {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		//number of vertex and edges
		int M = Integer.parseInt(input.split(" ")[0]);
		int N = Integer.parseInt(input.split(" ")[1]);
		
		long Matrix[][] = new long [M][M]; //adjacency matrix
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
			
				if(i==j) {
					Matrix[i][j] = 0;
				}else {
					Matrix[i][j] = 999999999; //number of max value for exception
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			
			String Line = br.readLine();
			//cases 
			int PosI = Integer.parseInt(Line.split(" ")[0]); 
			int PosJ = Integer.parseInt(Line.split(" ")[1]);
			
			Matrix[PosI - 1][PosJ - 1] = 1;
			
		}
		//chosen number
		int E = Integer.parseInt(br.readLine());
		E = E-1;
		int C = 0;
		
		for (int i = 0; i < E; i++) {
			for (int j = 0; j < E; j++) {
				
				if(Matrix[E][j] == 1) {
					
					C++;
					int tempE = j;
					E = tempE;
					
				}
				
			}
		}
		
		System.out.println("La especia se repite " + (C+1));
	}
}
