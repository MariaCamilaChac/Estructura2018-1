/**
* Data Structure, Node
*	@author :Camila chacón
*	@date 19-03-2019
*	@version 1
**/
// this is father class or principal class
public class Node {
	
	
	public String name; //global variable
	public int age; //global variable
	public int id; //global variable
	
	public Node next; //pointer
	public int value;

	
	public Node() {} //empty constructor
	
	public Node (String name, int age, int id) {
		
		this.name = name;
		this.age = age;
		this.id = id;
	}
	
	
	public String toString() { //print in console
		return "Name: " + this.name + "\tAge: " + this.age + " \tID " + this.id; 
	}
	
	
	public Node clone() { //clone the principal list
		Node clone = new Node (this.name, this.age, this.id);
		return clone;
	}

}
