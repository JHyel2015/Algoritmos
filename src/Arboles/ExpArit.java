package Arboles;
import javax.swing.JOptionPane;
public class ExpArit {
	public ExpArit() {
		// TODO Auto-generated constructor stub
		pila oper=new pila(),variables=new pila();
		String expr="",cad="",aux,sprcad="";
		try{
			expr=JOptionPane.showInputDialog(null, "Ingrese una expresion aritmetica: ");
		}catch (Exception error) {
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		int i=0;
		while(i<expr.length()){
			cad+=expr.substring(i,i+1);
			if(expr.substring(i,i+1).matches("[*+-/()]+")){
				oper.push(expr.substring(i,i+1));
				if(!cad.substring(0, cad.length()-1).equals("")){
					if(oper.getSize()!=1){
						sprcad+=variables.getTail().getElemento()+cad.substring(0, cad.length()-1)+oper.getTail().getElemento();
						System.out.println(sprcad);
					}
					variables.push(cad.substring(0, cad.length()-1));
				}
				cad="";
			}
			if(i==expr.length()-1)
				variables.push(cad.substring(0, cad.length()));
			i++;
		}
		System.out.println("Pila de Operadores:\n"+oper.toString1()+"\nPila de variables:\n"+variables.toString1());
	}
	public void postorder(pila op,pila var){
		String cad="";
		Nodo aux=op.getTail(),aux2;
		while(!aux.getPrev().equals(null)){
			if(aux.getElemento().matches("[+-]*")){

			}
			aux=aux.getPrev();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		ExpArit app=new ExpArit();
	}
}
