package model;

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
			
			g.drawImage(tela.getJogoPanel().getBomba().getRelogio().getDezMinutoSprite().sprites[
			     tela.getJogoPanel().getBomba().getRelogio().getDezMinutoSprite().aparencia], 
					tela.getJogoPanel().getBomba().getRelogio().getDezMinutoSprite().posX, 
					tela.getJogoPanel().getBomba().getRelogio().getDezMinutoSprite().posY, null);
			g.drawImage(tela.getJogoPanel().getBomba().getRelogio().getUnidMinutoSprite().sprites[
			     tela.getJogoPanel().getBomba().getRelogio().getUnidMinutoSprite().aparencia], 
					tela.getJogoPanel().getBomba().getRelogio().getUnidMinutoSprite().posX, 
					tela.getJogoPanel().getBomba().getRelogio().getUnidMinutoSprite().posY, null);
			g.drawImage(tela.getJogoPanel().getBomba().getRelogio().getDoisPontos().sprites[
			     tela.getJogoPanel().getBomba().getRelogio().getDoisPontos().aparencia], 
					tela.getJogoPanel().getBomba().getRelogio().getDoisPontos().posX, 
					tela.getJogoPanel().getBomba().getRelogio().getDoisPontos().posY, null);
			g.drawImage(tela.getJogoPanel().getBomba().getRelogio().getDezSegundoSprite().sprites[
			     tela.getJogoPanel().getBomba().getRelogio().getDezSegundoSprite().aparencia], 
					tela.getJogoPanel().getBomba().getRelogio().getDezSegundoSprite().posX, 
					tela.getJogoPanel().getBomba().getRelogio().getDezSegundoSprite().posY, null);
			g.drawImage(tela.getJogoPanel().getBomba().getRelogio().getUnidSegundoSprite().sprites[
			     tela.getJogoPanel().getBomba().getRelogio().getUnidSegundoSprite().aparencia], 
					tela.getJogoPanel().getBomba().getRelogio().getUnidSegundoSprite().posX, 
					tela.getJogoPanel().getBomba().getRelogio().getUnidSegundoSprite().posY, null);
			
		}
	}
}
