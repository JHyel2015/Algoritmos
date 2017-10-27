package Busqueda_binaria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Busqueda_binaria{
	public Busqueda_binaria() throws NumberFormatException, IOException{
		int n,x;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		System.out.println("Ingrese el tamaño del Arreglo: ");
		n = Integer.parseInt (br.readLine());
		int arr[]=new int[n];
		System.out.println("*El arreglo se llenara aleatoriamente*");
		llenarArr(arr);
		imprimir(arr);

		System.out.println("Arreglo ORDENADO");
		ordenarArr(arr);
		imprimir(arr);

		System.out.println("Ingrese el valor a Buscar (entre 0 y 99): ");
		n = Integer.parseInt (br.readLine());
		x=buscar(arr, n);
		System.out.print("El valor "+n);
		if(x!=-1)
			System.out.println(" esta en la posicion: "+x);
		else
			System.out.println(" no ha sido encontrado");
	}	
	public void llenarArr(int[] arr){
		for(int i=0;i<arr.length;i++){
			arr[i]= (int) Math.floor(Math.random()*99);
		}
	}
	public void ordenarArr(int[] arr){
		int aux;
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					aux=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=aux;
				}
			}
		}
	}
	public int buscar(int[] arr, int x){
		int fin=arr.length-1,i=0,mid=fin/2;
		while(arr[mid]!=x&&fin>i){
			if(arr[mid]<x)
				i=mid+1;
			else
				fin=mid-1;
			mid=(i+fin)/2;
		}
		if(arr[mid]==x)
			return mid;
		return -1;
	}
	public void imprimir(int[] arr){
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		Busqueda_binaria app= new Busqueda_binaria();

	}	
}