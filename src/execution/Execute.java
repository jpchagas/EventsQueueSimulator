package execution;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

import utils.Probabilidades;
import workers.Simulador;

public class Execute {
	
	public static Long[] start(int k,int minCh,int maxCh,int minAt,int maxAt,int tFinal){
		Simulador s = new Simulador();
		Long result[] = s.simular(minCh, maxCh, minAt, maxAt, k, tFinal);
		return result;
		
	}

	public static void main(String[] args) {
		Probabilidades p = new Probabilidades();
		System.out.println("Insira alguns dados necessários para iniciar o simulador.");
		System.out.println("Capacidade Máxima de Clientes:");
		Scanner entrada = new Scanner (System.in);
		String k = entrada.nextLine();
		System.out.println("Tempo Minimo de Chegada:");
		entrada = new Scanner (System.in);
		String minCh = entrada.nextLine();
		System.out.println("Tempo Máximo de Chegada:");
		entrada = new Scanner (System.in);
		String maxCh = entrada.nextLine();
		System.out.println("Tempo Minimo de Atendimento:");
		entrada = new Scanner (System.in);
		String minAt = entrada.nextLine();
		System.out.println("Tempo Máximo de Atendimento:");
		entrada = new Scanner (System.in);
		String maxAt = entrada.nextLine();
		System.out.println("Tempo Máximo de Execução:");
		entrada = new Scanner (System.in);
		String tFinal = entrada.nextLine();
		
		Long result[] = start(Integer.parseInt(k),Integer.parseInt(minCh),Integer.parseInt(maxCh), Integer.parseInt(minAt), Integer.parseInt(maxAt), Integer.parseInt(tFinal));
		result = p.converter(result);
		
		for(int i = 0;i<result.length;i++){
			System.out.println("Probabilidade com" + i + ":" + result[i]);
		}
		
	}

}
