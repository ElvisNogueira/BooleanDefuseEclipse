/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import model.Util;

/**
 *
 * @author Elvis Nogueira
 */
public class Tela extends JFrame{
    private JogoPanel jogoPanel;
    private BufferedImage buffer;;
    
    public Tela(JogoPanel jogoPanel) {
        setSize(Util.LARGURA, Util.ALTURA);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        buffer = new BufferedImage(Util.LARGURA, Util.ALTURA, BufferedImage.TYPE_INT_RGB);
        
        this.jogoPanel = jogoPanel;
        add(this.jogoPanel);
        this.jogoPanel.setBounds(0, 0, Util.LARGURA, Util.ALTURA);
        
        setVisible(true);
        
    }

	public JogoPanel getJogoPanel() {
		return jogoPanel;
	}

	public BufferedImage getBuffer() {
		return buffer;
	}
    
    
    
    
    
}
