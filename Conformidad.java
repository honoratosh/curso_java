//Condormidad UVA 11286

import java.util.*;

class Main{
	
	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);

		/*
			n: número de estudiantes en el caso de prueba actual
			totest: número de estudiantes inscritos en el curso más popular
			max: curso más popular
			cursos: arreglo con cursos tomados por el estudiante actual
			freq: mapa con la frecuencia de cada curso
		*/


		int n, totest, max;
		long enc;
		int cursos[] = new int[5];
		Map<Long, Integer> freq;

		while(true){
			
			n = sc.nextInt();
			
			if(n==0) break;
			
			freq = new TreeMap<>();

			for(int  i = 0; i < n ; i++){
				for(int j = 0; j< 5; j++){
					cursos[j] = sc.nextInt();
				}

				enc = encode(cursos);

				if(freq.get(enc)==null){
					freq.put(enc, 1);
				}
				else{
					freq.put(enc, freq.get(enc) + 1);
				}

			}

			max = 0;
			totest = 0;

			for(Map.Entry<Long, Integer> entry : freq.entrySet()){
				if(entry.getValue() > max){
					max = entry.getValue();
					totest = max;
				}
				else if(entry.getValue() == max){
					totest = totest + max;
				}
			}

			System.out.println(totest);
			
		}
	}

	static long encode(int cursos[]){
		Arrays.sort(cursos);
		long encoding = 0;

		for(int i = 0; i < 5; i++){
			encoding += cursos[i] * Math.pow(500,i);
		}
		return encoding;
	}

}
