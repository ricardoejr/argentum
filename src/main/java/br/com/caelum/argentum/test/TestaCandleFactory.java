package br.com.caelum.argentum.test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.Candle;
import br.com.caelum.argentum.CandleFactory;
import br.com.caelum.argentum.Negociacao;

public class TestaCandleFactory {


	public static void main(String[] args) {
		Calendar hoje = Calendar.getInstance();
		
		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
		Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);
		
		CandleFactory fabrica = new CandleFactory();
		Candle candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		
		System.out.println(candle);
		

	}

}
