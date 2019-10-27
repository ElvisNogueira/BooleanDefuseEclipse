/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import dao.FiosDao;

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
    	sortearFios();
    	setarSprites(fios);
    	
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
    	
    	System.err.println(fiosSelec.get(0).getPosicao() +" "+ fiosSelec.get(1).getPosicao()+" "+fiosSelec.get(2).getPosicao() );
    	
    	
    	
    }
    
    private Sprite[] setarSprites(Fios[] vetorFios) {
    	int posX, posY;
    	Sprite[] spritesFios;
    	for(int i=0;i<3;i++) {
    		try {
				sprites [i] = new Sprite("Imagens/Fios v19.png", setarAparenciaSprite(vetorFios[i].getPosicao(), vetorFios[i].getCor()), 
						46, 133, 5, 9, posicaoXFios(i, vetorFios[i]), 235);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
