package Heap;

import java.util.Scanner;
import java.util.Vector;


public class Heap {
	Vector<Integer> vec;
	int arrHeap[];

	public Heap() {
		// TODO Auto-generated constructor stub
		int valor,op;
		vec = new Vector<Integer>();
		vec.add(0);
		do{
			Scanner sc = new Scanner(System.in);
			System.out.println("HEAP");
			System.out.println("1. Insertar ");
			System.out.println("2. Borrar");
			System.out.println("3. Salir");
			System.out.println("Escoja una Opcion: ");
			String s = sc.nextLine();
			op = Integer.parseInt(s);
			switch(op){
			case 1:
				System.out.println("Ingrese un valor: ");
				s = sc.nextLine();
				valor = Integer.parseInt(s.trim());
				Inserta(valor);
				System.out.println("Arreglo: "+vec.toString());
				break;
			case 2:
				System.out.println("Elemento borrado: "+vec.get(1));
				borrar();
				System.out.println("Arreglo: "+vec.toString());
				break;
			}
		}while(op!=0);

	}
	public void Inserta(int valor){
		vec.add(valor);
		if(vec.get(vec.size()/2)!=0)
			validarIns(valor, vec.size()-1);
	}
	public void validarIns(int valor,int pos){
		if(vec.get(pos/2)>valor&&(pos/2)!=0){
			vec.add(pos, vec.get(pos/2));
			vec.remove(pos+1);
			vec.remove(pos/2);
			vec.add(pos/2,valor);
			validarIns(valor,pos/2);
		}
		else
			return;

	}
	public void borrar(){
		validarBor(1);
	}
	public void validarBor(int pos){
		int menor;
		if(((pos*2)+1)<=vec.size()){
			if(vec.get(pos*2)<=vec.get((pos*2)+1))
				menor =pos*2;
			else
				menor=(pos*2)+1;
			vec.add(pos, vec.get(menor));
			vec.remove(pos+1);
			validarBor(menor);
		}
		else{
			vec.remove(pos);
			return;
		}
	}
	public static void main(String[] args) {
		// TODO code application logic here
		Heap app = new Heap();
	}


}
