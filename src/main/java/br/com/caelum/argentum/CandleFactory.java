package br.com.caelum.argentum;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class CandleFactory {

	public Candle constroiCandleParaData(Calendar data,
			List<Negociacao> negociacoes) {

		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0)
				.getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(
				negociacoes.size() - 1).getPreco();

		double minimo = negociacoes.isEmpty() ? 0 : Double.MAX_VALUE;
		double maximo = negociacoes.isEmpty() ? 0 : Double.MIN_VALUE;
		double volume = 0;

		for (Negociacao n : negociacoes) {
			double preco = n.getPreco();
			volume += n.getVolume();
			if (preco > maximo)
				maximo = preco;
			if (preco < minimo)
				minimo = preco;
		}

		return new CandleBuilder().comAbertura(abertura)
				.comFechamento(fechamento).comMaximo(maximo).comMinimo(minimo)
				.comVolume(volume).comData(data).geraCandle();

	}

	public List<Candle> constroiCandles(List<Negociacao> negociacoes) {
		
		Collections.sort(negociacoes);
		
		Calendar dataAtual = negociacoes.get(0).getData();
		
		for(Negociacao negociacao : negociacoes) {
			if(dataAtual.after(negociacao.getData()))
				throw new IllegalStateException();
					
		}

		List<Candle> candles = new ArrayList<Candle>();
		List<Negociacao> negociacoesDoDia = new ArrayList<Negociacao>();
		dataAtual = negociacoes.get(0).getData();

		for (Negociacao negociacao : negociacoes) {
			if (!negociacao.isMesmoDia(dataAtual)) {
				
				criaEGuardaCandle(dataAtual, candles, negociacoesDoDia);
				negociacoesDoDia = new ArrayList<Negociacao>();
				dataAtual = negociacao.getData();
			}
			negociacoesDoDia.add(negociacao);
		}
		criaEGuardaCandle(dataAtual, candles, negociacoesDoDia);

		return candles;

	}

	private void criaEGuardaCandle(Calendar dataAtual,
			List<Candle> candles, List<Negociacao> negociacoesDoDia) {
		Candle candleDoDia = constroiCandleParaData(dataAtual, negociacoesDoDia);
		candles.add(candleDoDia);
	}
}
