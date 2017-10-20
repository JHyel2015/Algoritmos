package Palindromo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindromo{
	public Palindromo() throws IOException{
		String strText;
		System.out.println("\tPALINDROME\nEscriba una palabra o frase");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		strText = br.readLine();
		System.out.println("La palabra o frase ingresada es: "+strText);
		System.out.print("La palabra: "+strText);
		if(f_palindromo(strText)==false){
			System.out.print(" NO");
		}
		System.out.println(" es palindromo");
	}
	public Boolean f_palindromo(String str){
		String straux="";
		str=str.replace(" ","");
		str=str.replace("á","a");
		str=str.replace("é","e");
		str=str.replace("í","i");
		str=str.replace("ó","o");
		str=str.replace("ú","u");
		for(int i=str.length();i>0;i--){
			straux=straux+str.substring(i-1, i);
		}
		return str.equalsIgnoreCase(straux);
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		Palindromo app= new Palindromo();

	}
}