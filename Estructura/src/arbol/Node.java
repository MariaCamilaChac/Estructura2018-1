package arbol;

public class Node {
	
	int value;
	Node Tree_left=null;
	Node Tree_right=null;
	int height ;

	
	public Node(int value) {
		this.value=value;
	}
	
	public String ToString() {
		return " "+this.value;
	}

	
	
		
}
