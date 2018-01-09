/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author USRGAM
 */
public class Grafo {

	/**
	 * @param args the command line arguments
	 */
	public Nodo[] gr;
	boolean[] Marcado;
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO code application logic here
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el nnumero de nodos del Grafo: ");
		String s = sc.nextLine();
		Grafo Gr = new Grafo(Integer.parseInt(s));
		for(int i =0; i < Gr.gr.length; i++)
		{
			Nodo node = Gr.gr[i];
			do{
				System.out.println("ingrese adyacencias para el nodo: "+i);
				s=sc.nextLine();
				//puede ingresar solo un numero o varios poniendo cualquier caracter como delimitador y asu vez como fin de adyacencias
				for(int j=0;j<s.length();j++){
					if(s.substring(j, j+1).matches("(\\d)")==true){
						node.enlace=new Nodo(Integer.parseInt(s.substring(j, j+1)));
						node=node.enlace;
					}
				}			
			}while(s.substring(s.length()-1, s.length()).matches("(\\d)")==true);
		}
		System.out.println("grafo"+Arrays.toString(Gr.gr));
		for(int i=0;i<Gr.V();i++){
			System.out.println("nodo "+i+": "+Arrays.toString(Gr.adj(i)));
		}
		System.out.println("Recorrido");
		Gr.RecorreProfundidad(Gr, 0);
	}
	public Grafo(int n)
	{
		gr = new Nodo[n];
		for(int i =0;i<gr.length;i++){
			gr[i]=new Nodo(i);
		}
	}
	public int V()
	{
		return gr.length;
	}
	public int[] adj(int n)
	{
		Nodo node = gr[n];
		int cont =0;
		while(node.enlace !=null)
		{
			cont++;
			node =node.enlace;
		}
		int[] vector = new int [cont];
		node = gr[n].enlace;
		for (int j=0; j< cont ;j++)
		{
			vector[j]= node.dato;
			node = node.enlace;
		}
		return vector;
	}
	public int E()
	{
		int cont =0;
		for(int i =0;i<gr.length;i++)
		{
			cont += adj(i).length/2;
		}
		return cont ;
	}
	public void toString (Grafo G)
	{
		for (int i =0;i<G.gr.length;i++)
		{
			System.out.println(G.gr[i]+"***");
		}
	}
	public void RecorreProfundidad(Grafo G, int fuente)
	{
		Marcado = new boolean [G.V()];
		for (int i=0; i<G.V();i++)
		{
			Marcado [i]=false;
		}
		DFS(G, fuente);
	}
	public void DFS(Grafo Gr,int fuente){
		if (Marcado[fuente]==false)
		{
			Marcado[fuente]=true;
			System.out.println("Nodo"+fuente);
			for(int j=0;j<Gr.adj(fuente).length;j++){
				if (Marcado[Gr.adj(fuente)[j]]==false){
					DFS(Gr, Gr.adj(fuente)[j]);
				}
			}
		}				
	}
}



