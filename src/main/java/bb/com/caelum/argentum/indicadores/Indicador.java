package bb.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.SerieTemporal;

public interface Indicador {

	public abstract double calcula(int posicao, SerieTemporal serie);

}