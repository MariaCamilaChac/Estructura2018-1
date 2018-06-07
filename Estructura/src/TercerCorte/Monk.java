/**
 * 4
2 1 3 4
@author Camila Chacon
 */

package TercerCorte;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
//import for Scanner and other utility classes
import java.util.*;
 
 
public class Monk {
   
	
    public static Nodes insert(Nodes root, int data){
        if(root==null){
            root = new Nodes();
            root.data = data;
            return root;
        }
        else{
            if(root.data>data){
                root.left=insert(root.left,data);
            }
            else{
                root.right=insert(root.right,data);
            }
        }
        return root;
    }
    public static int height(Nodes root){
        if(root==null)
            return 0;
        
        else{
            return 1+Math.max(height(root.left),height(root.right));
        }
    }
    
    public static void main(String args[] ) throws Exception {
    	 
    	Scanner sc = new Scanner(System.in);
        Nodes root = null;
        int a = sc.nextInt();
        for(int i=0;i<a;i++){
            int s = sc.nextInt();
            root = insert(root,s);
        }
        System.out.println(height(root));
    }
}
