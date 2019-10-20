package app;

import java.awt.List;
import java.util.ArrayList;

import dao.Xml;
import model.Teste;
import model.ThreadDesenhar;
import view.JogoPanel;
import view.Tela;

public class App {
	public static void main(String[] args) {
//		Tela tela;
//		JogoPanel jogoPainel = new JogoPanel();
//		
//		tela = new Tela(jogoPainel);
//		Thread desenhar = new ThreadDesenhar(tela);
//		desenhar.start();
		
		ArrayList<Teste> lista = new ArrayList<Teste>();
		lista.add(new Teste("Elvis", "22"));
		lista.add(new Teste("Williany", "23"));
		System.out.println(Xml.gerarXml(lista));
	}
}
