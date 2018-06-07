/** @author Camila Chacon   **/
package arbol;

public class Node_Tree {
	
	int value;
	Node_Tree Tree_left=null;
	Node_Tree Tree_rigth=null;

	
	public Node_Tree(int value) {
		this.value=value;
	}
	
	public String ToString() {
		return " "+this.value;
	}

	
	
		
}

