package br.com.caelum.argentum.geradorXML;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import br.com.caelum.argentum.Negociacao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class GeradorAleatorioDeXML {

	public static void main(String[] args) throws Exception {
		
		Calendar data = Calendar.getInstance();
		Random random = new Random(123);
		List<Negociacao> negociacoes = new ArrayList<Negociacao>();
		
		double valor = 40;
		int quantidade = 1000; 
		
		for ( int dias=0; dias<30; dias++ ) {
			
			int quantidadeNegociacoesDoDia = random.nextInt(20);
			
			for ( int negociacao = 0; negociacao < quantidadeNegociacoesDoDia; negociacao++ ) {
				
				valor+= (random.nextInt(200) - 100) / 100.0;
				
				if ( valor < 5.0 ) {
					valor = 5.0;
				}
				
				quantidade += (100 - random.nextInt(500));
				
				Negociacao n = new Negociacao(valor, quantidade, data);
				
				negociacoes.add(n);				
				
			}
			
			data = (Calendar) data.clone();
			data.add(Calendar.DAY_OF_YEAR, 1);
			
		}
		
		XStream stream = new XStream(new DomDriver());
		stream.alias("negociacao", Negociacao.class);
		stream.setMode(XStream.NO_REFERENCES);
		
		@SuppressWarnings("resource")
		PrintStream out = new PrintStream(new File("/home/lab3883/negociacao.xml"));
		out.println(stream.toXML(negociacoes));		
		
		System.out.println(stream.toXML(negociacoes));
		
	}
	
	
}