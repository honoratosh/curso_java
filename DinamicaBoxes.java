//Prog. Dinamica Boxes 11003

import java.util.*;  //scanner y colecciones

class Main{

	static int n,max_c;
	static int[] peso, carga;
	static int[][] optimo;

	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);
		
		/*
			Guardaremos carga restante en la pila de cajas
			vs
			posición en el arreglo de cajas (cuantas nos faltan)

			n: número de cajas
			peso[] carga[]: arreglos con el caso de prueba actual
			optimo[][] : matriz con las soluciones
		*/

		while((n = sc.nextInt()) != 0){

			max_c = 0;

			peso = new int[n];
			carga = new int[n];

			for(int i = 0; i < n; i++){
				peso[i] = sc.nextInt();
				carga[i] = sc.nextInt();
				if(carga[i] > max_c) max_c = carga[i];
			}

			optimo = new int[max_c+2][n+1];

			for(int i=0; i < max_c + 2; i++){
				Arrays.fill(optimo[i], -1);
			}

			System.out.println(stackmax(max_c + 1, 0));
		}
	}

	/*  carga_res: carga restante en el stack de cajas
	 	posicion: qué caja podemos agregar (o no) actualmente
	 */
	static int stackmax(int carga_res, int posicion){
		if(carga_res == 0 || posicion == n){
			optimo[carga_res][posicion] = 0;
		}

		if(optimo[carga_res][posicion] == -1){
			if(carga_res == max_c + 1){
				optimo[carga_res][posicion] = Math.max(
					stackmax(carga[posicion], posicion + 1)+1,
					stackmax(carga_res, posicion + 1)
				);
			}
			else{
				if(peso[posicion] > carga_res){
					optimo[carga_res][posicion] = stackmax(carga_res, posicion+1);
				}
				else{
					optimo[carga_res][posicion] = Math.max(
						stackmax(Math.min(carga_res-peso[posicion], carga[posicion]),
						posicion+1)+1,
						stackmax(carga_res, posicion+1)
					);
				}
			}
		}
		return optimo[carga_res][posicion];
	}
}
