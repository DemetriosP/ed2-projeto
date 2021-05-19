package knn;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Arquivo {
	
	public static void lerArquivo(LinkedList<String[]> lista) {
		
		Path caminho = Paths.get("C:/Users/panta/ed2-projeto/KNN/dados.txt");
		
		try {
			
			BufferedReader br = Files.newBufferedReader(caminho);
			String linha = br.readLine();
			linha = br.readLine();
			
			while(linha != null) {
				
				String[] palavras = linha.split(",");
				lista.add(palavras);
			
				linha = br.readLine();
			}
			
		}catch(Exception erro) {
			System.out.println(erro.getMessage());
		}
	}

}
