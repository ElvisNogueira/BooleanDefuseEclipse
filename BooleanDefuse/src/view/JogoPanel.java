/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
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
    private ImageIcon bg, venceu;
    private Bomba bomba;
    private JButton verdadeiroButton,falsoButton, sairButton, ajudaFiosButton, ajudaQuizButton, 
    	ajudaTesteMesaButton, ajudaMorseButton;
    private Sprite ajuda;
    private JTextArea perguntaModuloQuiz;
    private JTextField elementoModMorse1, operadorModMorse, elementoModMorse2, resultadoModMorse, saidaCod;
    private ImageIcon ajudaIcon;
    

    public JogoPanel() {
        setSize(Util.LARGURA, Util.ALTURA);
        setLayout(null);
        
        bg = new ImageIcon("Imagens/BACKGROUND.png");
        venceu = new ImageIcon("Imagens/VENCEU.png");
        ajudaIcon = new ImageIcon("Imagens/ajuda.png");
       
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
        
        sairButton = new JButton("");
        sairButton.setIcon(new ImageIcon("Imagens/sair.png"));
        sairButton.setBackground(Color.red);
        
        ajudaFiosButton = new JButton("");
        ajudaFiosButton.setIcon(new ImageIcon("Imagens/ajuda.png"));
        ajudaFiosButton.setSize(30, 30);
        ajudaFiosButton.setLocation(266, 140);
        
        ajudaMorseButton = new JButton();
        ajudaMorseButton.setIcon(ajudaIcon);
        ajudaMorseButton.setSize(30, 30);
        ajudaMorseButton.setLocation(266, 430);
        
        ajudaQuizButton = new JButton();
        ajudaQuizButton.setIcon(ajudaIcon);
        ajudaQuizButton.setSize(30, 30);
        ajudaQuizButton.setLocation(633, 140);
        
        ajudaTesteMesaButton = new JButton("");
        ajudaTesteMesaButton.setIcon(ajudaIcon);
        ajudaTesteMesaButton.setSize(30, 30);
        ajudaTesteMesaButton.setLocation(882, 140);
        
        
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
        
        try {
			ajuda = new Sprite("Imagens/sprite dicas.png", 1, 482, 280, 4, 2, 281, 155);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        add(elementoModMorse1).setBounds(330, 587, 30, 30);
        add(operadorModMorse).setBounds(380, 587, 30, 30);
        add(elementoModMorse2).setBounds(430, 587, 30, 30);
        add(resultadoModMorse).setBounds(500, 587, 30, 30);
        add(saidaCod).setBounds(1030, 430, 50, 40);
        add(verdadeiroButton);
        add(falsoButton);
        add(perguntaModuloQuiz);
        add(ajudaFiosButton);
        add(ajudaMorseButton);
        add(ajudaQuizButton);
        add(ajudaTesteMesaButton);
        
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

	public ImageIcon getVenceu() {
		return venceu;
	}

	public JButton getAjudaFiosButton() {
		return ajudaFiosButton;
	}

	public JButton getAjudaQuizButton() {
		return ajudaQuizButton;
	}

	public JButton getAjudaTesteMesaButton() {
		return ajudaTesteMesaButton;
	}

	public JButton getAjudaMorseButton() {
		return ajudaMorseButton;
	}

	public Sprite getAjuda() {
		return ajuda;
	}

	public ImageIcon getAjudaIcon() {
		return ajudaIcon;
	}

	
	
  
	
	
    
    
}
