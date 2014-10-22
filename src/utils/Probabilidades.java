package utils;

public class Probabilidades {
	
	public Long[] converter(Long[] fila){
		Long converterd[] = new Long[fila.length];
		for(int i = 0;i<fila.length;i++){
			converterd[i] = fila[i]*100;
			
		}
		return converterd;
	}
	
}
