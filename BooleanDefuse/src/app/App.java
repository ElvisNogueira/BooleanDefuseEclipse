package app;

import model.ThreadDesenhar;
import view.JogoPanel;
import view.Tela;

public class App {
	public static void main(String[] args) {
		Tela tela;
		JogoPanel jogoPainel = new JogoPanel();
		
		tela = new Tela(jogoPainel);
		Thread desenhar = new ThreadDesenhar(tela);
		desenhar.start();
	}
}
