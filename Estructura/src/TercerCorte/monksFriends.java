/**
 * 
 * 1
2 3
3 2 9 11 2
 * **/
 
package TercerCorte;

import java.util.*;

//Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

 public class monksFriends {

     Node root;
     public void monksFriends() {
         root = null;
     }
     public void insert(long key) {
         root = insertRec(root, (int) key);
     }
     public void preOrder(Node n) {
    
         if (n == null ) {
             return;
         }
         System.out.println(n.data);
         preOrder(n.left);
         preOrder(n.right);
     }
     
     public Node insertRec(Node root, int key) {
         if (root == null) {
             root = new Node(key);
             return root;
         }
         if (key < root.data) {
             root.left = insertRec(root.left, key);
         } else if (key > root.data) {
             root.right = insertRec(root.right, key);
         }
         return root;
     }
     // A utility function to search a given key in BST
     public Node search(Node root, long key) {
     // Base Cases: root is null or key is present at root
     if (root == null || root.data==key)
         return root;

     // val is greater than root's key
     if (root.data > key)
         return search(root.left, key);

     // val is less than root's key
     return search(root.right, key);
     }
	public int height(Node root) {
		if (root == null)
			return 0;
		return Math.max(height(root.left), height(root.right)) + 1; 	
	}
	public int size(Node node) {
		if (node == null)
			return 0;
		else
			return (size(node.left) + 1 + size(node.right));
	}
 
 public static void main(String args[] ) throws Exception {
	Scanner sc = new Scanner(System.in);
     int T = sc.nextInt();
     while (T-- > 0) {
         int N = sc.nextInt();
         int M = sc.nextInt();
         monksFriends tr = new monksFriends();
	        for (int i=0; i<N; i++) {
		        tr.insert(sc.nextLong());
	        }
	        for (int i=0; i<M; i++) {
			if (tr.search(tr.root, sc.nextLong()) == null)
				System.out.println("NO");
			else
				System.out.println("YES");		
		}
     }

 }
}
