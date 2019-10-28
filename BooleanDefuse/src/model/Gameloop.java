package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import view.Tela;

public class Gameloop {
	public static Bomba bomba;
	
	public static void desenhar(Tela tela){
		
		Graphics2D g2 = (Graphics2D) tela.getGraphics(); 	
		Graphics g = tela.getBuffer().getGraphics();		
		g2.drawImage(tela.getBuffer(), 0, 0, null);
		bomba = tela.getJogoPanel().getBomba();
		
		
		if(tela.getJogoPanel().isVisible()) {
			//Background
			g.drawImage(tela.getJogoPanel().getBG().getImage(), -35, 0, null);
			
			//Bomba
			g.drawImage(tela.getJogoPanel().getBomba().getBomba().getImage(), 208, 85, null);
			
			//Relógio da bomba
			g.setFont(Util.getFonteLED("Seven Segment"));
			g.setColor(Color.RED);
			g.drawString(tela.getJogoPanel().getBomba().getRelogio().getTexto(), 700, 380);
			
			
			// Módulo fios
			g.drawImage(bomba.getModuloFios().getSprites()[0].sprites[bomba.getModuloFios().getSprites()[0].aparencia], 
					bomba.getModuloFios().getSprites()[0].posX, bomba.getModuloFios().getSprites()[0].posY, null);
			g.drawImage(bomba.getModuloFios().getSprites()[1].sprites[bomba.getModuloFios().getSprites()[1].aparencia], 
					bomba.getModuloFios().getSprites()[1].posX, bomba.getModuloFios().getSprites()[1].posY, null);
			g.drawImage(bomba.getModuloFios().getSprites()[2].sprites[bomba.getModuloFios().getSprites()[2].aparencia], 
					bomba.getModuloFios().getSprites()[2].posX, bomba.getModuloFios().getSprites()[2].posY, null);
			g.drawImage(bomba.getModuloFios().getLedStatus().sprites[bomba.getModuloFios().getLedStatus().aparencia], 
					bomba.getModuloFios().getLedStatus().posX, bomba.getModuloFios().getLedStatus().posY, null);
			
			
			//Modulo quiz
			tela.getJogoPanel().getVerdadeiroButton().repaint();
			tela.getJogoPanel().getFalsoButton().repaint();			
			tela.getJogoPanel().getPerguntaModuloQuiz().repaint();
			g.drawImage(bomba.getModuloQuiz().getLedStatus().sprites[bomba.getModuloQuiz().getLedStatus().aparencia], 
					bomba.getModuloQuiz().getLedStatus().posX, bomba.getModuloQuiz().getLedStatus().posY, null);
			
			//Modulo Morse
			tela.getJogoPanel().getElementoModMorse1().repaint();
			tela.getJogoPanel().getOperadorModMorse().repaint();
			tela.getJogoPanel().getElementoModMorse2().repaint();
			tela.getJogoPanel().getResultadoModMorse().repaint();
			
			g.setFont(Util.arial);
			g.setColor(Util.azulBic);
			g.drawString(bomba.getModuloMorse().getVocabuloMorse()[0].getPalavra(), 350, 500);
			g.drawString(bomba.getModuloMorse().getVocabuloMorse()[1].getPalavra(), 350, 520);
			g.drawString(bomba.getModuloMorse().getVocabuloMorse()[2].getPalavra(), 350, 540);
			
			g.drawImage(bomba.getModuloMorse().getLedStatus().sprites[bomba.getModuloMorse().getLedStatus().aparencia], 
					bomba.getModuloMorse().getLedStatus().posX, bomba.getModuloMorse().getLedStatus().posY, null);
			
			
			g.dispose(); 
		    g2.dispose();
			
			
		}
	}
}
