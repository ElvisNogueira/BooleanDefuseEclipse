package controller;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import model.Bomba;
import model.Sons;
import model.Util;
import view.JogoPanel;
import view.Mensagem;
import view.Tela;

public class ControladorJogoPanel{
	private JogoPanel jogoPanel;
	private Tela tela;
	Controlador c;
	int resposta;

	public ControladorJogoPanel(JogoPanel jogoPanel,Tela tela) {
		super();
		this.jogoPanel = jogoPanel;
		c = new Controlador();

		this.tela = tela;


		this.jogoPanel.getVerdadeiroButton().addActionListener(c);
		this.jogoPanel.getFalsoButton().addActionListener(c);
		this.jogoPanel.getSairButton().addActionListener(c);

		this.jogoPanel.getVerdadeiroButton().addMouseListener(c);;
		this.jogoPanel.getFalsoButton().addMouseListener(c);
		jogoPanel.addMouseMotionListener(c);
		jogoPanel.addMouseListener(c);

		jogoPanel.getElementoModMorse1().addKeyListener(c);
		jogoPanel.getElementoModMorse2().addKeyListener(c);
		jogoPanel.getOperadorModMorse().addKeyListener(c);
		jogoPanel.getResultadoModMorse().addKeyListener(c);
		jogoPanel.getSaidaCod().addKeyListener(c);

		tela.getGameOverPanel().getSair().addActionListener(c);
		tela.getGameOverPanel().getJogarNovamente().addActionListener(c);

		tela.getMenuPanel().getSairButton().addActionListener(c);
		tela.getMenuPanel().getPlayButton().addActionListener(c);

	}

	private class Controlador implements ActionListener, MouseListener, MouseMotionListener, KeyListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Sons.tocar("Sons/botao.wav");
			if(!jogoPanel.getBomba().getModuloQuiz().isStatus()) {
				if(e.getSource()==jogoPanel.getVerdadeiroButton()) {
					if(jogoPanel.getBomba().getModuloQuiz().corrigirResposta(true)) {
						jogoPanel.getBomba().getModuloQuiz().getLedStatus().aparencia=1;
						Sons.tocar("Sons/acerto.wav");
					}else {
						Sons.tocar("Sons/erro.wav");
						if(jogoPanel.getBomba().getRelogio().getTempo()<=10) {
							jogoPanel.getBomba().getRelogio().setTempo(0);
						}else {
							jogoPanel.getBomba().getRelogio().setTempo(jogoPanel.getBomba().getRelogio().getTempo()-10);
							jogoPanel.getBomba().getModuloQuiz().setPergunta(jogoPanel.getBomba().getModuloQuiz().selecionarPergunta());
							jogoPanel.getPerguntaModuloQuiz().setText(jogoPanel.getBomba().getModuloQuiz().getPergunta().getPergunta());
						}

					}
				}else if (e.getSource()==jogoPanel.getFalsoButton()){
					if(jogoPanel.getBomba().getModuloQuiz().corrigirResposta(false)) {
						jogoPanel.getBomba().getModuloQuiz().getLedStatus().aparencia=1;
						Sons.tocar("Sons/acerto.wav");
					}else {
						Sons.tocar("Sons/erro.wav");
						jogoPanel.getBomba().getRelogio().setTempo(jogoPanel.getBomba().getRelogio().getTempo()-10);
						jogoPanel.getBomba().getModuloQuiz().setPergunta(jogoPanel.getBomba().getModuloQuiz().selecionarPergunta());
						jogoPanel.getPerguntaModuloQuiz().setText(jogoPanel.getBomba().getModuloQuiz().getPergunta().getPergunta());
					}

				}
				if(jogoPanel.getBomba().desativarBomba()) {
					tela.getGameOverPanel().setVisible(true);
				}
			}			

