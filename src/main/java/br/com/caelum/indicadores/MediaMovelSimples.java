package br.com.caelum.indicadores;

import br.com.caelum.argentum.SerieTemporal;

public class MediaMovelSimples implements Indicador {

	private final int intervalo;
	private final Indicador indicador;


	public MediaMovelSimples(Indicador indicador, int intervalo) {
		this.intervalo = intervalo;
		this.indicador = indicador;
	}
	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		if(serie==null)
			throw new IllegalArgumentException("A serie deve ser informada");
		
		double soma = 0.0;
		for (int i = posicao - (intervalo -1);i <=posicao; i++){
			soma += indicador.calcula(i, serie);
		}
		return soma / intervalo;
	}
	
	
	@Override
	public String toString(){
		return "MMS de " + indicador.toString();
	}

}
