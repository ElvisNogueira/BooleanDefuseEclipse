/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import model.Bomba;
import model.Sprite;
import model.Util;

/**
 *
 * @author Elvis Nogueira
 */
public class JogoPanel extends JPanel{
    private boolean visible = true;
    private ImageIcon bg;
    private Bomba bomba;
    private JButton verdadeiroButton,falsoButton;
    private JTextArea perguntaModuloQuiz;
    
    public Sprite tempFios;

    public JogoPanel() {
        setSize(Util.LARGURA, Util.ALTURA);
        setLayout(null);
        
        bg = new ImageIcon("Imagens/BACKGROUND.png");
        bomba = new Bomba();
        
        perguntaModuloQuiz = new JTextArea();
        perguntaModuloQuiz.setSize(185, 30);
        perguntaModuloQuiz.setEditable(false);
        perguntaModuloQuiz.setLineWrap(true);
        perguntaModuloQuiz.setText(bomba.getModuloQuiz().getPergunta().getPergunta());
        perguntaModuloQuiz.setLocation(640, 180);
        
        verdadeiroButton = new JButton("Verdadeiro");
        verdadeiroButton.setSize(100, 30);
        verdadeiroButton.setLocation(630, 245);
        
        falsoButton = new JButton("Falso");     
        falsoButton.setSize(100, 30);
        falsoButton.setLocation(735, 245);
        
        add(verdadeiroButton);
        add(falsoButton);
        add(perguntaModuloQuiz);
        
        
        
        try {
			tempFios = new Sprite("Imagens/Fios v19.png", 18, 46, 133, 5, 9, 290, 235);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        setVisible(true);
    }

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public ImageIcon getBG() {
		return bg;
	}

	public Bomba getBomba() {
		return bomba;
	}

	public void setBomba(Bomba bomba) {
		this.bomba = bomba;
	}

	public JButton getVerdadeiroButton() {
		return verdadeiroButton;
	}

	public JButton getFalsoButton() {
		return falsoButton;
	}

	public JTextArea getPerguntaModuloQuiz() {
		return perguntaModuloQuiz;
	}
    
    
    
}