			if(e.getSource()==tela.getGameOverPanel().getJogarNovamente()) {
				conferirPartidasJogadas();
				tela.getGameOverPanel().setVisible(false);
				Util.explodir = false;
				Util.flagDesarmada = false;
				Util.flagMostrarDica = false;

				jogoPanel.getElementoModMorse1().setText("");
				jogoPanel.getElementoModMorse2().setText("");
				jogoPanel.getOperadorModMorse().setText("");
				jogoPanel.getResultadoModMorse().setText("");
				jogoPanel.getSaidaCod().setText("");

				jogoPanel.getBomba().reiniciarBomba();
				jogoPanel.setVisible(true);

				Sons.tocar("Sons/cap_priece.wav");		
			}else if(e.getSource()==tela.getMenuPanel().getPlayButton()) {
				conferirPartidasJogadas();

				tela.getMenuPanel().parar();
				tela.getMenuPanel().setVisible(false);
				tela.getMenuPanel().getTema().pararDeTocarInstance();

				jogoPanel.getElementoModMorse1().setText("");
				jogoPanel.getElementoModMorse2().setText("");
				jogoPanel.getOperadorModMorse().setText("");
				jogoPanel.getResultadoModMorse().setText("");
				jogoPanel.getSaidaCod().setText("");

				tela.getJogoPanel().setVisible(true);
				
				
				tela.getJogoPanel().getBomba().iniciarBomba();
				Sons.tocar("Sons/cap_priece.wav");
			}else if(e.getSource()==tela.getGameOverPanel().getSair()) {
				resposta = Mensagem.mostrarPergunta("Deseja realmente voltar para o menu?");
				switch (resposta) {
				case 0:
					tela.getMenuPanel().setVisible(true);
					tela.getMenuPanel().reiniciarTema();
					tela.getGameOverPanel().setVisible(false);
					Util.explodir = false;
					Util.flagDesarmada = false;
					break;
				default:
					break;
				}
			}else if(e.getSource()==tela.getMenuPanel().getSairButton()) {
				resposta = Mensagem.mostrarPergunta("Deseja realmente sair do jogo?");
				switch (resposta) {
				case 0:
					System.exit(0);
					break;
				default:
					break;
				}

			}else if(e.getSource()==tela.getJogoPanel().getSairButton()) {	
				resposta = Mensagem.mostrarPergunta("Deseja realmente voltar para o menu?");
				switch (resposta) {
				case 0:
					tela.getJogoPanel().getBomba().parar();
					tela.getJogoPanel().setVisible(false);
					tela.getMenuPanel().getTema().tocarInstance();
					tela.getMenuPanel().setVisible(true);
					Util.flagDesarmada = false;
					tela.getMenuPanel().reiniciarTema();
					break;
				default:
					break;
				}
			}

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			Util.flagEasterEgg = false;

