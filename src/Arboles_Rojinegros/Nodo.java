package Arboles_Rojinegros;

public class Nodo {
	 
    /* Declaraciones de variables */
    private int clave;
    private int color; 
    private Nodo padre;
    private Nodo izq;
    private Nodo der;
 
    /* Constructor */
    public Nodo() {
        this.padre =null;
        this.color = 1;
        this.izq=null;
        this.der=null;
    }
    public Nodo(int clave) {
        this.clave = clave;
        this.color = 1;
        this.padre =null;
        this.izq=null;
        this.der=null;
    }
 
    /* Setters y Getters */
    public void setClave(int clave) {
        this.clave = clave;
    }
 
    public int getClave() {
        return clave;
    }
 
    public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public Nodo getPadre() {
        return padre;
    }
 
    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
 
    public Nodo getIzq() {
        return izq;
    }
 
    public void setIzq(Nodo izq) {
        this.izq = izq;
    }
 
    public Nodo getDer() {
        return der;
    }
 
    public void setDer(Nodo der) {
        this.der = der;
    }

	@Override
	public String toString() {
		String col="",red="",res="";
		if(color==1){
			col="rojo";
		}
		else
			col="negro";
		return red+clave + " "+col+res;
	}   
}