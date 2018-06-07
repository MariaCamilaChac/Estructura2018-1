/**

* Data Structure, Stack
*	@author :Camila chacón
*	@date 19-03-2019
*	@version 1
*
**/

import java.io.IOException;

public class Stack { //
	
	public Node head= null;//global variable
	
	public boolean isEmpty() {  //check if the Stack is empty 
		
		return head == null ? true : false;
	}

	public Node Pop(){ //delete the first of Stack
		
		Node temp = head;  
		head = head.next;
		return temp;
		
	}
	
	public void Push(Node newNode){ // insert at begin new node
		
		newNode.next = head;
		head = newNode;
		
	}
	
}

