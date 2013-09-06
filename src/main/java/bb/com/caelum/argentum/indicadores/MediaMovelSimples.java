package bb.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.SerieTemporal;

public class MediaMovelSimples implements Indicador {

	private int intervalo = 3;
	private final Indicador indicador;


	public MediaMovelSimples(Indicador indicador) {
		this.indicador = indicador;
	}
	

	public int getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}
	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		if(serie==null)
			throw new IllegalArgumentException("A serie deve ser informada");
		
		double soma = 0.0;
		for (int i = posicao - (intervalo -1);i <=posicao; i++){
			soma += indicador.calcula(i, serie);
		}
		return soma / intervalo;
	}
	
	
	@Override
	public String toString(){
		return "MMS de " + indicador.toString();
	}

}
