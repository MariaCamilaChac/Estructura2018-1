/**

* Data Structure, queue
*	@author :Camila chacón
*	@date 19-03-2019
*	@version 1
*
**/

public class Queue {
	
	public Node head=null; //global variable
	
	public boolean isEmpty() { //check if queue is empty
		
		return head == null ? true : false;
	}

	public void enqueue(Node newNode){ //insert at begin
	
		newNode.next = head;
		head = newNode;
	
	}

	public Node dequeue(){ // Delete at end of queue
	
		Node temp;
		Node Pre = head;
	
		while(Pre.next.next != null) {
			Pre = Pre.next;
		}
	
		temp = Pre.next;
		Pre.next = null;
		System.gc();
		return temp;
	
	}
	

}
