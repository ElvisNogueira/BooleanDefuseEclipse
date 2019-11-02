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
    	bomba = new ImageIcon("Imagens/bomba 2.png");
    	moduloQuiz = new ModuloQuiz();
    	moduloFios = new ModuloFios();
    	moduloMorse = new ModuloMorse();
    	moduloTesteMesa = new ModuloTesteMesa();
    	
    	
    	
    	relogio = new Relogio();
    	
    	
    }
    
    public void iniciarBomba() {
    	moduloQuiz.initModQuiz();
    	moduloFios.initModFios();
    	moduloMorse.initModMorse();
    	moduloTesteMesa.init();
    	
    	try {
    		relogio.setTempo(Util.TEMPO_JOGO_SEG);
        	relogio.start();
		} catch (Exception e) {
			reiniciarBomba();
		}
    	
    }
    
    public void reiniciarBomba() {
    	moduloQuiz.initModQuiz();
    	moduloFios.initModFios();
    	moduloMorse.initModMorse();
    	moduloTesteMesa.init();
    	
    	relogio.setTempo(Util.TEMPO_JOGO_SEG);
    	relogio.resume();
    	
    }
    
    public void desativarBomba() {
    	if(moduloFios.isStatus() && moduloQuiz.isStatus() && moduloMorse.isStatus() && moduloTesteMesa.isStatus()) {
    		parar();
    		Sons.tocar("Sons/Bomb defused.wav");
    	}
    }
    
    public void parar() {
    	try {
    		relogio.suspend();
		} catch (Exception e) {
			
		}
    }
    
    public boolean explodir() {
    	if(Util.explodir) {
    		relogio.suspend();
    		Sons.tocar("Sons/bomba explosao.wav");
    		
    		return true;
    	}
    	
    	return false;
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
