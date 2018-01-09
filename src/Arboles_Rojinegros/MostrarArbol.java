package Arboles_Rojinegros;

import java.awt.*;
import java.awt.event.*;

public class MostrarArbol extends Frame implements ActionListener{

	private RBArbol A=new RBArbol();
	private TextField txtNumIngresado; // campo para ingresar el numero del nuevo nodo que se desea insertar
	private Button btnInserta; // boton para la accion de insertar un nuevo nodo
	private TextField txtNumBusqueda; // campo para ingresar el numero del nodo que se desea buscar
	private Button btnBusca; // boton para la accion de buscar un nodo
	private TextField txtNumEliminar; // campo para ingresar el numero del nodo que se desea buscar
	private Button btnEliminar; // boton para la accion de buscar un nodo
	private TextField txtMensaje; // campo para mandar mensajes al usuario
	private ScrollPane scrllpane; // area para desplegar el arbol graficamente
	private Label grafica; // control utilizado para graficar el arbol
	private Nodo nodEncontrado; // para busquedas guarda la referencia del nodo encontrado para resaltarlo

	// constructor de la clase crea la ventana y sus controles
	public MostrarArbol(){
		// creando los controles y sus caracteristicas
		Panel pan1=new Panel(new GridLayout(4,0));
		Panel reg1=new Panel(new FlowLayout());
		txtNumIngresado = new TextField(5);
		Button botonInserta = new Button("Insertar");
		botonInserta.addActionListener(this);
		Panel reg2=new Panel(new FlowLayout());
		txtNumBusqueda = new TextField(5);
		btnBusca = new Button("Buscar");
		btnBusca.addActionListener(this);
		Panel reg3=new Panel(new FlowLayout());
		txtNumEliminar = new TextField(5);
		btnEliminar = new Button("Eliminar");
		btnEliminar.addActionListener(this);
		Panel reg4=new Panel(new FlowLayout());
		txtMensaje = new TextField(65);
		txtMensaje.setEditable(false);
		grafica=new Label(){ // sobrecarga del metodo paint del control para hacer que dibuje el arbol
			public void paint(Graphics grph){
				dibujaArbol(grph);
			};
		};
		scrllpane=new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
		scrllpane.add(grafica);
		pan1.add(reg1);
		pan1.add(reg2);
		pan1.add(reg3);
		pan1.add(reg4);
		reg1.add(botonInserta);
		reg1.add(new Label("Numero:"));
		reg1.add(txtNumIngresado);
		reg2.add(btnBusca);
		reg2.add(new Label("Numero:"));
		reg2.add(txtNumBusqueda);
		reg3.add(btnEliminar);
		reg3.add(new Label("Numero:"));
		reg3.add(txtNumEliminar);
		reg4.add(new Label("Mensaje:"));
		reg4.add(txtMensaje);
		add(pan1,BorderLayout.NORTH);
		add(scrllpane,BorderLayout.CENTER);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		nodEncontrado=null;
		// dandole caracteristicas a la ventana
		setTitle("Arbol roji-negro");
		setSize(1000,578);
		setVisible(true);
	}

	// realiza lass opciones de los botones
	public void actionPerformed(ActionEvent e){
		Button fuente=(Button)e.getSource();
		int numero=0;
		String textonum="";
		txtMensaje.setText("");
		nodEncontrado=null;
		try{
			if(fuente.getLabel().equals("Insertar")){
				// inserta un nuevo nodo si el numero ingresado es un entero valido y no esta vacia
				if(txtNumIngresado.getText().length()==0){
					// si el numero no es ingresado enviar mensaje de error
					txtMensaje.setText("Clave vacia");
					return;
				}
				textonum=txtNumIngresado.getText();
				numero=Integer.parseInt(textonum);
				if(A.getRaiz()==null)
					A=new RBArbol(numero);
				else
					A.inserta(A, new Nodo(numero));
				txtMensaje.setText("Insertado "+numero);
				txtNumIngresado.setText("");
			}
			else if(fuente.getLabel().equals("Buscar")){
				if(txtNumBusqueda.getText().length()==0){
					// si el numero no es ingresado enviar mensaje de error
					txtMensaje.setText("Clave vacia");
					return;
				}
				// busca un nodo si el numero ingresado es un entero valido
				textonum=txtNumBusqueda.getText();
				numero=Integer.parseInt(textonum);
				nodEncontrado=A.buscar(A.getRaiz(), new Nodo(numero));
				if(nodEncontrado==null) txtMensaje.setText("No se encontro");
				else txtMensaje.setText("Encontrado: ["+nodEncontrado.getClave()+"]");
				txtNumBusqueda.setText("");
			}
			else if(fuente.getLabel().equals("Eliminar")){
				if(txtNumEliminar.getText().length()==0){
					// si el numero no es ingresado enviar mensaje de error
					txtMensaje.setText("Clave vacia");
					return;
				}
				// busca un nodo si el numero ingresado es un entero valido
				textonum=txtNumEliminar.getText();
				numero=Integer.parseInt(textonum);
				nodEncontrado=A.buscar(A.getRaiz(), new Nodo(numero));
				if(nodEncontrado==null) txtMensaje.setText("No se encontro");
				else{ 
					txtMensaje.setText("Eliminado "+numero);
					A.borra(A, nodEncontrado);
				}
				txtNumEliminar.setText("");
			}
		}
		catch(NumberFormatException ex){
			// si el numero no es valido enviar mensaje de error
			txtMensaje.setText("Error numero: ["+textonum+"]");
		}
		grafica.repaint();
	}

