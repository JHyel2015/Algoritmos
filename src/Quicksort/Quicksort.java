package Quicksort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Quicksort {
	public Quicksort() throws NumberFormatException, IOException{
		// TODO Auto-generated constructor stub
		int n;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		System.out.println("Ingrese el tamaño del Arreglo: ");
		n = Integer.parseInt (br.readLine());
		int arr[]=new int[n],arr0[]=new int[n];//Se crea dos arrays de mismo tamaño
		System.out.println("*El arreglo se llenara aleatoriamente*");
		llenarArr(arr);//El arreglo se llenara aleatoriamente
		System.out.println("1");
		imprimir(arr);
		llenarArr(arr0);//El arreglo se llenara aleatoriamente
		System.out.println("\n2");
		imprimir(arr0);

		System.out.println("Arreglo ORDENADO");
		quick_n2(arr, 0, arr.length-1);//el pivote en el inicio
		System.out.println("1(pivote al inicio)");
		imprimir(arr);
		quick_nlogn(arr0, 0, arr0.length-1);//el pivote en la mitad
		System.out.println("\n2(pivote en la mitad)");
		imprimir(arr0);
	}
	public void quick_n2(int[] arr,int ini,int fi){
		int i = ini, j=fi, piv=arr[ini],aux=0;
		while(i<j && arr[i]!=arr[j]){
			while(arr[i]<=piv && i<j)
				i++;
			while(arr[j]>piv)
				j--;
			if(i<j){
				aux=arr[i];
				arr[i]=arr[j];
				arr[j]=aux;
			}
		}
		arr[ini]=arr[j];
		arr[j]=piv;
		if(ini<j-1)
			quick_n2(arr, ini, j-1);
		if(j+1<fi)
			quick_n2(arr, j+1, fi);
	}
	public void quick_nlogn(int[] arr,int ini,int fi){
		int i = ini, j=fi, piv=arr[(ini+fi)/2],aux=0;
		do{
			while((arr[i]<piv)&&(j<=fi))
				i++;
			while((piv<arr[j])&&(j>ini))
				j--;
			if(i<=j){
				aux=arr[i];
				arr[i]=arr[j];
				arr[j]=aux;
				i++;j--;
			}
		}while(i<=j);
		if(ini<j)
			quick_nlogn(arr, ini, j);
		if(i<fi)
			quick_nlogn(arr, i, fi);		
	}
	public void llenarArr(int[] arr){
		for(int i=0;i<arr.length;i++){
			arr[i]= (int) Math.floor(Math.random()*99);
		}
	}
	public void imprimir(int[] arr){
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		Quicksort app= new Quicksort();
	}

}
