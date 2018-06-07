package TercerCorte;
/**@author Camila Chacon**/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import Graphs.*;

public class Analogimon {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        String input;
        int N, M, numberOfSpecies, spicie, a, b,E ;
        
        while(!(input = br.readLine()).equals("0 0") ){
            numberOfSpecies = 1;
            N = Integer.parseInt(input.split(" ")[0]);
            M = Integer.parseInt(input.split(" ")[1]);
           Graph analogimons = new Graph();
            
            /**Create the conections**/
            for (int i = 0; i < N; i++) {
                input = br.readLine();
                analogimons.insertaArista( a = Integer.parseInt(input.split(" ")[0])-1 , b = Integer.parseInt(input.split(" ")[0])-1, 1);
            }
            
            E = Integer.parseInt(br.readLine());
            numberOfSpecies = analogimons.countSpecies(numberOfSpecies, E-1);
            
            bw.write(numberOfSpecies + "\n");
            bw.flush();
        }
        
    }
}