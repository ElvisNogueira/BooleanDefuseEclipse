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
    private JButton verdadeiroButton,falsoButton;
    private JTextArea perguntaModuloQuiz;
    private JTextField elementoModMorse1, operadorModMorse, elementoModMorse2, resultadoModMorse;
    
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
        verdadeiroButton.setBackground(new Color(172,161,155));
        
        falsoButton = new JButton("Falso");     
        falsoButton.setSize(100, 30);
        falsoButton.setLocation(735, 245);
        falsoButton.setBackground(new Color(172,161,155));
        
        elementoModMorse1 = new JTextField(1);
        operadorModMorse = new JTextField(2);
        elementoModMorse2 = new JTextField(1);
        resultadoModMorse = new JTextField(1);
        
        add(elementoModMorse1).setBounds(330, 590, 30, 30);
        add(operadorModMorse).setBounds(380, 590, 30, 30);
        add(elementoModMorse2).setBounds(430, 590, 30, 30);
        add(resultadoModMorse).setBounds(500, 590, 30, 30);
        
        add(verdadeiroButton);
        add(falsoButton);
        add(perguntaModuloQuiz);
        
        
        
        try {
			tempFios = new Sprite("Imagens/Fios v19.png", 0, 46, 133, 5, 9, 515, 235);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        setVisible(true);
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

	public Sprite getTempFios() {
		return tempFios;
	}
    
    
    
}
