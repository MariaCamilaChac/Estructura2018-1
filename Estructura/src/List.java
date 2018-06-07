/**
* Data Structure, List
*	@author :Camila chacón
*	@date 19-03-2019
*	@version 1
**/
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class List {//Class List
	
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
			
		}else{
			
		Node temp = head;
		
		while(temp.next != null) {
			
			temp = temp.next;
		}
		temp.next = newNode;	
	}
}//end method
	
	public void inserAtInedex(Node newNode , int index){//Method insert at index of the list
		
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
		head = head.next;
		temp = null;
		System.gc();
		
	}//end method
	
	public void deleteAtEnd(){//method delete at end of the list
		
		Node temp;
		Node Pre = head;
		
		while(Pre.next.next != null) {
			Pre = Pre.next;
		}
		
		temp = Pre.next;
		Pre.next = null;
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
	
	public void reverse(){//Method that gets the inverse of a list (Using Clone)
		
		Stack tempList = new Stack();
		Node temp = head;
		
		while(temp != null) {
			
			tempList.Push(temp.clone());
			temp = temp.next;
			
		}
		
		head = tempList.head;
		
	}//end method
	
	public void quickSort() throws IOException {//Sort list by criterion (Quicksort)
		
	if(!isEmpty()) {//Check is empty
		
		List leftSet = new List();
		List rightSet = new List();
		
		Node pivot = head;
		Node temp = head.next;
		
		while(temp != null)
		{
			if(temp.age < pivot.age) {
				
				leftSet.insertAtEnd(temp.clone());
				
			}else {
				
				rightSet.insertAtEnd(temp.clone());
			}
			
			temp = temp.next;
		}
		
		leftSet.quickSort();
		rightSet.quickSort();
		
		pivot.next = rightSet.head;
		leftSet.insertAtEnd(pivot);
		head = leftSet.head;
		
	}
}//end method
	
	public Node getNode(int index) {//Lineal Search in ths list
		
		if(listSize()<index) {
			return null;
		}else {
			
			Node temp = head;
			for (int i = 0; i < index; i++) {
				
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

	
	public int binarySearch(int index) {
		
		int  inicio = 0;
		int  finall = listSize();
		int Num=0;
		int result;
		boolean Positive = false ;
		
		while(!(Positive) && inicio <=finall ){
			int mitad = ((inicio + finall)/2);
			
			
			if ( getNode(mitad).age == index){
				Positive = true;
				Num=mitad;
			}else
				if(index < getNode(mitad).age)
					finall=mitad-1;
				 else
					if(index > getNode(mitad).age)
					inicio= mitad+1;	
		
		}
		if(Positive)
			 System.out.println(result=Num);
		else
			System.out.println((result=-1) +" not found");
		
		
		return result;
				
	} 
	
public void Info_Update(String Nombre,int Edad, int ID , int index){//Method insert at index of the list
		
		Node pre = head;
		
		for (int i = 0; i < index; i++) {
			
			pre = pre.next;
		}
		
		pre.age = Edad;
		pre.name = Nombre;
		pre.id = ID;
		
	}//end method

	
	public static void main(String[] args) throws IOException {
		
		List student = new List();//creation object
		
		//Enter student data
		student.insertAtBegin(new Node("Danilo" , 19 , 5948));
		student.insertAtBegin(new Node("camila" , 20 , 8912));
		student.insertAtBegin(new Node("paula" , 28 , 5920));
		student.insertAtEnd(new Node("pepe" , 30, 564812));
		student.inserAtInedex(new Node("pepito", 43 , 1589),2);
		
		student.quickSort();

		student.printList();
		student.binarySearch(28);
		
		student.Info_Update("jhon", 17, 134222, 3);
		student.printList();

		
	}//end main method
	
}