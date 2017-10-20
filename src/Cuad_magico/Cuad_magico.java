package Cuad_magico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Cuad_magico {

	public Cuad_magico() throws NumberFormatException, IOException{
		// TODO Auto-generated constructor stub
		int n;
		System.out.println("\t\tCUADRADO MAGICO\nEscriba el numero de filas (IMPAR)");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		n = Integer.parseInt (br.readLine());
		int[][] mat=cuad_mag(n)/*,mat_rec=cuad_mag_rec(n)*/;
		impri(mat);
		//System.out.println("\n");
		//impri(mat_rec);
	}
	public int[][] cuad_mag(int n){
        int cont=1,f=0,c=n/2,f0,c0;
        if(n%2==0)
            n++;
        int[][] mat= new int[n][n];
        mat[f][c]=cont;
        while(cont<=(n*n)-1){
            f0=f;
            c0=c;
            f--;
            c++;
            if(f<0)
                f=n-1;
            if(c>=n)
                c=0;
            if(mat[f][c]>0){
                f=f0+1;c=c0;
            }
            cont++;
            mat[f][c]=cont;
        }
        return mat;
	}
	public int[][] cuad_mag_rec(int n){
        int cont=1,f=0,c=n/2;
        if(n%2==0)
            n++;
        int[][] mat= new int[n][n];
        cuad_mag(mat, cont, f, c);
        return mat;
	}
	public void cuad_mag(int[][] mat,int cont,int f,int c){
		int f0=f,c0=c;
		mat[f][c]=cont;
		if(cont<(mat.length*mat.length)){
			f--;c++;
            if(f<0)
                f=mat.length-1;
            if(c>=mat.length)
                c=0;
            if(mat[f][c]>0){
            	f=f0+1;
            	c=c0;
            }
            cuad_mag(mat, cont+1, f, c);
		}
	}
	public void impri(int[][] mat){
        for(int i=0;i<mat.length;i++){
        	/*for(int j=0;j<mat[i].length;j++){
            	System.out.print("|");
        		if(mat[i][j]<1000)
                	System.out.print(" ");
        		if(mat[i][j]<100)
                	System.out.print(" ");
        		if(mat[i][j]<10)
                	System.out.print(" ");
        		System.out.print(mat[i][j]);
        	}
        	System.out.println("|");*/
        	System.out.println(Arrays.toString(mat[i]));
        }
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		Cuad_magico app= new Cuad_magico();

	}

}
