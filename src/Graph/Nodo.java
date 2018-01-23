package Graph;

public class Nodo {
	int dato;
	Nodo enlace;
	boolean direccion;

	public Nodo() {
		// TODO Auto-generated constructor stub
	}
	public Nodo(int x){
		dato = x;
		enlace = null;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public Nodo getEnlace() {
		return enlace;
	}

	public void setEnlace(Nodo enlace) {
		this.enlace = enlace;
	}
	
	public boolean isDireccion() {
		return direccion;
	}
	public void setDireccion(boolean direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Nodo [dato=" + dato + ", enlace=" + enlace + ", direccion=" + direccion + "]";
	}
	
}