			if(Util.partidasJogadas<4) {
				if(jogoPanel.getBomba().getModuloFios().colisaoAjuda(e.getX(), e.getY())) {
					//					Mensagem.dicas(0);
					if(e.getClickCount()==3)
						Util.flagEasterEgg = true;
					if(!Util.flagMostrarDica) {
						jogoPanel.getBomba().getModuloFios().getDica().aparencia = 0;
						jogoPanel.getBomba().getModuloFios().getDica().posX = 262;
						jogoPanel.getBomba().getModuloFios().getDica().posY = 190;
						Util.flagMostrarDica = true;
					}else {
						Util.flagMostrarDica = false;
					}
				}else if(jogoPanel.getBomba().getModuloQuiz().colisaoAjuda(e.getX(), e.getY())) {
					//					Mensagem.dicas(1);
					if(!Util.flagMostrarDica) {
						jogoPanel.getBomba().getModuloFios().getDica().aparencia = 1;
						jogoPanel.getBomba().getModuloFios().getDica().posX = 392;
						jogoPanel.getBomba().getModuloFios().getDica().posY = 161;
						Util.flagMostrarDica = true;
					}else {
						Util.flagMostrarDica = false;
					}
				}else if(jogoPanel.getBomba().getModuloTesteMesa().colisaoAjuda(e.getX(), e.getY())) {
					//					Mensagem.dicas(2);
					if(!Util.flagMostrarDica) {
						jogoPanel.getBomba().getModuloFios().getDica().aparencia = 2;
						jogoPanel.getBomba().getModuloFios().getDica().posX = 878;
						jogoPanel.getBomba().getModuloFios().getDica().posY = 190;
						Util.flagMostrarDica = true;
					}else {
						Util.flagMostrarDica = false;
					}
				}else if(jogoPanel.getBomba().getModuloMorse().colisaoAjuda(e.getX(), e.getY())) {
					//					Mensagem.dicas(3);
					if(!Util.flagMostrarDica) {
						jogoPanel.getBomba().getModuloFios().getDica().aparencia = 3;
						jogoPanel.getBomba().getModuloFios().getDica().posX = 262;
						jogoPanel.getBomba().getModuloFios().getDica().posY = 275;	
						Util.flagMostrarDica = true;
					}else {
						Util.flagMostrarDica = false;
					}

				}
			}
			jogoPanel.getBomba().getModuloFios().cortarFios(e.getX(), e.getY());
			jogoPanel.getBomba().desativarBomba();
			if(jogoPanel.getBomba().explodir()) {
				jogoPanel.setVisible(false);
				tela.getGameOverPanel().setVisible(true);
			}

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			if((arg0.getSource()==jogoPanel.getVerdadeiroButton()) || arg0.getSource()==jogoPanel.getFalsoButton())
				jogoPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));				

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			if((arg0.getSource()==jogoPanel.getVerdadeiroButton()) || arg0.getSource()==jogoPanel.getFalsoButton())
				jogoPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));				

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			jogoPanel.getBomba().getModuloFios().colisaoFios(e.getX(), e.getY());
			if(jogoPanel.getBomba().getModuloFios().emCimaDoFio(e.getX(), e.getY())) {
				jogoPanel.getBomba().getModuloFios().getAlicate().aparencia = 0;
				jogoPanel.getBomba().getModuloFios().getAlicate().posX = e.getX();
				jogoPanel.getBomba().getModuloFios().getAlicate().posY = e.getY();
				jogoPanel.setCursor(jogoPanel.getToolkit().createCustomCursor(
						new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
						"null"));	
			}else {
				jogoPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				jogoPanel.getBomba().getModuloFios().getAlicate().aparencia = 1;
			}

			if(Util.partidasJogadas<4) {
				jogoPanel.getBomba().getModuloFios().colisaoAjuda(e.getX(), e.getY());
				jogoPanel.getBomba().getModuloMorse().colisaoAjuda(e.getX(), e.getY());
				jogoPanel.getBomba().getModuloQuiz().colisaoAjuda(e.getX(), e.getY());
				jogoPanel.getBomba().getModuloTesteMesa().colisaoAjuda(e.getX(), e.getY());
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getSource()==jogoPanel.getElementoModMorse1() || e.getSource()==jogoPanel.getElementoModMorse2()
					|| e.getSource()==jogoPanel.getOperadorModMorse() || e.getSource()==jogoPanel.getResultadoModMorse()) {

				jogoPanel.getBomba().getModuloMorse().corrigirResposta(jogoPanel.getElementoModMorse1().getText(), 
						jogoPanel.getElementoModMorse2().getText(), jogoPanel.getOperadorModMorse().getText(), 
						jogoPanel.getResultadoModMorse().getText());
				jogoPanel.getBomba().desativarBomba();
			}else if(e.getSource()==jogoPanel.getSaidaCod()) {
				if(jogoPanel.getBomba().getModuloTesteMesa().corrigir(jogoPanel.getSaidaCod().getText())) {
					jogoPanel.getBomba().getModuloTesteMesa().setStatus(true);
					jogoPanel.getBomba().desativarBomba();
				}
			}

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		public void conferirPartidasJogadas() {
			Util.partidasJogadas++;
			if(Util.partidasJogadas>3) {
				jogoPanel.getBomba().getModuloFios().getAjuda().aparencia=2;
				jogoPanel.getBomba().getModuloMorse().getAjuda().aparencia=2;
				jogoPanel.getBomba().getModuloQuiz().getAjuda().aparencia=2;
				jogoPanel.getBomba().getModuloTesteMesa().getAjuda().aparencia=2;
			}
		}

	}




}
