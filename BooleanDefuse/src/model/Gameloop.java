package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import view.Tela;

public class Gameloop {
	public static void desenhar(Tela tela){
		
		Graphics2D g2 = (Graphics2D) tela.getGraphics(); 	
		Graphics g = tela.getBuffer().getGraphics();		
		g2.drawImage(tela.getBuffer(), 0, 0, null);
		
		if(tela.getJogoPanel().isVisible()) {
			g.drawImage(tela.getJogoPanel().getBG().getImage(), -35, 0, null);
			g.drawImage(tela.getJogoPanel().getBomba().getBomba().getImage(), 209, 85, null);
			
			g.setFont(Util.getFonte("Seven Segment"));
			g.setColor(Color.RED);
			g.drawString(tela.getJogoPanel().getBomba().getRelogio().getTexto(), 700, 380);
			
			g.drawImage(tela.getJogoPanel().tempFios.sprites[tela.getJogoPanel().tempFios.aparencia],
					tela.getJogoPanel().tempFios.posX, tela.getJogoPanel().tempFios.posY, null);
			
			tela.getJogoPanel().getVerdadeiroButton().repaint();
			tela.getJogoPanel().getFalsoButton().repaint();
			
			
			tela.getJogoPanel().getPerguntaModuloQuiz().repaint();
			
			g.dispose(); 
		    g2.dispose();
			
			
		}
	}
}
