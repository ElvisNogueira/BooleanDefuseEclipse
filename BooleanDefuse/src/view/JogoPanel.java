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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Bomba;
import model.Sprite;
import model.Util;

/**
 *
 * @author Elvis Nogueira
 */
public class JogoPanel extends JPanel{
    private ImageIcon bg;
    private Bomba bomba;
    private JButton verdadeiroButton,falsoButton, sairButton;
    private JTextArea perguntaModuloQuiz;
    private JTextField elementoModMorse1, operadorModMorse, elementoModMorse2, resultadoModMorse, saidaCod;
    

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
        verdadeiroButton.setBackground(new Color(172,161,155));
        
        falsoButton = new JButton("Falso");     
        falsoButton.setSize(100, 30);
        falsoButton.setLocation(735, 245);
        falsoButton.setBackground(new Color(172,161,155));
        
        sairButton = new JButton();
        sairButton.setIcon(new ImageIcon("Imagens/sair.png"));
        sairButton.setBackground(Color.red);
        
        elementoModMorse1 = new JTextField(1);
        operadorModMorse = new JTextField(2);
        elementoModMorse2 = new JTextField(1);
        resultadoModMorse = new JTextField(1);
        saidaCod = new JTextField(2);
        
        elementoModMorse1.setHorizontalAlignment(elementoModMorse1.CENTER);
        operadorModMorse.setHorizontalAlignment(operadorModMorse.CENTER);
        elementoModMorse2.setHorizontalAlignment(elementoModMorse2.CENTER);
        resultadoModMorse.setHorizontalAlignment(resultadoModMorse.CENTER);
        saidaCod.setHorizontalAlignment(saidaCod.CENTER);
        
        
        
        
        add(elementoModMorse1).setBounds(330, 587, 30, 30);
        add(operadorModMorse).setBounds(380, 587, 30, 30);
        add(elementoModMorse2).setBounds(430, 587, 30, 30);
        add(resultadoModMorse).setBounds(500, 587, 30, 30);
        add(saidaCod).setBounds(1030, 430, 50, 40);
        add(verdadeiroButton);
        add(falsoButton);
        add(perguntaModuloQuiz);
        
        add(sairButton).setBounds(1250, 50, 60, 60);
        
        
        setVisible(false);
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

	public ImageIcon getBg() {
		return bg;
	}

	public JTextField getElementoModMorse1() {
		return elementoModMorse1;
	}

	public JTextField getOperadorModMorse() {
		return operadorModMorse;
	}

	public JTextField getElementoModMorse2() {
		return elementoModMorse2;
	}

	public JTextField getResultadoModMorse() {
		return resultadoModMorse;
	}

	public JTextField getSaidaCod() {
		return saidaCod;
	}

	public JButton getSairButton() {
		return sairButton;
	}
  
	
	
    
    
}
