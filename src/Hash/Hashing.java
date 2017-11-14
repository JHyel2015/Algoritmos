package Hash;

import javax.swing.JOptionPane;

public class Hashing {

	public Hashing() {
		// TODO Auto-generated constructor stub
		try {
			String cad;
			int n, op;
			n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la tabla"));
			Key[] k = crearTabla(n);
			do {
				cad="";
				op = Integer.parseInt(JOptionPane.showInputDialog("Menú Principal \n"
						+ "\n1.- Insertar \n2.- Buscar \n3.- Eliminar \n4.- Salir"));
				switch (op) {
				case 1:
					n = Integer.parseInt(JOptionPane.showInputDialog("1.Insertar\nIngrese el número a ser insertado en la tabla:"));
					cad="¡Numero ";
					if(insertarClaveEncade(k, n)!=true)
						cad+="NO insertado";
					else{
						cad+="INSERTADO con exito!";
						showcad(k, n);
					}
					JOptionPane.showMessageDialog(null, cad);
					break;
				case 2:
					n = Integer.parseInt(JOptionPane.showInputDialog("2.- Buscar \nIngrese el número a ser buscado en la tabla(Hashing cerrado):"));
					if (buscarClaveEncade(k, n) == -1) {
						JOptionPane.showMessageDialog(null, "Número no encontrado");
					} else {
						JOptionPane.showMessageDialog(null, "Número encontrado");
					}
					break;
				case 3:
					n = Integer.parseInt(JOptionPane.showInputDialog("3.- Eliminar \nIngrese el número a ser eliminado de la tabla:"));
					eliminarClave(k, n);
					showcad(k, n);
					break;
				case 4:
					System.exit(0);
				default:
				}
			} while (op != 4);
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "Está Saliendo del Programa");
		} catch (OutOfMemoryError ome) {
			JOptionPane.showMessageDialog(null, "No Hay Espacio");
		}
	}
	public int hash(int dat,int n){
		String strnum=String.valueOf(dat),cad="";
		int len = strnum.length();
		if(n<=10){//metodo division
			return (dat+1%n);
		}else if(n<=100){//metodo de los cuadrados
			if((String.valueOf(dat*dat).length()%2==1)){
				return (((dat*dat)*10)%n);
			}			
			return ((dat*dat)%n);
		}else if(n<=1000){//metodo de truncado
			for(int i=1;i<=len;i=i+2){
				cad += strnum.substring(i-1,i);
			}
			return Integer.parseInt(cad);			
		}else{//metodo de pliegamiento
			int i=2;
			do{
				if((len/i)==0){
					return dat;
				}else if((len/i)==1){
					return Integer.parseInt(strnum.substring(0,len-i-1)+strnum.substring(len-i-1,len));
				}else if(len/i<=3&&len/i>1){
					int j;
					for(j=i;j<len;j=j+i){
						cad += strnum.substring(j-i,j);
					}
					System.out.println(j+" "+i);
					cad += strnum.substring(j-2*i,j);
					return Integer.parseInt(strnum.substring(0,0));
				}else
					i++;
			}while(i<=3);
		}
		return 0;
	}
	public Key[] crearTabla(int n){
		Key[] k= new Key[n];
		for(int i=0;i<k.length;i++)
			k[i]=new Key(0);
		return k;
	}
	public boolean insertarClaveEncade(Key[] tabla,int dat){
		Key k = new Key(dat);
		int i=hash(dat,tabla.length);
		System.out.println(i);
		if(tabla[i].clave==0){
			tabla[i]=k;
			return true;
		}else{
			if(tabla[i].cadena==null){
				tabla[i].cadena=k;
				return true;
			}else{
				k.cadena=tabla[i].cadena;
				tabla[i].cadena=k;
				return true;
			}
		}
	}
	public boolean insertarClave(Key[] tabla,int dat){
		Key k = new Key(dat);
		int i=hash(dat,tabla.length);
		do{
			if(tabla[i].clave==0){
				tabla[i]=k;
				return true;
			}else
				i++;
		}while(i<tabla.length);
		return false;
	}
	public int buscarClaveEncade(Key[] tabla,int dat){
		int i=hash(dat,tabla.length);
		Key k=tabla[i],aux;
		if(tabla[i].clave==0){
			return -1;
		}else{
			while(k.cadena!=null){
				if(k.clave==dat){
					return k.clave;
				}else{
					k=k.cadena;
				}
			}
		}
		return -1;
	}
	public int buscarClave(Key[] tabla,int dat){
		int i=hash(dat,tabla.length);
		Key k=tabla[i],aux;
		while(i<tabla.length){
			if(tabla[i].clave==dat){
				return i;
			}else{
				i++;
			}
		}
		return -1;
	}
	public void eliminarClave(Key[] tabla,int dat){
		int i=hash(dat,tabla.length);
		Key k=tabla[i],aux;
		if(buscarClave(tabla, dat)==-1){
			JOptionPane.showMessageDialog(null, "¡Elemento no encontrado!");
		}else{
			tabla[i]=recorrido(tabla[i],dat);
			JOptionPane.showMessageDialog(null, "¡Elemento ELIMINADO con exito!");
		}
	}
	public Key recorrido(Key k,int dat){
		if(k.clave==dat)
			return k.cadena;
		else
			return k = recorrido(k.cadena,dat);		
	}
	public void showcad(Key[] tabla, int dat){
		String cad="";
		int i=hash(dat,tabla.length);
		Key k=tabla[i];
		while(k.cadena!=null){
			k=k.cadena;
			cad+=tabla[i].clave + " ";
		}
		System.out.println(cad);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		Hashing app=new Hashing();
	}

}
