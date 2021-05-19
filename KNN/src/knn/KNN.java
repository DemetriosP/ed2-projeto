package knn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class KNN {
	
	private static double distanciaEuclidiana(String[] entAr, String[] entTec) {
		
		double distancia, entArf[] = new double[3], entTecf[] = new double[3]; 
		
		for(int posicao = 0; posicao < 3; posicao++) {
			entArf[posicao] = Float.parseFloat(entAr[posicao]);
			entTecf[posicao] = Float.parseFloat(entTec[posicao]);
		}
		
		double a = entArf[0] - entTecf[0];
		double b = entArf[1] - entTecf[1];
		double c = entArf[2] - entTecf[2];
		
		distancia = Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2);
		
		return distancia;
		
	}
	
	public static String classify(LinkedList<String[]> lista, int quantVizinhos, String[] entrada) {
		
		Map<Integer, Double> distanciaAlvo = new HashMap<Integer, Double>();
		Map<String, Integer> mapaClasses = new HashMap<String, Integer>();
		ArrayList<String> listaClasses = new ArrayList<String>();
		
		String resultado = null;
		
		int posicao;
		
		if(quantVizinhos < 0) quantVizinhos = 1;
		if(quantVizinhos > lista.size()) quantVizinhos = lista.size();
		if(lista.size() == 0) return null;
		
		for(posicao = 0; posicao < lista.size(); posicao++) {
			distanciaAlvo.put(posicao, distanciaEuclidiana(lista.get(posicao), entrada));
		}
		
		Map<Integer, Double> distanciaAlvoOrdenada = distanciaAlvo.entrySet().stream().sorted((e1,e2)->
        e1.getValue().compareTo(e2.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::
        	getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		for(Map.Entry<Integer , Double> mapa : distanciaAlvoOrdenada.entrySet()) {
			listaClasses.add(lista.get(mapa.getKey())[3]);
		}
		
		for(posicao = 0; posicao < quantVizinhos; posicao++) {
			
			if(mapaClasses.containsKey(listaClasses.get(posicao))) {
				mapaClasses.put(listaClasses.get(posicao), mapaClasses.get(listaClasses.get(posicao)) + 1);
			}else {
				mapaClasses.put(listaClasses.get(posicao), 1);
			}
		}
		
		Map<String, Integer> mapaClassesOrdenado = mapaClasses.entrySet().stream().sorted((e1,e2)->
        e2.getValue().compareTo(e1.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::
        	getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		for(Map.Entry<String , Integer> mapa : mapaClassesOrdenado.entrySet()) {
			resultado = mapa.getKey();
			break;
		}
		
		return resultado;
	}
	
	public static boolean eConvetivelFloat(String[] vetor) {
		
		for(int volta = 0; volta < vetor.length; volta++) {
			
			try {
				@SuppressWarnings("unused")
				float f = Float.parseFloat(vetor[volta]);  
			}catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

}
