package Graph;

public class Nodo {
	int dato;
	Nodo enlace;

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

	@Override
	public String toString() {
		return "Nodo [dato=" + dato + "\n enlace=" + enlace + "]";
	}
	

}
