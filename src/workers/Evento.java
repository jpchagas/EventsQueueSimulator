package workers;

public class Evento {
	int tempo;
	Acao acao;
	
	public Evento(int tempo, Acao acao) {
		super();
		this.tempo = tempo;
		this.acao = acao;
	}

	public int getTempo() {
		return tempo;
	}

	public Acao getAcao() {
		return acao;
	}
	
}
