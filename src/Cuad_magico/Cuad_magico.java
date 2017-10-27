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
		int[][] mat=cuad_mag(n),mat_rec=cuad_mag_rec(n);
		impri(mat);
		//System.out.println("\nRecursivo");
		//impri(mat_rec);
	}
	public int[][] cuad_mag(int n){
        int cont=1,f=0,c=n/2,f0,c0;
        if(n%2==0)
            n++;
        n++;
        int[][] mat= new int[n][n];
        mat[f][c]=cont;
        while(cont<((n*n)-(n*2)+1)){
            f0=f;
            c0=c;
            f--;
            c++;
            if(f<0)
                f=n-2;
            if(c>=n-1)
                c=0;
            if(mat[f][c]>0){
                f=f0+1;c=c0;
            }
            cont++;
            mat[f][c]=cont;
        }
        sum_foc(mat);
        return mat;
	}
	public void sum_foc(int[][] mat){
		for(int i=0;i<mat.length-1;i++){
			for(int j=0;j<mat.length-1;j++){
				mat[i][mat.length-1]+=mat[i][j];
				mat[mat.length-1][j]+=mat[j][i];
				if(i==j){
					mat[mat.length-1][mat.length-1]+=mat[i][j];
				}
			}
		}
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
		if(cont<=(mat.length*mat.length)){
            if(f<0)
                f=mat.length-1;
            if(c>=mat.length)
                c=0;
            if(mat[f][c]>0){
                cuad_mag(mat, cont, f0+2, c0-1);
            }else{
        		mat[f][c]=cont;
                cuad_mag(mat, cont+1, f-1, c+1);
            }
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
