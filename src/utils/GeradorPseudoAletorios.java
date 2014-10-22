package utils;

public class GeradorPseudoAletorios {
	//Gerador de Pseudo Aleatório por Congruência Linear
	public int geraValor(int min, int max,int tempoAtual){
		return min*tempoAtual % max;
	}
	
}
