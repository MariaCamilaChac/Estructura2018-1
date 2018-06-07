package Graphs;

import java.util.Arrays;

public class Graph2 {
    public long[][] adjacencyMatrix;
    public long[] distance;
    public int[] colors;//only for Mancunian and Colored tree problem
    public int[] ancesterSameColor;//only for Mancunian and Colored Tree problem
    int[] visited; //for the graph traversal
    //Queue queue; //for BFS
    int numberOfVertices;
    boolean directed;
    
    public Graph2(int numberOfVertices, boolean directed){
        this.numberOfVertices = numberOfVertices;
        this.directed = directed;
        adjacencyMatrix = new long[numberOfVertices][numberOfVertices];
        visited = new int[numberOfVertices];
        distance = new long[numberOfVertices];
        Arrays.fill(distance, -1);
        
    }
    
    public boolean hasConection(int from, int to){
        return adjacencyMatrix[from][to] != 0;
    }
    
    public void createConection(int from, int to, int weight){
        if(directed){
            adjacencyMatrix[from][to] = weight;
        }else{
            adjacencyMatrix[from][to] = weight;
            adjacencyMatrix[to][from] = weight;
        }
    }
    
    public void Color(int color, int vertex) {
        for (int i = 0; i < numberOfVertices; i++) {
            if(hasConection(vertex, i)){
                if(colors[i] == colors[color]){
                    ancesterSameColor[color] = i + 1;
                    return;
                }else{
                    Color(color,i);
                }
            }
        }
    }
    
}
