package utils;

public class GeradorPseudoAletorios {
	//Gerador de Pseudo Aleat�rio por Congru�ncia Linear
	public int geraValor(int min, int max,int tempoAtual){
		return min*tempoAtual % max;
	}
	
}
