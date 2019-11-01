package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Sons;
import model.Util;

public class MenuPanel extends JPanel{

	private ImageIcon menuBG;
	private JButton playButton,sairButton;

	public MenuPanel() {
//		tocar();
		setSize(Util.LARGURA, Util.ALTURA);
		setLayout(null);

		menuBG = new ImageIcon("Imagens/BACKGROUND menu.png");

		playButton = new JButton();
		playButton.setIcon(new ImageIcon("Imagens/reproduzir.png"));
		playButton.setBackground(Color.RED);
		
		sairButton = new JButton();
		sairButton.setIcon(new ImageIcon("Imagens/sair.png"));
		sairButton.setBackground(Color.RED);
		

		add(playButton).setBounds(50, 650, 60, 60);
		add(sairButton).setBounds(1246, 650, 60, 60);
		

		setVisible(true);
	}

	public void tocar() {
		Sons.tocar("Sons/tema.wav");
	}

	public void parar() {
		Sons.pararDeTocar();
	}
	public ImageIcon getMenuBG() {
		return menuBG;
	}

	public JButton getPlayButton() {
		return playButton;
	}

	public JButton getSairButton() {
		return sairButton;
	}

	

}
