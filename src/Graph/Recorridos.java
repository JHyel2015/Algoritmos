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
	public void DFSlink(Grafo Gr,int fuente){
		if (Marcado[fuente]==false)
		{
			Marcado[fuente]=true;
			System.out.println("Nodo "+fuente);
			int[] aux=Gr.adj(fuente);
			for(int j=0;j<Gr.adj(fuente).length;j++){
				if (Marcado[aux[j]]==false){
					DFSlink(Gr, aux[j]);
				}
			}
		}				
	}
	public void DFS(Grafo Gr,int fuente){
		for(int i=fuente;i<Marcado.length;i++){
			if(Marcado[i]==false){
				DFSlink(Gr, i);
			}
		}
	}
	public void BFS(Grafo G){
		int aux,aux2;
		marcar(G);
		cola = new LinkedList<Integer>();
		cola.add(G.gr[0].dato);
		Marcado[G.gr[0].dato]=true;
		while(!cola.isEmpty()){
			aux = cola.remove();
			for(int i=0;i<G.adj(aux).length;i++){
				aux2=G.adj(aux)[i];
				if(!Marcado[aux2]){
					cola.add(aux2);
					Marcado[aux2]=true;
					AristaHacia[aux2]=aux;
				}
			}
		}
	}
	public void camino(int ini,int fin){
		if(AristaHacia[fin]==ini){
			System.out.print(ini+" - "+fin);
			return;
		}
		camino(ini,AristaHacia[fin]);
		System.out.print(" - "+fin);
	}
}
