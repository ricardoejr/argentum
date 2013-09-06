package br.com.caelum.argentum.test;

import junit.framework.Assert;

import org.junit.Test;

import bb.com.caelum.argentum.indicadores.IndicadorFechamento;
import bb.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.SerieTemporal;

public class MediaMovelSimplesTest {

	@Test
	public void sequenciaSimpleDeCandlesMediaSimples() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 3, 4, 5, 4,
				3);
		MediaMovelSimples mms = new MediaMovelSimples(new IndicadorFechamento());

		Assert.assertEquals(2.0, mms.calcula(2, serie), 0.00001);
		Assert.assertEquals(3.0, mms.calcula(3, serie), 0.00001);
		Assert.assertEquals(10.0 / 3, mms.calcula(4, serie), 0.00001);
		Assert.assertEquals(11.0 / 3, mms.calcula(5, serie), 0.00001);
		Assert.assertEquals(4.0, mms.calcula(6, serie), 0.00001);
		Assert.assertEquals(13.0 / 3, mms.calcula(7, serie), 0.00001);
		Assert.assertEquals(4.0, mms.calcula(8, serie), 0.00001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveDarErroSerieNula() {
		SerieTemporal serie = null;
		MediaMovelSimples mms = new MediaMovelSimples(new IndicadorFechamento());
		mms.calcula(2, serie);
	}

}
