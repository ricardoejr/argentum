package br.com.caelum.argentum.test;

import org.junit.Assert;
import org.junit.Test;

import bb.com.caelum.argentum.indicadores.Indicador;
import bb.com.caelum.argentum.indicadores.IndicadorAbertura;
import bb.com.caelum.argentum.indicadores.IndicadorFactory;
import bb.com.caelum.argentum.indicadores.MediaMovelSimples;

public class IndicadorFactoryTest {

	@Test
	public void testMontaAbertura() {
		String nomeIndicador = "IndicadorAbertura";

		Indicador indicador = new IndicadorFactory(nomeIndicador, null)
				.getIndicador();

		Assert.assertTrue(indicador instanceof IndicadorAbertura);
	}

	@Test
	public void testMontaAberturaComMediaMovelSimplesw() {
		String nomeIndicador = "IndicadorAbertura";

		String nomeMedia = "MediaMovelSimples";

		Indicador indicador = new IndicadorFactory(nomeIndicador, nomeMedia)
				.getIndicador();

		Assert.assertTrue(indicador instanceof MediaMovelSimples);
	}

}
