package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph {

	public ArrayList<ArrayList<Nodo>> gr;
	public Graph() {
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		// TODO code application logic here
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = Integer.parseInt(s);
		Graph Gr = new Graph(n);
		System.out.println("Ingrese el nnumero de nodos del Grafo: ");
		s = sc.nextLine();
		for(int i =0; i < n; i++)
		{
			ArrayList<Nodo> node = new ArrayList<>();
			node.add(new Nodo(i));
			do{
				System.out.println("ingrese adyacencias para el nodo: "+i);
				s=sc.nextLine();
				if(!s.equals("**")){
					node.add(new Nodo(Integer.parseInt(s)));
				}
			}while(!s.equals("**"));
			Gr.gr.add(i, node);
		}
	}
	public Graph(int n)
	{
		gr=new ArrayList<ArrayList<Nodo>>();
		ArrayList<Nodo> node = new ArrayList<Nodo>();
		for(int i =0; i<n;i++)
		{
			node = new ArrayList<>();
			node.add(new Nodo(i));
			gr.add(node);
		}
	}
	public int V()
	{
		return gr.size();
	}
	public int[] adj(int n)
	{
		ArrayList<Nodo> node = gr.get(n);
		int[] vector = new int [node.size()-1];
		for (int j=0; j< node.size()-1 ;j++)
		{
			vector[j]= node.get(j+1).dato;
		}
		return vector;
	}
	public int E()
	{
		int cont =0;
		for(int i =0;i<gr.size();i++)
		{
			cont += adj(i).length/2;
		}
		return cont ;
	}
	public void toString (Graph G)
	{
		for (int i =0;i<G.gr.size();i++)
		{
			System.out.println(G.gr.get(i).get(0)+"***");
		}
	}
}
