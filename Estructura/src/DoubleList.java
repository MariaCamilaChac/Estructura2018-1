import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class DoubleList {
	
	public NodoDoble head= null;
	

	public boolean isEmpty() {//Method Check if empty
		
		return head == null ? true : false;
	}//end methoh
	
	public void Insertar(int Node){
	
		NodoDoble nuevo = new NodoDoble(Node);
        if(isEmpty()){
        
        	head=nuevo;
       
        }
        else{
        	
        	nuevo.siguiente=head;
        	head=nuevo;
        	
        }
	}
	
	public void insertarFinal(int Node){
       
		NodoDoble nuevo = new NodoDoble(Node);
       
        if(isEmpty())
           	head = nuevo;   	
        
        else{
        	
        	NodoDoble aux = head;
        	while(aux.siguiente != null){
        		aux = aux.siguiente;
       
        	}
        	aux.siguiente=nuevo;
        	nuevo.anterior=aux;
        	
        	
        }	
       
	}
	
	public void eliminaValor(int valor){
       
		if (!isEmpty()){
			NodoDoble aux =head;
			NodoDoble ant = null;
			while (aux != null){
				if (aux.dato == valor ){
					if (ant == null){
						head = head.siguiente;
						aux.siguiente=null;
						aux=head;
						
					}
					else {
						ant.siguiente= aux.siguiente;
						aux.siguiente=null;
						aux = ant.siguiente;
					}                                             
				}
				else{
					ant = aux;
					aux = aux.siguiente;
				}
			}
		}  
	}
	
public void printList() throws IOException {//Method that prints the contents of the list
		
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		NodoDoble temp = head;
		while(temp != null) {
			
			bw.write(temp.dato+"\n");
			temp = temp.siguiente;
		}
		bw.write("\n");
		bw.flush();
	}//end method

	
	
	public static void main(String[] args) throws IOException {
		
		DoubleList Double = new DoubleList();
		Double.Insertar(9);
		Double.insertarFinal(1);
		Double.insertarFinal(0);
		Double.printList();
		Double.eliminaValor(9);
		
		Double.printList();
		
	}

	

}
