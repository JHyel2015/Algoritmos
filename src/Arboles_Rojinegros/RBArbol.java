package Arboles_Rojinegros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RBArbol {
	public static final String ANSI_RED = "\u001B[1;31m";
	/* Atributos */
	private Nodo raiz;
	/* Contructories */ 
	public RBArbol() /*throws NumberFormatException, IOException*/ {
		// TODO Auto-generated constructor stub
		this.raiz =null;
		/*int n=0;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		System.out.println("Ingrese un nodo: ");
		n = Integer.parseInt (br.readLine());
		RBArbol A=new RBArbol(n);*/
		//A=new Arbol(26);
		/*inserta(A,new Nodo(17));
		inserta(A,new Nodo(41));
		inserta(A,new Nodo(14));
		inserta(A,new Nodo(21));
		inserta(A,new Nodo(30));
		inserta(A,new Nodo(47));
		inserta(A,new Nodo(10));
		inserta(A,new Nodo(16));
		inserta(A,new Nodo(19));
		inserta(A,new Nodo(23));
		inserta(A,new Nodo(28));
		inserta(A,new Nodo(38));
		inserta(A,new Nodo(7));
		inserta(A,new Nodo(12));
		inserta(A,new Nodo(15));
		inserta(A,new Nodo(20));
		inserta(A,new Nodo(35));
		inserta(A,new Nodo(39));
		inserta(A,new Nodo(2));*/
		//System.out.println(A.toString3());

		/*while(true){
			System.out.println("Ingresar otro nodo");
			n = Integer.parseInt (br.readLine());
			if(n==-1)
				break;
			inserta(A,new Nodo(n));
			System.out.println(A.toString3());
		}*/
		/*borra(A, new Nodo(14));
		System.out.println("Borrado\nBorrar " + new Nodo(14));
		System.out.println(A.toString3());*/
		/*while(true){
			System.out.println("Ingresar nodo para borrar");
			n = Integer.parseInt (br.readLine());
			if(n==-1)
				break;
			borra(A,new Nodo(n));
			System.out.println(A.toString3());
		}*/

	}
	public RBArbol( int clave ) {
		this.raiz = new Nodo( clave );
		this.raiz.setColor(0);
	} 
	public RBArbol( Nodo raiz ) {
		this.raiz = raiz;
	} 
	/* Setters y Getters */
	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	public void addNodoABB( Nodo raiz, Nodo nodo ) {
		/* 2.- Partiendo de la raíz preguntamos: Nodo == null ( o no existe ) ? */
		if ( raiz == null) {
			/* 
			 * 3.- En caso afirmativo X pasa a ocupar el lugar del nodo y ya 
			 * hemos ingresado nuestro primer dato. 
			 * ==== EDITO =====
			 * Muchas gracias a @Espectro por la corrección de esta línea
			 */
			raiz = nodo;
		}
		else {
			/* 4.- En caso negativo preguntamos: X < Nodo */
			if ( nodo.getClave() <= raiz.getClave() ) {
				/* 
				 * 5.- En caso de ser menor pasamos al Nodo de la IZQUIERDA del
				 * que acabamos de preguntar y repetimos desde el paso 2 
				 * partiendo del Nodo al que acabamos de visitar 
				 */
				if (raiz.getIzq() == null) {
					raiz.setIzq(nodo);
					nodo.setPadre(raiz);
				}
				else {
					addNodoABB( raiz.getIzq(), nodo );
				}
			}
			else {
				/* 
				 * 6.- En caso de ser mayor pasamos al Nodo de la DERECHA y tal
				 * cual hicimos con el caso anterior repetimos desde el paso 2
				 * partiendo de este nuevo Nodo.
				 */
				if (raiz.getDer() == null) {
					raiz.setDer(nodo);
					nodo.setPadre(raiz);
				}
				else {
					addNodoABB( raiz.getDer(), nodo );
				}
			}
		}
	}
	public Nodo sucesorABB(Nodo z){
		return buscar(raiz,z).getDer();
	}
	public Nodo buscar(Nodo raiz,Nodo x){
		Nodo a= raiz;
		while(a!=null){
			int aux = a.getClave();
			if(aux==x.getClave())
				return a;
			else if(aux>x.getClave())
				a=a.getIzq();
			else if(aux<x.getClave())
				a=a.getDer();
		}
		return null;
	}
	public void rota_i(RBArbol A, Nodo x){
		Nodo y = x.getDer();
		x.setDer(y.getIzq());
		if(y.getIzq()!=null){
			y.getIzq().setPadre(x);
		}
		y.setPadre(x.getPadre());
		if(x.getPadre()==null){
			A.setRaiz(y);
		}else{
			if(x.equals(x.getPadre().getIzq())){
				x.getPadre().setIzq(y);
			}else
				x.getPadre().setDer(y);
		}
		y.setIzq(x);
		x.setPadre(y);
	}
	public void rota_d(RBArbol A, Nodo x){
		Nodo y = x.getIzq();
		x.setIzq(y.getDer());
		if(y.getDer()!=null){
			y.getDer().setPadre(x);
		}
		y.setPadre(x.getPadre());
		if(x.getPadre()==null){
			A.setRaiz(y);
		}else{
			if(x.equals(x.getPadre().getDer())){
				x.getPadre().setDer(y);
			}else
				x.getPadre().setIzq(y);
		}
		y.setDer(x);
		x.setPadre(y);
	}
	public void inserta(RBArbol A, Nodo x){
		Nodo y;
		if(buscar(A.raiz, x)!=null)
			return;
		addNodoABB(A.getRaiz(), x);
		x=buscar(A.getRaiz(), x);
		x.setColor(1);
		while(x!=A.getRaiz() && x.getPadre().getColor()==1){
			if(x.getPadre()==x.getPadre().getPadre().getIzq()){
				y=x.getPadre().getPadre().getDer();
				if(y==null){
					y=x.getPadre().getPadre();
				}
				if(y.getColor()==1){
					x.getPadre().setColor(0);
					y.setColor(0);
					x.getPadre().getPadre().setColor(1);
					x=x.getPadre().getPadre();
				}else{
					if(x==x.getPadre().getDer()){
						x=x.getPadre();
						rota_i(A, x);
					}
					x.getPadre().setColor(0);
					x.getPadre().getPadre().setColor(1);
					rota_d(A, x.getPadre().getPadre());
				}
			}else{
				y=x.getPadre().getPadre().getIzq();
				if(y==null){
					y=x.getPadre().getPadre();
				}
				if(y.getColor()==1){
					x.getPadre().setColor(0);
					y.setColor(0);
					x.getPadre().getPadre().setColor(1);
					x=x.getPadre().getPadre();
				}else{
					if(x==x.getPadre().getIzq()){
						x=x.getPadre();
						rota_d(A, x);
					}
					x.getPadre().setColor(0);
					x.getPadre().getPadre().setColor(1);
					rota_i(A, x.getPadre().getPadre());
				}				
			}
		}
		A.getRaiz().setColor(0);
	}
	public void borra(RBArbol A,Nodo z){
		Nodo y,x=new Nodo();
		z=A.buscar(A.getRaiz(), z);
		if(z.getIzq()==null || z.getDer()==null)
			y=z;
		else
			y=A.sucesorABB(z);
		if(y.getIzq()!=null)
			x=y.getIzq();
		else
			x=y.getDer();
		if(x!=null)
			x.setPadre(y.getPadre());
		if(y.getPadre()==null)
			A.setRaiz(x);
		else{
			if(y==y.getPadre().getIzq())
				y.getPadre().setIzq(x);
			else
				y.getPadre().setDer(x);
		}
		if(y!=z)
			z.setClave(y.getClave());
		if(x!=null)
			if(y.getColor()==0)
				fija_borrado(A,x);
	}
	public void fija_borrado(RBArbol A,Nodo x){
		Nodo w;
		System.out.println(x.getColor());
		while(x!=A.getRaiz()&& x.getColor()==0){
			if(x==x.getPadre().getIzq()){
				w=x.getPadre().getDer();
				if(w.getColor()==1){
					w.setColor(0);
					x.getPadre().setColor(1);
					rota_i(A, x.getPadre());
					w=x.getPadre().getDer();
				}
				if(w.getIzq().getColor()==0&&w.getDer().getColor()==0){
					w.setColor(1);
					x=x.getPadre();
				}else{
					if(w.getDer().getColor()==0){
						w.getIzq().setColor(0);
						w.setColor(1);
						rota_d(A, w);
						w=x.getPadre().getDer();
					}
					w.setColor(x.getPadre().getColor());
					x.getPadre().setColor(0);
					w.getDer().setColor(0);
					rota_i(A, x.getPadre());
					x=A.getRaiz();
				}
			}else{
				w=x.getPadre().getIzq();
				if(w.getColor()==1){
					w.setColor(0);
					x.getPadre().setColor(1);
					rota_d(A, x.getPadre());
					w=x.getPadre().getIzq();
				}
				if(w.getIzq().getColor()==0&&w.getDer().getColor()==0){
					w.setColor(1);
					x=x.getPadre();
				}else{
					if(w.getIzq().getColor()==0){
						w.getDer().setColor(0);
						w.setColor(1);
						rota_i(A, w);
						w=x.getPadre().getIzq();
					}
					w.setColor(x.getPadre().getColor());
					x.getPadre().setColor(0);
					w.getIzq().setColor(0);
					rota_d(A, x.getPadre());
					x=A.getRaiz();
				}
			}
		}
		x.setColor(0);
	}
	private void inOrden( Nodo raiz)
	{
		if(raiz == null)
			return;

		inOrden(raiz.getIzq());
		System.out.println(raiz);
		inOrden(raiz.getDer());
	}
	private void preOrden( Nodo raiz)
	{
		if(raiz == null)
			return;

		System.out.println(raiz);
		preOrden(raiz.getIzq());
		preOrden(raiz.getDer());
	}
	private void inOrden1( Nodo raiz,int x)
	{
		if(raiz == null)
			return;

		inOrden1(raiz.getDer(),x+1);
		for(int i=0;i<x;i++){
			System.out.print("\t");
		}
		System.out.println(raiz);
		inOrden1(raiz.getIzq(),x+1);
	}
	private void posOrden( Nodo raiz)
	{
		if(raiz == null)
			return;

		posOrden(raiz.getIzq());
		posOrden(raiz.getDer());
		System.out.println(raiz);
	}
	@Override
	public String toString() {
		inOrden(this.getRaiz());
		return "";
	}
	public String toString1() {
		preOrden(this.getRaiz());
		return "";
	}
	public String toString2() {
		posOrden(this.getRaiz());
		return "";
	}
	public String toString3() {
		inOrden1(this.getRaiz(),0);
		return "";
	}
	/*public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		RBArbol app = new RBArbol();

	}*/

}
