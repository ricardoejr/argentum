package br.com.caelum.argentum.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.argentum.Negociacao;
import br.com.caelum.argentum.reader.LeitorXML;

public class LeitorXMLTest {

	@Test
	public void carregaXmlComUmaNegociacaoEmListaUnitaria() {
		String xmlDeTeste = "<list><negociacao><preco>43.5</preco><quantidade>1000</quantidade>"
				+ "<data><time>1322233344455</time></data></negociacao></list>";

		LeitorXML leitor = new LeitorXML();

		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());

		List<Negociacao> negociacoes = leitor.carrega(xml);

		Assert.assertEquals(1, negociacoes.size());
		Assert.assertEquals(43.5, negociacoes.get(0).getPreco());
		Assert.assertEquals(1000, negociacoes.get(0).getQuantidade());
	}

	@Test
	public void carregaXmlComNegociacaoPrecoZeroEmListaUnitaria() {
		String xmlDeTeste = "<list><negociacao><quantidade>1000</quantidade>"
				+ "<data><time>1322233344455</time></data></negociacao></list>";

		LeitorXML leitor = new LeitorXML();

		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());

		List<Negociacao> negociacoes = leitor.carrega(xml);

		Assert.assertEquals(1, negociacoes.size());
		Assert.assertEquals(0.0, negociacoes.get(0).getPreco(),0.00001);
	}

	@Test
	public void carregaXmlComNenhumaNegociacaoEmListaUnitaria() {
		String xmlDeTeste = "<list></list>";

		LeitorXML leitor = new LeitorXML();

		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());

		List<Negociacao> negociacoes = leitor.carrega(xml);

		Assert.assertEquals(0, negociacoes.size());
	}
	@Test
	public void carregaXmlComTresNegociacaoEmListaUnitaria() {
		String xmlDeTeste = "<list><negociacao><preco>43.5</preco><quantidade>1000</quantidade>"
				+ "<data><time>1322233344455</time></data></negociacao>" 
				+ "<negociacao><preco>43.5</preco><quantidade>1000</quantidade>"
				+ "<data><time>1322233344455</time></data></negociacao>" 
				+ "<negociacao><preco>43.5</preco><quantidade>1000</quantidade>"
				+ "<data><time>1322233344455</time></data></negociacao></list>";

		LeitorXML leitor = new LeitorXML();

		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());

		List<Negociacao> negociacoes = leitor.carrega(xml);

		Assert.assertEquals(3, negociacoes.size());
	}

}
