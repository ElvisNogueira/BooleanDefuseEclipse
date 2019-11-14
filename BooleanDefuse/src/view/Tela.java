/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import model.Util;

/**
 *
 * @author Elvis Nogueira
 */
public class Tela extends JFrame{
    private JogoPanel jogoPanel;
    private GameOverPanel gameOverPanel;
    private MenuPanel menuPanel;
    private BufferedImage buffer;;
    BufferStrategy buffer1;
    
    public Tela(JogoPanel jogoPanel, GameOverPanel gameOverPanel, MenuPanel menuPanel) {
    	super("Boolean Defuse");
    	setIconImage(new ImageIcon("Imagens/icone.png").getImage());
        setSize(Util.LARGURA, Util.ALTURA);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        buffer = new BufferedImage(Util.LARGURA, Util.ALTURA, BufferedImage.TYPE_INT_RGB);
        
        
        this.jogoPanel = jogoPanel;
        this.gameOverPanel = gameOverPanel;
        this.menuPanel = menuPanel;
        
        add(this.jogoPanel);
        add(menuPanel).setBounds(0, 0, Util.LARGURA, Util.ALTURA);
        add(this.gameOverPanel).setBounds(0, 0, Util.LARGURA, Util.ALTURA);
        this.jogoPanel.setBounds(0, 0, Util.LARGURA, Util.ALTURA);
        
        setVisible(true);
        
    }

	public JogoPanel getJogoPanel() {
		return jogoPanel;
	}

	public BufferedImage getBuffer() {
		return buffer;
	}

	public GameOverPanel getGameOverPanel() {
		return gameOverPanel;
	}

	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	public BufferStrategy getBuffer1() {
		return buffer1;
	}

	public void setBuffer1(BufferStrategy buffer1) {
		this.buffer1 = buffer1;
	}
    
	
	
}
