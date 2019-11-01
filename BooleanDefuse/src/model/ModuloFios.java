/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import dao.FiosDao;
import view.Mensagem;

/**
 *
 * @author Elvis Nogueira
 */
public class ModuloFios {
    private boolean status;
    private Sprite ledStatus;
    private Fios[] fios;
    private Sprite[] sprites;
    
    public ModuloFios() {
    	fios = new Fios[3];
    	sprites = new Sprite[3];
    	
    	try {
			ledStatus = new Sprite("Imagens/LED STATUS.png", 0, 65, 22, 1, 2, 525, 170);
		} catch (IOException e) {
			Mensagem.mostrar("Erro ao carregar Sprite", Util.ERRRO);
		}
    	
    	initModFios();
    	
    }
    
    public void initModFios() {
    	sortearFios();
    	setarSprites(fios);
    	ledStatus.aparencia = 0;
    	status = false;
    }
    
    private void sortearFios() {
    	Random numAleatorio = new Random();
    	ArrayList<Fios> fiosXML = FiosDao.getAll();
    	ArrayList<Fios> fiosSelec = new ArrayList<Fios>();
    	
    	boolean igual = false;
    	int sorteado;
    	int i=0;
    	
    	fiosSelec.add(fiosXML.get(numAleatorio.nextInt(fiosXML.size())));
    	
    	while(i<2) {
    		sorteado = numAleatorio.nextInt(fiosXML.size());
    		for (Fios fios : fiosSelec) {
				if(fios.getCor().equals( fiosXML.get(sorteado).getCor()) && fios.getPosicao().equals(fiosXML.get(sorteado))) {
					igual = true;
				}
			}
    		if(!igual) {
    			fiosSelec.add(fiosXML.get(sorteado));
    		}
    		if(i==1 && !(fiosSelec.get(0).isResposta() || fiosSelec.get(1).isResposta() || fiosSelec.get(2).isResposta() )) {
    			
    			fiosSelec.remove(2);

    		}else {
    			i++;
    		}
    		
    	}
    	
    	fios[0] = fiosSelec.get(0);
    	fios[1] = fiosSelec.get(1);
    	fios[2] = fiosSelec.get(2);  	
    }
    
    private Sprite[] setarSprites(Fios[] vetorFios) {
    	int posX, posY;
    	Sprite[] spritesFios;
    	for(int i=0;i<3;i++) {
    		try {
				sprites [i] = new Sprite("Imagens/Fios v19.png", setarAparenciaSprite(vetorFios[i].getPosicao(), vetorFios[i].getCor()), 
						46, 133, 5, 9, posicaoXFios(i, vetorFios[i]), 235);
			} catch (IOException e) {
				Mensagem.mostrar("Erro ao carregar Sprite", Util.ERRRO);
			}
    	}
    	
    	return null;
    }
    
    private int posicaoXFios(int numFio, Fios fio) {
    	switch (numFio) {
			case 0:
				return nomeFio(fio.getPosicao());
			case 1:
				return nomeFio(fio.getPosicao())+110;
			case 2:
				return nomeFio(fio.getPosicao())+224;		
		}
    	
    	return 0;
    }
    
    private int nomeFio(String nome) {
    	if(nome.equals("1A"))
    		return 268;
    	else if(nome.equals("2A"))
    		return 280;
    	else if(nome.equals("3A"))
    		return 290;
    	else if(nome.equals("1B"))
    		return 280;
    	else if(nome.equals("2B"))
    		return 291;
    	else if(nome.equals("3B"))
    		return 302;
    	else if(nome.equals("1C"))
    		return 291;
    	else if(nome.equals("2C"))
    		return 302;
    	else if(nome.equals("3C"))
    		return 313;  	
    		

		return 0;
    	
    }
    
    private int setarAparenciaSprite(String nome, String cor) {
    	if(nome.equals("1A") || nome.equals("2B") || nome.equals("3C")) {
    		if(cor.equals("Vermelho")) {
    			return 0;
    		}else if(cor.equals("Amarelo")) {
    			return 3;
    		}else {
    			return 6;
    		}
    	}else if(nome.equals("2A") || nome.equals("3B")) {
    		if(cor.equals("Vermelho")) {
    			return 9;
    		}else if(cor.equals("Amarelo")) {
    			return 12;
    		}else {
    			return 15;
    		}
    	}else if(nome.equals("3A")){
    		if(cor.equals("Vermelho")) {
    			return 18;
    		}else if(cor.equals("Amarelo")) {
    			return 21;
    		}else {
    			return 24;
    		}
    	}else if(nome.equals("1B") || nome.equals("2C")) {
    		if(cor.equals("Vermelho")) {
    			return 27;
    		}else if(cor.equals("Amarelo")) {
    			return 30;
    		}else {
    			return 33;
    		}
    	}else if(nome.equals("1C")){
    		if(cor.equals("Vermelho")) {
    			return 36;
    		}else if(cor.equals("Amarelo")) {
    			return 39;
    		}else {
    			return 42;
    		}
    	}
		return 0;
    	
    }
    
    public boolean colisaoFios(int posXMouse,int posYMouse) {
    	for (int i = 0; i < fios.length; i++) {
    		if(colide(sprites[i], posXMouse, posYMouse)) {
    			if(sprites[i].aparencia%3==0) {
    				desmarcarFios();
    				sprites[i].aparencia++;
    				Sons.tocar("Sons/select.wav");
    				return true;    				
    			}
    		}
		}
		return false;   	
    	
    }
    
    public void cortarFios(int posXMouse,int posYMouse) {
    	for (int i = 0; i < fios.length; i++) {
    		if(colide(sprites[i], posXMouse, posYMouse)) {
    			if(sprites[i].aparencia%3 - 1==0) {
    				sprites[i].aparencia++;
    				Sons.tocar("Sons/alicate.wav");
    				if(!corrigirFiosCortados(i))
    					Util.explodir = true;
    				verificarStatus();
    				
    			}
    		}
		}
    }
    
    private void desmarcarFios() {
    	for (int i = 0; i < fios.length; i++) {
    		if(sprites[i].aparencia%3 - 1==0) {
    			sprites[i].aparencia--;
    		}
    	}
    }
    
    private boolean colide(Sprite sprite1, int mouseX, int mouseY) {
    	  Rectangle r1 = new Rectangle(sprite1.posX, sprite1.posY, sprite1.width, sprite1.height);
    	  Rectangle r2 = new Rectangle(mouseX, mouseY, 1, 1);
    	  
    	  if (r1.intersects(r2)) {
    	    return true;
    	  }
    	  
    	  return false;
    }
    
    private boolean verificarStatus() {
    	for (int i = 0; i < fios.length; i++) {
			if(fios[i].isResposta()) {
				if(sprites[i].aparencia%3 - 2 != 0) {
					return false;
				}
			}else {
				if(sprites[i].aparencia%3 - 2 == 0) {
					return false;
				}
			}
		}
    	if(ledStatus.aparencia==0) {
    		ledStatus.aparencia++;
    		Sons.tocar("Sons/acerto.wav");
    		status = true;
    	}
    	
		return true;
    }
    
    private boolean corrigirFiosCortados(int indice) {
    	if(!fios[indice].isResposta())
    		return false;
    	return true;
    }

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Sprite getLedStatus() {
		return ledStatus;
	}

	public Fios[] getFios() {
		return fios;
	}

	public Sprite[] getSprites() {
		return sprites;
	}
    
    
    
    
}
