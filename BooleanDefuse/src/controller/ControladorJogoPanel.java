package controller;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import model.Bomba;
import model.Sons;
import model.Util;
import view.JogoPanel;
import view.Tela;

public class ControladorJogoPanel{
	private JogoPanel jogoPanel;
	private Tela tela;
	Controlador c;

	public ControladorJogoPanel(JogoPanel jogoPanel,Tela tela) {
		super();
		this.jogoPanel = jogoPanel;
		c = new Controlador();
		
		this.tela = tela;
		
		
		this.jogoPanel.getVerdadeiroButton().addActionListener(c);
		this.jogoPanel.getFalsoButton().addActionListener(c);
		
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
				jogoPanel.getBomba().desativarBomba();
			}			
			
			if(e.getSource()==tela.getGameOverPanel().getJogarNovamente()) {
				tela.getGameOverPanel().setVisible(false);
				Util.explodir = false;
				jogoPanel.setVisible(true);
				
				jogoPanel.getBomba().reiniciarBomba();
			}else if(e.getSource()==tela.getMenuPanel().getPlayButton()) {
				tela.getMenuPanel().parar();
				tela.getMenuPanel().setVisible(false);
				tela.getJogoPanel().setVisible(true);
				tela.getJogoPanel().getBomba().iniciarBomba();
			}else if(e.getSource()==tela.getGameOverPanel().getSair()) {
				tela.getMenuPanel().setVisible(true);
				tela.getGameOverPanel().setVisible(false);
			}else if(e.getSource()==tela.getMenuPanel().getSairButton()) {
				System.exit(0);
			}
				
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			jogoPanel.getBomba().getModuloFios().cortarFios(arg0.getX(), arg0.getY());
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
		
	}
	
	
	

}
