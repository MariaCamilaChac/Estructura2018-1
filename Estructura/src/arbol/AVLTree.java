package arbol;


public class AVLTree{
	public AVLTree(){}
	
	
	Node root =null;
	
	
	public boolean isEmpty() {
		return root == null? true : false;
	}
	
	
	public Node Insert(Node node, int key ) {
		
		if(node == null)
			return (new Node(key));
		
		if (key < node.value){
			node.Tree_left = Insert(node.Tree_left,key);
			if(nodeHeight(node.Tree_left)-nodeHeight(node.Tree_right)==2){
				if(key < node.Tree_left.value)
					node = left_rotation(node);
				else
					node= Left_Drotation(node);
			}
				
		
		}else
			if(key > node.value){
				
				node.Tree_right= Insert(node.Tree_right,key);
				
				if(nodeHeight(node.Tree_right)-nodeHeight(node.Tree_left)==2)
				
					if(key > node.Tree_right.value)
						node = right_rotation(node);
					else
						node = Right_Drotation(node);
				
			}else
				node.height= Math.max(nodeHeight(node.Tree_left), nodeHeight(node.Tree_right)+1);
		
		

		
	return node;
	}
	
	public boolean isLeaf(Node node) {
		return(node.Tree_left==null && node.Tree_right == null)? true:false;
	}
	
	public boolean oneChild(Node node) {
		return (node.Tree_left==null && node.Tree_right==null)? false:true;
	}
	
	
	
	public Node Search (int value) {
		
		Node temp= root;
		
		while (temp != null) {
			
			if(temp.value==value) {
		
				break;
			}
			if (value < temp.value) 
				temp = temp.Tree_left;
			
			else
				temp = temp.Tree_right;
		}
		return temp;
	}
	
	
	public void Preorder(Node node) {
		if(node != null) {
			System.out.println(node.value+ " ");
			Preorder(node.Tree_left);
			Preorder(node.Tree_right);

		}
	}
	
	
	public void Inorder(Node node) {
		if(node != null) {
			
			Inorder(node.Tree_left);
			System.out.println(node.value+" ");
			Inorder(node.Tree_right);
			
		}
	}
	
	public Node parent(Node node) {
		
		if(node == root)
			return root;
		else {
			Node temp = root;
			Node parent = null;
			while(temp != null) {
				
				if(node.value== temp.value)
					break;
				
				else
				{
					parent = temp;
					if(node.value < temp.value)
						temp = temp.Tree_left;
					else
						temp = temp.Tree_right;
				}
			}
			if (temp == null)
				parent = null;
			
			return parent;
		}
		
	
		
	}
	
	public int nodeHeight(Node node){
		
		if (isLeaf(node)) 
			return 0;
		
		else{
		
			return nodeHeight(node.Tree_left)> nodeHeight(node.Tree_right)?
					nodeHeight(node.Tree_left)+1: nodeHeight(node.Tree_right)+1;
		}
			
			
		
	}
	
	public int unbalance_factor(Node node) {
		
		return nodeHeight(node.Tree_right)- nodeHeight(node.Tree_left);
	}
	
	public Node left_rotation(Node node) {
		
		Node temp= node.Tree_left;
		node.Tree_left=temp.Tree_right;
		temp.Tree_right=node;
	
		unbalance_factor(node);
		unbalance_factor(temp);
		
		return temp;
	}
	

	public Node right_rotation(Node node) {
		
		Node temp= node.Tree_right;
		node.Tree_right=temp.Tree_left;
		temp.Tree_left=node;
	
		unbalance_factor(node);
		unbalance_factor(temp);
		
		return temp;
	}
	
	public Node Left_Drotation(Node node){
		Node temp;
		node.Tree_left=right_rotation(node.Tree_left);
		temp= left_rotation(node);
		
		return temp;
	}
	
	public Node Right_Drotation(Node node){
		Node temp;
		node.Tree_right=left_rotation(node.Tree_right);
		temp= right_rotation(node);
		
		return temp;
	}
	
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		tree.root=tree.Insert(tree.root, 8);


		tree.root=tree.Insert(tree.root, 12);
		tree.root=tree.Insert(tree.root, 2);
		tree.root=tree.Insert(tree.root, 1);
		
		tree.Inorder(tree.root);
	}
	
	
}