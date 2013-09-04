package br.com.caelum.argentum.reader;

import java.io.InputStream;
import java.util.List;

import br.com.caelum.argentum.Negociacao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class LeitorXML {
	
	@SuppressWarnings("unchecked")
	public List<Negociacao> carrega(InputStream inputStream){
		XStream stream = new XStream(new DomDriver());
		stream.alias("negociacao", Negociacao.class);

		return (List<Negociacao>) stream.fromXML(inputStream);
	}
}
