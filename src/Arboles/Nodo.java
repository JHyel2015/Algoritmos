package Arboles;

public class Nodo {
	protected String elemento;
	protected Nodo next,prev;
	public Nodo(){
		this.elemento="";
		this.next = null;
		this.prev = null;
	}
	public Nodo(String elemento){
		this.elemento=elemento;
		this.next = null;
		this.prev = null;
	}
	public Nodo(Nodo prev, String elemento, Nodo next) {
		super();
		this.elemento = elemento;
		this.next = next;
		this.prev = prev;
	}
	public String getElemento() {
		return elemento;
	}
	public void setElemento(String elemento) {
		this.elemento = elemento;
	}
	public Nodo getNext() {
		return next;
	}
	public void setNext(Nodo next) {
		this.next = next;
	}
	public Nodo getPrev() {
		return prev;
	}
	public void setPrev(Nodo prev) {
		this.prev = prev;
	}
	@Override
	public String toString() {
		if(next!=null)
			return elemento +"\n"+ next;
		else
			return elemento;
	}
	public String toString1() {
		if(prev!=null)
			return elemento +"\n"+ prev.toString1();
		else
			return elemento;
	}

}
