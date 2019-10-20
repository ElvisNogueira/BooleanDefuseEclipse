/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

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
    
    public Sprite tempFios;

    public JogoPanel() {
        setSize(Util.LARGURA, Util.ALTURA);
        setLayout(null);
        
        bg = new ImageIcon("Imagens/BACKGROUND.png");
        bomba = new Bomba();
        
        try {
			tempFios = new Sprite("Imagens/Fios 01.png", 18, 40, 138, 5, 9, 290, 250);
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
    
    
    
}
