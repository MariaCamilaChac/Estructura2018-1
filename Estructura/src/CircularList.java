
/**
* Data Structure, List
*	@author :Camila chacón
*	@date 19-03-2019
*	@version 1
**/
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CircularList {//Class List
	
	public Node head = null; //Empty list
	
	public boolean isEmpty() {//Method Check if empty
		
		return head == null ? true : false;
	}//end methoh
	
	public void insertAtBegin(Node newNode){//Method insert at begin of the list
		
		newNode.next = head;
		head = newNode;
		
	}//end method
	
	public void insertAtEnd(Node newNode) {//Method insert at end of the list
		
		if(isEmpty()) {
			
			head = newNode;	
		
			newNode.next=head;
			
		}
		if (listSize() ==1){
			
			head.next=newNode;
			newNode.next=head;
			}	
		else{
			if(listSize() >1){
				Node temp = head;
				while(temp.next != head){
	        		temp = temp.next.next;
	       
	        	}
	        	temp.next=newNode;
	        	
	        	newNode.next=head;
	        	
	        }	
	       
			
	}
}//end method
	
	public void insertAtIndex(Node newNode , int index){//Method insert at index of the list
		
		Node temp;
		Node pre = head;
		
		for (int i = 0; i < index - 1; i++) {
			pre = pre.next;
		}
		
		temp = pre.next;
		newNode.next = temp;
		pre.next = newNode;
		
	}//end method
	
	public void deleteAtBegin(){//method delete at begin of the list
		
		Node temp = head;
		head=head.next;
		Node pre=head.next;

		while(pre.next != head){
			pre = pre.next;
		}
	
		pre.next=head;
		
		temp = null;
		System.gc();		
		
	}//end method
	
	public void deleteAtEnd(){//method delete at end of the list
		
		Node temp;
		Node Pre = head;
		
		while(Pre.next.next != head) {
			Pre = Pre.next;
		}
		
		temp = Pre.next;
		Pre.next = head;
		temp = null;
		System.gc();
		
	}//end method
	
	public void deleteAtIndex(int index) {//method delete at index of the list
		
		Node temp = head;
		
		for (int i = 0; i < index - 1; i++) {
			temp = temp.next;
		}
		
		Node toDelete = temp.next;
		temp.next = toDelete.next;
		toDelete = null;
		System.gc();//Call Garbaje collector (destructor)
		
	}//end method
	

	

	
	public Node getNode(int index) {//Lineal Search in ths list
		
		if(listSize()<index) {
			return null;
		}else { 
			
			Node temp = head;
			for (int i = 0 ; i < index; i++) {
				
				temp = temp.next;
				
			}
			
			return temp;
			
		}
		
	}//end method
	
	
	public int listSize() {//gets List size
		
		int counter = 0;
		Node temp = head;
		
		while(temp != null)
		{
			
			counter +=1;
			temp = temp.next;
			
		}
		
		return counter;
		
	}//end method
	
	public void printList() throws IOException {//Method that prints the contents of the list
		
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		Node temp = head;
		while(temp != null) {
			
			bw.write(temp.toString()+"\n");
			temp = temp.next;
		}
		bw.write("\n");
		bw.flush();
	}//end method

	


	
	public static void main(String[] args) throws IOException {
		
		CircularList student = new CircularList();//creation object
		
		//Enter student data


	student.insertAtBegin(new Node("Dan" , 19 , 5948));
student.insertAtBegin(new Node("Do" , 19 , 5948));
		student.insertAtEnd(new Node("Danilo" , 19 , 5948));
		student.printList();
		
	
		
	}//end main method
	
}