	// funcion que prepara el control grafica para dibujar el arbol
	private void dibujaArbol(Graphics grph){
		// tamaño del nodo 50x50 espacio entre nodos vertical 20 horizontal minimo 20
		// calcular tamaño de toda la grafica
		int altura=calculaProfundidad(A.getRaiz());
		int anchura=(int)Math.pow(2,(altura-1));
		if(altura==0) return;
		grafica.setPreferredSize(new Dimension((anchura*70)+40,(70*altura)+20));
		grph.setColor(Color.WHITE);
		grph.clearRect(0,0,(anchura*70)+40,(70*altura)+20);
		// enviar a dibujar el nodo raiz y este a su vez enviara al resto de los nodos
		dibujaNodo(grph,A.getRaiz(),25,(int)((70*anchura))/2);
		scrllpane.doLayout();
	}

	// calcula la el numero de nodos de profundidad del arbol para calcular el arrea que ocupara el grafico
	// segun el numero de nodos
	private int calculaProfundidad(Nodo inicial){
		int profIzq=0;
		int profDer=0;
		if(inicial==null) return 0;
		if(inicial.getIzq()!=null)
			profIzq=calculaProfundidad(inicial.getIzq());
		if(inicial.getDer()!=null)
			profDer=calculaProfundidad(inicial.getDer());
		return (profIzq>profDer?profIzq:profDer)+1;
	}
	private int cuentaMult(Nodo N,int cont){
		int NMult;
		if(N==null)
			return cont;
		if(N.getClave()==11)
			cont++;
		else{
			cont=cuentaMult(N.getIzq(), cont);
			cont=cuentaMult(N.getDer(), cont);
		}
		return NMult = cont;
	}
	private int calculaProfundidad(Nodo inicial, int cont){
		int profIzq=0;
		int profDer=0;
		if(inicial==null) return 0;
		cont=1;
		profIzq=cont+calculaProfundidad(inicial.getIzq(),cont);
		profDer=cont+calculaProfundidad(inicial.getDer(),cont);
		return (profIzq>=profDer?profIzq:profDer);
	}

	// dibuja un nodo y si este nodo tiene al menos un hijo tambien lo envia a dibujar
	private void dibujaNodo(Graphics grph, Nodo nodo, int y, int x){
		Color color=(nodo!=null?(nodo.getColor()==1?Color.RED:Color.BLACK):Color.YELLOW);
		int altura=calculaProfundidad(nodo)-1;
		int anchura=(int)Math.pow(2,altura);
		anchura=((anchura*70)+40)/4;
		if(nodo!=null && (nodo.getIzq()!=null||nodo.getDer()!=null)){
			grph.setColor(Color.GREEN);
			grph.drawLine(x+25,y+25,x-anchura+25,y+95);
			grph.drawLine(x+25,y+25,x+anchura+25,y+95);
		}
		grph.setColor(color);
		if(nodo!=null && nodo.getColor()==1) grph.fillRect(x,y,50,50);
		grph.fillOval(x,y,50,50);
		if(nodo!=null){
			if(nodo==nodEncontrado){
				grph.setColor(Color.GREEN);
				for(int c=2;c<=3;c++)
					if(nodEncontrado.getColor()!=1) grph.drawOval(x+c,y+c,48-(2*c),48-(2*c));
					else grph.drawRect(x+c,y+c,49-(2*c),49-(2*c));
			}
			grph.setColor(nodo.getColor()==1?Color.BLACK:Color.WHITE);
			grph.drawString(""+nodo.getClave(),x+20,y+30);
			if(nodo.getIzq()!=null||nodo.getDer()!=null){
				dibujaNodo(grph,nodo.getIzq(),y+70,(x-anchura));
				dibujaNodo(grph,nodo.getDer(),y+70,(x+anchura));
			}
		}
		else{
			grph.setColor(Color.BLACK);
			grph.drawString("null",x+15,y+30);
		}
	}

	public static void main(String[] args){
		@SuppressWarnings("unused")
		MostrarArbol app = new MostrarArbol();
	}
}
