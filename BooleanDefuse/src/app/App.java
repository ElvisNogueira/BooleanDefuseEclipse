package app;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import controller.ControladorJogoPanel;
import dao.FiosDao;
import dao.PerguntasDao;
import dao.Xml;
import model.Relogio;
import model.TEMPCriarFios;
import model.TEMPCriarPerguntas;
import model.Teste;
import model.ThreadDesenhar;
import model.Util;
import view.JogoPanel;
import view.Mensagem;
import view.Tela;

public class App {
	public static void main(String[] args) {
		Tela tela;
		JogoPanel jogoPainel = new JogoPanel();
		
		tela = new Tela(jogoPainel);
	
		Thread desenhar = new ThreadDesenhar(tela);
		desenhar.start();
		
		ControladorJogoPanel cjp = new ControladorJogoPanel(tela.getJogoPanel());
//		Relogio relogio = new Relogio(300);
//		
//		relogio.start();
		
//		PerguntasDao.insert(TEMPCriarPerguntas.criarPerguntas());
//		FiosDao.insert(TEMPCriarFios.criarFios());

	}
}
