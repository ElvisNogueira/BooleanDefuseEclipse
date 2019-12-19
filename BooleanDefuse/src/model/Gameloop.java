package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import view.JogoPanel;
import view.Tela;

public class Gameloop {
	public static Bomba bomba;
	public static int[] relogio;
	
	public static void desenhar(Tela tela){
		
		Graphics2D g = (Graphics2D) tela.getBuffer1().getDrawGraphics(); 	
//		Graphics g = tela.getBuffer().getGraphics();		
		g.drawImage(tela.getBuffer(), 0, 0, null);
		bomba = tela.getJogoPanel().getBomba();
		
		
		if(tela.getJogoPanel().isVisible()) {
			//Background
			g.drawImage(tela.getJogoPanel().getBG().getImage(), -35, 0, null);
			
			//Bomba
			g.drawImage(tela.getJogoPanel().getBomba().getBomba().getImage(), 208, 85, null);
			
			//Relógio da bomba
			g.setFont(Util.getFont("Seven Segment",40));
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
			
			g.drawImage(bomba.getModuloFios().getAjuda().sprites[bomba.getModuloFios().getAjuda().aparencia], 
					bomba.getModuloFios().getAjuda().posX, bomba.getModuloFios().getAjuda().posY, null);
			
			g.drawImage(bomba.getModuloFios().getAlicate().sprites[bomba.getModuloFios().getAlicate().aparencia],
					bomba.getModuloFios().getAlicate().posX, bomba.getModuloFios().getAlicate().posY, null);
			
			//Modulo quiz
			
			g.drawImage(bomba.getModuloQuiz().getLedStatus().sprites[bomba.getModuloQuiz().getLedStatus().aparencia], 
					bomba.getModuloQuiz().getLedStatus().posX, bomba.getModuloQuiz().getLedStatus().posY, null);
			
			
			
			g.setFont(Util.arial);
			g.setColor(Util.azulBic);
			g.drawString(bomba.getModuloMorse().getVocabuloMorse()[0].getPalavra(), 310, 505);
			g.drawString(bomba.getModuloMorse().getVocabuloMorse()[1].getPalavra(), 310, 525);
			g.drawString(bomba.getModuloMorse().getVocabuloMorse()[2].getPalavra(), 310, 545);
			g.drawImage(bomba.getModuloMorse().getLedStatus().sprites[bomba.getModuloMorse().getLedStatus().aparencia], 
					bomba.getModuloMorse().getLedStatus().posX, bomba.getModuloMorse().getLedStatus().posY, null);
			
			g.drawImage(bomba.getModuloQuiz().getLedStatus().sprites[bomba.getModuloQuiz().getLedStatus().aparencia], 
					bomba.getModuloQuiz().getLedStatus().posX, bomba.getModuloQuiz().getLedStatus().posY, null);
			
			g.drawImage(bomba.getModuloQuiz().getAjuda().sprites[bomba.getModuloQuiz().getAjuda().aparencia], 
					bomba.getModuloQuiz().getAjuda().posX, bomba.getModuloQuiz().getAjuda().posY, null);
			
			//Modulo teste mesa
			
			g.drawImage(bomba.getModuloTesteMesa().getSimbolo().sprites[bomba.getModuloTesteMesa().getSimbolo().aparencia], 
					bomba.getModuloTesteMesa().getSimbolo().posX, bomba.getModuloTesteMesa().getSimbolo().posY, null);
			g.drawImage(bomba.getModuloTesteMesa().getLedStatus().sprites[bomba.getModuloTesteMesa().getLedStatus().aparencia], 
					bomba.getModuloTesteMesa().getLedStatus().posX, bomba.getModuloTesteMesa().getLedStatus().posY, null);
			g.drawImage(bomba.getModuloTesteMesa().getAjuda().sprites[bomba.getModuloTesteMesa().getAjuda().aparencia], 
					bomba.getModuloTesteMesa().getAjuda().posX, bomba.getModuloTesteMesa().getAjuda().posY, null);
			
			g.setFont(Util.getFont("Anton-Regular", 30));
			g.setColor(Color.white);
			
			g.drawString(bomba.getModuloTesteMesa().getEntradas()[0]+"", 970, 380);
			g.drawString(bomba.getModuloTesteMesa().getEntradas()[1]+"", 990, 380);
			g.drawString(bomba.getModuloTesteMesa().getEntradas()[2]+"", 1010, 380);
			
			
			
			
			
			//Modulo Morse
			
			g.drawImage(bomba.getModuloMorse().getAjuda().sprites[bomba.getModuloMorse().getAjuda().aparencia], 
					bomba.getModuloMorse().getAjuda().posX, bomba.getModuloMorse().getAjuda().posY, null);
			
			if(Util.flagMostrarDica) {
				g.drawImage(bomba.getModuloFios().getDica().sprites[bomba.getModuloFios().getDica().aparencia], 
						bomba.getModuloFios().getDica().posX, bomba.getModuloFios().getDica().posY, null);
			}
			
			
			
			tela.getJogoPanel().getVerdadeiroButton().repaint();
			tela.getJogoPanel().getFalsoButton().repaint();			
			tela.getJogoPanel().getPerguntaModuloQuiz().repaint();
			
			
			tela.getJogoPanel().getSaidaCod().repaint();
			
			tela.getJogoPanel().getSairButton().repaint();
			
			
			if(Util.flagEasterEgg) {
				g.setFont(Util.getFont("Anton-Regular", 140));
				g.setColor(Color.red);
				g.drawString("LANA IS", 450, 300);
				g.setFont(Util.getFont("Anton-Regular", 105));
				g.setColor(Color.white);
				g.drawString("AWESOME", 450, 420);
			}
			//VENCEU
			
				
			tela.getJogoPanel().getElementoModMorse1().repaint();
			tela.getJogoPanel().getOperadorModMorse().repaint();
			tela.getJogoPanel().getElementoModMorse2().repaint();
			tela.getJogoPanel().getResultadoModMorse().repaint();
			
		}else if(tela.getMenuPanel().isVisible()) {
			g.drawImage(tela.getMenuPanel().getMenuBG().getImage(), -35, 0, null);
			tela.getMenuPanel().getSairButton().repaint();
			tela.getMenuPanel().getPlayButton().repaint();
		}
		
		if(Util.explodir) {
			if(!tela.getGameOverPanel().isVisible()) {
				tela.getJogoPanel().setVisible(false);
				tela.getGameOverPanel().setVisible(true);
				bomba.explodir();
			}
			g.drawImage(tela.getGameOverPanel().getBombaExplosao().getImage(), 0, 0, null);
			tela.getGameOverPanel().getJogarNovamente().repaint();
			tela.getGameOverPanel().getSair().repaint();
		}
		
		if(Util.flagDesarmada) {
			tela.getJogoPanel().setVisible(false);
			tela.getGameOverPanel().setVisible(true);
			g.drawImage(tela.getGameOverPanel().getImagemSucesso().getImage(), -35, 0, null);
			int tempoDec = tela.getJogoPanel().getBomba().getRelogio().getTempo();
			
			g.setFont(Util.getFont("Anton-Regular",40));
			g.setColor(Color.white);
			
			relogio = tela.getJogoPanel().getBomba().getRelogio().calcularHora(Util.TEMPO_JOGO_SEG - tempoDec);
			
			g.drawString(relogio[0]+""+relogio[1]+":"+relogio[2]+""+relogio[3], 670, 670);
			
			tela.getGameOverPanel().getJogarNovamente().repaint();
			tela.getGameOverPanel().getSair().repaint();
		}
		
		
		g.dispose(); 
//	    g2.dispose();
		tela.getBuffer1().show();
	}
}
