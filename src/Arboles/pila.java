package Arboles;

public class pila {
	private Nodo tail,head;
	private int size;
	public pila() {
		// TODO Auto-generated constructor stub
		this.head=new Nodo(null);
		this.tail=head;
		this.size=0;
	}
	public int getSize(){
		return size;
	}
	public boolean esVacia(){
		return this.size==0;
	}
	public Nodo getTail() {
		if(esVacia()==true)
			return null;
		return tail;
	}
	public void push(Object dato){
		Nodo nodo=new Nodo(null, String.valueOf(dato), null),aux=head;
		if(esVacia()==true){
			head=nodo;
			tail=head;
		}else{
			nodo.setPrev(tail);
			tail.setNext(nodo);
			tail=nodo;
		}
		this.size++;
	}
	public Nodo pop(){
		if(esVacia()!=true){
			Nodo last,prevLast;
			last=getTail();
			prevLast=last.getPrev();
			prevLast.setNext(null);
			this.tail=prevLast;
			this.size--;
			return last;
		}
		return null;
	}
	public void vaciar(){
		this.head = null;
		this.size = 0;
	}
	@Override
	public String toString() {
		return "" + head;
	}
	public String toString1() {
		return "" + tail.toString1();
	}

}
