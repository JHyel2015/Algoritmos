package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Recorridos {

	boolean[] Marcado;
	int[] AristaHacia;
	Queue<Integer> cola;
	public Recorridos(Grafo G) {
		AristaHacia = new int[G.V()];
		marcar(G);
	}
	public void marcar(Grafo G){
		Marcado = new boolean [G.V()];
		for (int i=0; i<G.V();i++)
		{
			Marcado [i]=false;
		}		
	}
	public void DFS(Grafo Gr,int fuente){
		if (Marcado[fuente]==false)
		{
			Marcado[fuente]=true;
			System.out.println("Nodo "+fuente);
			for(int j=0;j<Gr.adj(fuente).length;j++){
				if (Marcado[Gr.adj(fuente)[j]]==false){
					DFS(Gr, Gr.adj(fuente)[j]);
				}
			}
		}				
	}
	public void BFS(Grafo G){
		int aux;
		marcar(G);
		cola = new LinkedList<Integer>();
		cola.add(G.gr[0].dato);
		Marcado[G.gr[0].dato]=true;
		while(!cola.isEmpty()){
			aux = cola.remove();
			for(int i=0;i<G.adj(aux).length;i++){
				if(!Marcado[G.adj(aux)[i]]){
					cola.add(G.adj(aux)[i]);
					Marcado[G.adj(aux)[i]]=true;
					AristaHacia[G.adj(aux)[i]]=aux;
				}
			}
		}
	}
	public void camino(int ini,int fin){
		
	}
}
