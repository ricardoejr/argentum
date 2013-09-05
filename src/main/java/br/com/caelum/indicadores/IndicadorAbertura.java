package br.com.caelum.indicadores;

import br.com.caelum.argentum.SerieTemporal;

public class IndicadorAbertura implements Indicador {

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		return serie.getCandle(posicao).getAbertura();
	}
	
	@Override
	public String toString(){
		return "Abertura";
	}
}
