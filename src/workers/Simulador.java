package workers;

import java.util.ArrayList;

import utils.GeradorPseudoAletorios;


public class Simulador {
	private Long fila [];
	private ArrayList<Evento> eventosFuturos =  new ArrayList<Evento>();
	int tempo = 0;
	int quantidadeNaFila = 0;
	
	public Evento agendaChegada(int min, int max, int tempo){
		//Agenda Chegada
		GeradorPseudoAletorios gpa =  new GeradorPseudoAletorios();
		Evento ev =  new Evento(tempo+gpa.geraValor(min, max, tempo),Acao.CH);
		return ev;
	}
	
	public Evento agendaSaida(int min, int max, int tempo){
		//Agenda Saída
		GeradorPseudoAletorios gpa =  new GeradorPseudoAletorios();
		Evento ev =  new Evento(tempo+gpa.geraValor(min, max, tempo),Acao.SA);
		return ev;
	}
	
	public void processaChegada(int min,int max,int k){
		quantidadeNaFila = k;
		Evento aux = new Evento(Integer.MIN_VALUE,null);
		if(fila.length<k){
			aux = agendaChegada(min, max, tempo);
			eventosFuturos.add(aux);
			//fila++
		}
		if(fila.length<=k-1){
			if(tempo!=0){
			fila[quantidadeNaFila] = fila[quantidadeNaFila]+(tempo-aux.getTempo());
			}else fila[quantidadeNaFila] = fila[quantidadeNaFila]+(aux.getTempo());
			tempo=aux.getTempo();			
			quantidadeNaFila++;
			agendaSaida(min, max, tempo);			
		}
		agendaChegada(min, max, tempo);
	}
	
	public void processaSaida(int min,int max,int k){
		quantidadeNaFila = k;
		Evento aux = new Evento(Integer.MIN_VALUE,null);
		if(tempo!=0){
		fila[quantidadeNaFila] = fila[quantidadeNaFila]+(tempo-aux.getTempo());
		}else fila[quantidadeNaFila] = fila[quantidadeNaFila]+(aux.getTempo());
		tempo=aux.getTempo();			
		quantidadeNaFila--;
		if(fila.length>=k-1){
			agendaSaida(min, max, tempo);
		}
	}
	
	public Long[] simular(int minCh,int maxCh ,int minAt, int maxAt, int k,int tFinal){
		fila =  new Long[k];
		while(tempo>tFinal){
			Evento aux = new Evento(Integer.MIN_VALUE,null);
			aux = eventoMenorTempo();
			if(eventosFuturos.isEmpty())agendaChegada(minCh, maxCh, tempo);
			else if(aux.getAcao().equals(Acao.CH))agendaChegada(minCh, maxCh, tempo);
			else if(aux.getAcao().equals(Acao.SA))agendaSaida(minAt, maxAt, tempo);
		}
		return fila;
	}
	
	public Evento eventoMenorTempo(){
		Evento aux = new Evento(Integer.MIN_VALUE,null);
		Evento menor = new Evento(Integer.MIN_VALUE,null);
		int i;
		for( i = 0;i<eventosFuturos.size();i++){
			aux = eventosFuturos.get(i);
			if(menor.getTempo()>aux.getTempo())menor=aux;
		}
		eventosFuturos.remove(i);
		return aux;
	}
	
	
}
