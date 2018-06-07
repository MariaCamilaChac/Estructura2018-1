/** @author Camila Chacon   **/
package arbol;

public class Tree{
	public Tree(){}
	
	
	Node_Tree root =null;
	
	
	public boolean isEmpty() {
		return root == null? true : false;
	}
	
	
	public void Insert(int value) {
		if (isEmpty()) {
			Node_Tree temp = new Node_Tree(value);
			root =temp;
		}
		else {
			
			Node_Tree temp = root;
			Node_Tree parent = root;
			
			while(temp != null) {
				parent = temp;
				if (temp.value<value)
					temp= temp.Tree_rigth;
				
				else
					temp=temp.Tree_left;
			}
			
			Node_Tree newNode = new Node_Tree (value);
			if (parent.value < value) 
				parent.Tree_rigth=newNode;
			else 
				parent.Tree_left=newNode;
		
		}
	}
	
	public boolean isLeaf(Node_Tree node) {
		return(node.Tree_left==null && node.Tree_rigth == null)? true:false;
	}
	
	public boolean oneChild(Node_Tree node) {
		return (node.Tree_left==null && node.Tree_rigth==null)? false:true;
	}
	
	public void Delete(int value){
		
		Node_Tree temp= root;
		
		while (temp != null) {
			
			if(temp.value==value) {
		
				break;
			}
			if (value < temp.value) 
				temp = temp.Tree_left;
			
			else
				temp = temp.Tree_rigth;
		}
		if(temp==null){
			System.out.println("this value doesn't exist");
		}
		Node_Tree parent=root; 
		if(isLeaf(temp)) {
			temp=null;
			if(value < parent.value) 
				parent.Tree_left = null;
			
			else 
				parent.Tree_rigth= null;
		}
			else {
				if(oneChild(temp)) {
					
					if(temp.Tree_left != null) {
						
						if(value < parent.value)
							parent.Tree_left = temp.Tree_left;
						else
							parent.Tree_rigth=temp.Tree_left;
					}
					else{
						if(value < parent.value)
							parent.Tree_left = temp.Tree_rigth;
						else
							parent.Tree_rigth=temp.Tree_rigth;
					}
					temp=null;
				}
				
				else {
					
					Node_Tree temp2 = temp.Tree_rigth;
					
					if(temp2.Tree_left==null){
						
						temp2.Tree_left=temp.Tree_left;
						
						if(value < parent.value)
							parent.Tree_left = temp2;
						else
							parent.Tree_rigth=temp2;
					} 
						
					
				}
				
			}
	
			
	}
	
	
	public Node_Tree Search (int value) {
		
		Node_Tree temp= root;
		
		while (temp != null) {
			
			if(temp.value==value) {
		
				break;
			}
			if (value < temp.value) 
				temp = temp.Tree_left;
			
			else
				temp = temp.Tree_rigth;
		}
		return temp;
	}
	
	
	public void Preorder(Node_Tree node) {
		if(node != null) {
			System.out.println(node.value+ " ");
			Preorder(node.Tree_left);
			Preorder(node.Tree_rigth);

		}
	}
	
	
	public void Postorder(Node_Tree node) {
		if(node != null) {
			
			Postorder(node.Tree_left);
			Postorder(node.Tree_rigth);
			System.out.println(node.value+" ");
		}
	}
	
	
	public void Inorder(Node_Tree node) {
		if(node != null) {
			
			Inorder(node.Tree_left);
			System.out.println(node.value+" ");
			Inorder(node.Tree_rigth);
			
		}
	}
	

	public static void main(String[] args) {
		Tree testTree = new Tree();
		testTree.Insert(2);
		testTree.Insert(4);
		testTree.Insert(32);
		testTree.Insert(1);
		System.out.println(" preorder \n");
		testTree.Preorder(testTree.root);
		System.out.println();
		System.out.println(" inorder \n");
		testTree.Inorder(testTree.root);
		System.out.println();
		System.out.println("Postorder");
		testTree.Postorder(testTree.root);
		testTree.Delete(4);
		System.out.println("\n");
		testTree.Inorder(testTree.root);
		testTree.Search(1);
		
	}


}