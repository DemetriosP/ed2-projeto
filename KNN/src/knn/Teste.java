package knn;

import java.util.LinkedList;
import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		
		Scanner leitura = new Scanner(System.in);
		
		String[] vetorPalavras = new String[3];
		
		LinkedList<String[]> dataset = new LinkedList<String[]>();
		
		Arquivo.lerArquivo(dataset);
		
		do {
			
			System.out.println("Informe uma altura: ");
			vetorPalavras[0] = leitura.nextLine();
			
			System.out.println("Informe uma peso: ");
			vetorPalavras[1] = leitura.nextLine();
			
			System.out.println("Informe uma idade: ");
			vetorPalavras[2] = leitura.nextLine();
			
			if(!KNN.eConvetivelFloat(vetorPalavras)) {
				System.out.println("Algum dos valores não pode ser convertido "
						+ "em float, ,entre novamente com os dados");
			}
			
			leitura.close();
			
		}while(!KNN.eConvetivelFloat(vetorPalavras));

		System.out.println("A classe sugerida para cadastro: " + KNN.classify(dataset, 3, vetorPalavras));
	}

}
