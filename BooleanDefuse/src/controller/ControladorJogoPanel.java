package controller;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import model.Sons;
import view.JogoPanel;

public class ControladorJogoPanel{
	private JogoPanel jogoPanel;
	Controlador c;

	public ControladorJogoPanel(JogoPanel jogoPanel) {
		super();
		this.jogoPanel = jogoPanel;
		c = new Controlador();
		
		
		this.jogoPanel.getVerdadeiroButton().addActionListener(c);
		this.jogoPanel.getFalsoButton().addActionListener(c);
		
		this.jogoPanel.getVerdadeiroButton().addMouseListener(c);;
		this.jogoPanel.getFalsoButton().addMouseListener(c);
		
	}
	
	private class Controlador implements ActionListener, MouseListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Sons.tocar("Sons/botao.wav");			
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
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
		
	}
	
	
	

}
