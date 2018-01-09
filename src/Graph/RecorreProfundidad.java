package Graph;

public class RecorreProfundidad {

	boolean[] Marcado;
	public RecorreProfundidad() {
		// TODO Auto-generated constructor stub
	}
	public RecorreProfundidad(Graph G, int fuente)
	{
		Marcado = new boolean [G.gr.size()];
		for (int i=0; i<G.gr.size();i++)
		{
			Marcado [i]=false;
		}
		DFS(G, fuente);
	}
	public void DFS(Graph Gr, int fuente){
		if (!Marcado[fuente])
		{
			System.out.println("Nodo"+fuente);
			for(int j=0;j<Gr.adj(fuente).length;j++)
				if (!Marcado[j])
					DFS(Gr, j);
		}
	}
}
