//Subsecuencia comun más larga 10405

import java.util.*;  //scanner y colecciones

class Main{
	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);
		
		/*
			str1, str2: cadenas a comparar
		*/

		String str1, str2;


		while(sc.hasNextLine()){
			str1 = sc.nextLine();
			str2 = sc.nextLine();

			System.out.println(lcs(str1, str2, str1.length(), str2.length()));

		}

	}

	static int lcs(String str1, String str2, int l, int m){
		if(l == 0 || m == 0) return 0;

		else if(str1.charAt(l-1) == str2.charAt(m-1)){
			return(
				lcs(str1,str2,l-1,m-1) + 1
			);
		}
		else{
			return(
				Math.max(
					lcs(str1, str2, l-1, m),
					lcs(str1, str2, l, m-1)
				)
			);
		}
	}
}
