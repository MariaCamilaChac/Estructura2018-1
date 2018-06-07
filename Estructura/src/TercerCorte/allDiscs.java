package TercerCorte;
import Graphs.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class allDiscs{
	
	public static void main(String[] args) throws IOException {
		
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		int N1, N2, D;
		boolean dependence;
		Graph g = new Graph();
		
		
		String input= br.readLine();
		while(input != "0,0,0") {
			
			N1= Integer.parseInt(input.split(" ")[0]);
			N2 = Integer.parseInt(input.split(" ")[1]);
			D = Integer.parseInt(input.split(" ")[2]);
			
			g.crearGrafo(N1, N2);
			
			
		}
		
		
		
	}
	
	
}