/**
 * 
 * 
*/
package TercerCorte;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import arbol.Node_Tree;
import  arbol.Tree;;


public class MonkFriends {
	
	Tree tree= new Tree();
	
	 Node root;
	
	public MonkFriends() {
		root=null;
	}
	
	
	public void insert(int data) {
		root=insert(root,data);
	}
	
    
	public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }
	
	  public Node search(Node root, long key) {
		
		     if (root == null || root.data==key)
		         return root;

		     if (root.data > key)
		         return search(root.left, key);

		     
		     return search(root.right, key);
		     }
   
    
    public static void main(String[] args) throws NumberFormatException, IOException {
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	MonkFriends tree = new MonkFriends();

	
    int T = Integer.parseInt(br.readLine());
	 
     while (T-- > 0) {
        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);
        Node findit = null;	
        //MonkFriends in = new MonkFriends();
       
        String entrada = br.readLine();
        
        for (int i = 0; i < N; i++) {
			tree.insert(Integer.parseInt(entrada.split(" ")[i++]));
		}
        for (int i = 0; i < M; i++) {
        	
        		
			if(tree.search(tree.root, Integer.parseInt(entrada.split(" ")[i++])) == null) {
				System.out.println("no\n");
			
			}else	
				System.out.println("yes\n");	
		
        }
    
     }
  
	



    }
}
