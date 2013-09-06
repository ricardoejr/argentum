package bb.com.caelum.argentum.indicadores;

import java.lang.reflect.Constructor;

public class IndicadorFactory {
	private static final String pacote = "bb.com.caelum.argentum.indicadores.";
	private String nomeIndicador;
	private String nomeMedia;

	public IndicadorFactory(String nomeIndicador, String nomeMedia) {
		this.nomeIndicador = nomeIndicador;
		this.nomeMedia = nomeMedia;
	}

	public Indicador getIndicador() {
		try {
			Indicador indicador = (Indicador) Class.forName(
					pacote + this.nomeIndicador)
					.newInstance();

			if (this.nomeMedia != null && !this.nomeMedia.isEmpty()) {
				Constructor<?> constructor = Class.forName(
						pacote + this.nomeMedia)
						.getConstructor(Indicador.class);
				indicador = (Indicador) constructor.newInstance(indicador);
			}

			return indicador;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
