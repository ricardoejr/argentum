package br.com.caelum.indicadores;

import br.com.caelum.argentum.SerieTemporal;

public class MediaMovelPonderada implements Indicador {
	
	private final int intervalo;
	private final Indicador indicador;

	public MediaMovelPonderada(Indicador indicador, int intervalo) {
		this.intervalo = intervalo;
		this.indicador = indicador;
	}

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		if(serie==null)
			throw new IllegalArgumentException("A serie deve ser informada");
		
		double soma = 0.0;
		int peso = 0;
		int somaPeso = 0;
		for (int i = posicao - (intervalo -1); i <= posicao; i++) {
			peso++;
			somaPeso += peso;
			soma += indicador.calcula(i, serie) * peso;
			
		}

		return soma / somaPeso;
	}
	
	@Override
	public String toString(){
		return "MMP de " + indicador.toString();
	}
}
