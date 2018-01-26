//Prog. Dinamica subsecuencia comun más larga 10405

import java.util.*;  //scanner y colecciones

class Main{

	static int[][] sol;

	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);
		
		/*
			Implementación utilizando programación dinámica
			y complejidad O(m*n)
			str1, str2: cadenas a comparar
		*/

		String str1, str2;
		int l,m;

		while(sc.hasNextLine()){

			str1 = sc.nextLine();
			str2 = sc.nextLine();

			l = str1.length();
			m = str2.length();

			sol = new int[l+1][m+1];

			for(int [] reng : sol){
				Arrays.fill(reng, -1);
			}

			System.out.println(lcs(str1, str2, l, m));

		}

	}

	static int lcs(String str1, String str2, int l, int m){
		if(l == 0 || m == 0){
			sol[l][m] = 0;
		}

		if(sol[l][m]==-1){
			if(str1.charAt(l-1) == str2.charAt(m-1)){
				sol[l][m] = lcs(str1,str2,l-1,m-1) + 1;		
			}
			else{
				sol[l][m] = Math.max(
						lcs(str1, str2, l-1, m),
						lcs(str1, str2, l, m-1));
			}
		}

		return sol[l][m];
	}
}
