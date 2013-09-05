package br.com.caelum.indicadores;

import br.com.caelum.argentum.SerieTemporal;

public interface Indicador {

	public abstract double calcula(int posicao, SerieTemporal serie);

}