package br.com.caelum.argentum.test;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.argentum.SerieTemporal;
import br.com.caelum.indicadores.Indicador;
import br.com.caelum.indicadores.IndicadorFechamento;
import br.com.caelum.indicadores.MediaMovelPonderada;

public class MediaMovelPonderadaTest {

	@Test
	public void sequenciaSimpleDeCandlesM() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 5, 6);
		Indicador mmp = new MediaMovelPonderada(new IndicadorFechamento(), 3);

		Assert.assertEquals(14.0 / 6, mmp.calcula(2, serie), 0.00001);
		Assert.assertEquals(20.0 / 6, mmp.calcula(3, serie), 0.00001);
		Assert.assertEquals(26.0 / 6, mmp.calcula(4, serie), 0.00001);
		Assert.assertEquals(32.0 / 6, mmp.calcula(5, serie), 0.00001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveDarErroSerieNula() {
		SerieTemporal serie = null;
		Indicador mmp = new MediaMovelPonderada(new IndicadorFechamento(), 3);
		mmp.calcula(2, serie);
	}

}
