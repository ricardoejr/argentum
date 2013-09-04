package br.com.caelum.argentum;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Candlestick {
	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;

	public Candlestick(double abertura, double fechamento, double minimo,
			double maximo, double volume, Calendar data) {
		if(minimo>maximo)
			throw new IllegalArgumentException("Valor máximo deve ser maior que mínimo");
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = (Calendar) data.clone();
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return (Calendar) data.clone();
	}

	public boolean isAlta() {
		return this.abertura < this.fechamento;
	}

	public boolean isBaixa() {
		return this.abertura > this.fechamento;
	}

	@Override
	public String toString() {
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder saida = new StringBuilder("Abertura: " + this.getAbertura());
		saida.append(" - Fechamento: " + this.getFechamento());
		saida.append(" - Minimo: " + this.getMinimo());
		saida.append(" - Maximo: " + this.getMaximo());
		saida.append(" - Volume: " + this.getVolume());
		saida.append(" - Data: " + sd.format(this.data.getTime()));
		
		
		
		return saida.toString();
	}

}
