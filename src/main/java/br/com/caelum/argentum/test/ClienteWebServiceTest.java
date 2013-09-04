package br.com.caelum.argentum.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.argentum.Negociacao;
import br.com.caelum.argentum.ws.ClienteWebService;

public class ClienteWebServiceTest {

	@Test
	public void deveRetornar248TransacoesWebService() {
		ClienteWebService cliente = new ClienteWebService();
		
		List<Negociacao> negociacoes = cliente.getNegociacoes();
		
		Assert.assertEquals(248, negociacoes.size());
	}

}
