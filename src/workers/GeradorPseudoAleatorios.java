package workers;

import java.util.Random;

public class GeradorPseudoAleatorios {
	
	//Método que efetua congruência linear e cálcula um valor pseudo aleatório
	public double gerarNumero(int max, int min){
		//A+((B-A)*X)
		Random r = new Random();
		return min+((max-min)*r.hashCode());
	}
}
