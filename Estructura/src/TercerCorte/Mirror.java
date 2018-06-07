package TercerCorte;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Mirror {
  
       public static boolean find(Node root,int data) {
           if(root ==null) 
        	   return false;
           if(root.data==data) 
        	   return true;
           if(find(root.left,data)) 
            	return true;
            if(find(root.right,data)) 
            	return true;
           
            return false;
       }
       
       
       public static Node insert(Node root,int p,int data,String pos) {
           if(root==null) return null;
           if(root.data==p) {
               if(pos.equals("L")) {
                   root.left = new Node(data);
               } else {
                   root.right = new Node(data);
               }
              return root; 
           }
           if(find(root.left,p)) {
               root.left=insert(root.left,p,data,pos);
               
           }
           else if(find(root.right,p)) root.right = insert(root.right,p,data,pos);
           return root;
       }
       
    
     public  static int mirror(Node copy,Node root,int d) {
           if(root==null || copy==null) 
        	   return -1;
           if(root.data==d) 
        	   return copy.data;
          
           int left = mirror(copy.right,root.left,d);
          
           if(left!=-1)
        	   return left;
          
           int right = mirror(copy.left,root.right,d);
          return right;
       }
       
       
    public static void main(String args[] ) throws Exception {
       
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	String input = br.readLine();
		String cases[] = input.split(" ");
		Node root = new Node(1);
		int N = Integer.parseInt(cases[0]);
		int Q = Integer.parseInt(cases[1]);

		for (int i = 0; i < N-1; i++) {
			
			String Line = br.readLine();
			String Action[] = Line.split(" ");
			
			insert(root , Integer.parseInt(Action[0]), Integer.parseInt(Action[1]) , Action[2]);
			
		}
		

		int[] Final = new int[Q];
		
		for (int i = 0; i < Q; i++) {
			
			String Line = br.readLine();
            Final[i] = (mirror(root,root, Integer.parseInt(Line)));
			
		}
		
		for (int i = 0; i < Final.length; i++) {
			System.out.println(Final[i]);
		}
    		
    }
    
   
}
