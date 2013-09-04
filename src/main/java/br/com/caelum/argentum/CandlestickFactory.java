package br.com.caelum.argentum;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class CandlestickFactory {

	public Candlestick constroiCandleParaData(Calendar data,
			List<Negociacao> negociacoes) {

		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0)
				.getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(
				negociacoes.size() - 1).getPreco();

		double minimo = negociacoes.isEmpty() ? 0 : Double.MAX_VALUE;
		double maximo = negociacoes.isEmpty() ? 0 : Double.MIN_VALUE;
		double volume = 0;

		for (Negociacao n : negociacoes) {
			volume += n.getVolume();
			if (n.getPreco() > maximo)
				maximo = n.getPreco();
			if (n.getPreco() < minimo)
				minimo = n.getPreco();
		}

		return new CandleBuilder().comAbertura(abertura)
				.comFechamento(fechamento).comMaximo(maximo).comMinimo(minimo)
				.comVolume(volume).comData(data).geraCandle();

	}

	public List<Candlestick> constroiCandles(List<Negociacao> negociacoes) {
		
		Collections.sort(negociacoes);
		
		Calendar dataAtual = negociacoes.get(0).getData();
		
		for(Negociacao negociacao : negociacoes) {
			if(dataAtual.after(negociacao.getData()))
				throw new IllegalStateException();
					
		}

		List<Candlestick> candles = new ArrayList<Candlestick>();
		List<Negociacao> negociacoesDoDia = new ArrayList<Negociacao>();
		dataAtual = negociacoes.get(0).getData();

		for (Negociacao negociacao : negociacoes) {
			if (!negociacao.isMesmoDia(dataAtual)) {
				
				Candlestick candleDoDia = constroiCandleParaData(dataAtual, negociacoesDoDia);
				candles.add(candleDoDia);
				negociacoesDoDia = new ArrayList<Negociacao>();
				dataAtual = negociacao.getData();
			}
			negociacoesDoDia.add(negociacao);
		}
		Candlestick candleDoDia = constroiCandleParaData(dataAtual, negociacoesDoDia);
		candles.add(candleDoDia);

		return candles;

	}
}
