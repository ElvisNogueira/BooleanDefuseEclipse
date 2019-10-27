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
			g.setFont(Util.getFonte("Seven Segment"));
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
			
			
			g.dispose(); 
		    g2.dispose();
			
			
		}
	}
}
