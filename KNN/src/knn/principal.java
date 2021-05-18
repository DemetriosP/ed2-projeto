package knn;

import java.util.LinkedList;
import java.util.Scanner;

public class principal {
	
	public static boolean eConvetivelFloat(String[] vetor) {
		
		int volta = 0;
		
		while(volta < vetor.length) {
			try {
				float f = Float.parseFloat(vetor[volta]);  
			}catch (NumberFormatException e) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner leitura = new Scanner(System.in);
		
		String[] vetorPalavras = new String[3];
		
		LinkedList<String[]> dataset = new LinkedList<String[]>();
		
		Arquivo arquivo = new Arquivo();
		
		arquivo.lerArquivo(dataset);
		
		do {
			
			System.out.println("Informe uma altura: ");
			vetorPalavras[0] = leitura.nextLine();
			
			System.out.println("Informe uma peso: ");
			vetorPalavras[1] = leitura.nextLine();
			
			System.out.println("Informe uma idade: ");
			vetorPalavras[2] = leitura.nextLine();
			
			leitura.close();
			
			if(!eConvetivelFloat(vetorPalavras)) {
				System.out.println("Algum dos valores não pode ser convertido "
						+ "em float, ,entre novamente com os dados");
			}
			
		}while(!eConvetivelFloat(vetorPalavras));
		
		KNN knn = new KNN();
		
		String vetor1[] = {"1", "2", "3"};
		String vetor2[] = {"1", "3", "1"};
		
		System.out.println(knn.distanciaEuclidiana(vetor1, vetor2));
		
	}

}
