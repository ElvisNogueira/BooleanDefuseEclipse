/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.ImageIcon;

/**
 *
 * @author Elvis Nogueira
 */
public class Bomba {   
    private ImageIcon bomba;
    private ModuloFios moduloFios;
    private ModuloMorse moduloMorse;
    private ModuloQuiz moduloQuiz;
    private ModuloTesteMesa moduloTesteMesa;
    private Relogio relogio;
    
    public Bomba() {
    	bomba = new ImageIcon("Imagens/bomba.png");
    	moduloQuiz = new ModuloQuiz();
    	moduloFios = new ModuloFios();
    	
    	relogio = new Relogio();
    	relogio.start();
    	
    }
    
    public void initBomba() {
    	moduloQuiz.initModQuiz();
    	moduloFios.initModFios();
    	relogio.start();
    	
    }
    
    public void desativarBomba() {
    	System.out.println("Chamou com "+moduloFios.isStatus()+" e "+moduloQuiz.isStatus());
    	if(moduloFios.isStatus() && moduloQuiz.isStatus()) {
    		System.out.println("Entrou");
    		relogio.stop();
    	}
    }

	public ModuloFios getModuloFios() {
		return moduloFios;
	}

	public void setModuloFios(ModuloFios moduloFios) {
		this.moduloFios = moduloFios;
	}

	public ModuloMorse getModuloMorse() {
		return moduloMorse;
	}

	public void setModuloMorse(ModuloMorse moduloMorse) {
		this.moduloMorse = moduloMorse;
	}

	public ModuloQuiz getModuloQuiz() {
		return moduloQuiz;
	}

	public void setModuloQuiz(ModuloQuiz moduloQuiz) {
		this.moduloQuiz = moduloQuiz;
	}

	public ModuloTesteMesa getModuloTesteMesa() {
		return moduloTesteMesa;
	}

	public void setModuloTesteMesa(ModuloTesteMesa moduloTesteMesa) {
		this.moduloTesteMesa = moduloTesteMesa;
	}

	public Relogio getRelogio() {
		return relogio;
	}

	public void setRelogio(Relogio relogio) {
		this.relogio = relogio;
	}

	public ImageIcon getBomba() {
		return bomba;
	}

	public void setBomba(ImageIcon bomba) {
		this.bomba = bomba;
	}
    
    
}
