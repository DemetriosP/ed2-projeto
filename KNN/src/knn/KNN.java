package knn;

public class KNN {
	
	public double distanciaEuclidiana(String[] entAr, String[] entTec) {
		
		double distancia, entArf[] = new double[3], entTecf[] = new double[3]; 
		
		for(int posicao = 0; posicao < entAr.length; posicao++) {
			entArf[posicao] = Float.parseFloat(entAr[posicao]);
			entTecf[posicao] = Float.parseFloat(entTec[posicao]);
		}
		
		double a = entArf[0] - entTecf[0];
		double b = entArf[1] - entTecf[1];
		double c = entArf[2] - entTecf[2];
		
		distancia = Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2);
		
		return distancia;
		
	}

}
