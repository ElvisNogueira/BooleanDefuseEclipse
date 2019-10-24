/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;

/**
 *
 * @author Elvis Nogueira
 */
public class Relogio extends Thread{
    private int dezenaMinuto,unidadeMinuto,dezenaSegundo,unidadeSegundo;
    private Sprite dezMinutoSprite,unidMinutoSprite,dezSegundoSprite,unidSegundoSprite,doisPontos;
    private int tempo;
    
    public Relogio() {
    	try {
			dezMinutoSprite = new Sprite("Imagens/numeros.png", 0, 24, 28, 10, 2, 664, 360);
			unidMinutoSprite = new Sprite("Imagens/numeros.png", 10, 24, 28, 10, 2, 694, 360);
			doisPontos = new Sprite("Imagens/numeros.png", 1, 24, 28, 10, 2, 728, 368);
			dezSegundoSprite = new Sprite("Imagens/numeros.png", 0, 24, 28, 10, 2, 762, 360);
			unidSegundoSprite = new Sprite("Imagens/numeros.png", 0, 24, 28, 10, 2, 796, 360);
			tempo = 300;
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public Relogio(int tempo) {
    	this.tempo = tempo;
    }
    
    
    @Override
    public void run() {
    	int[] relogio;
    	while (true) {
    		try {
    			relogio = calcularHora(tempo);
    			mudarSprites(relogio);
    			Thread.sleep(1000);
    			tempo--;
    			if(tempo>250)
    				Sons.tocar("Sons/bip v1.wav");
    			else
    				Sons.tocar("Sons/bip v2.wav");
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
		}
    }
    
    
    public int[] calcularHora(int tempo) {
    	int auxTempo = tempo;
    	int dezMin = tempo/600;
    	auxTempo = dezMin*600;
    	int unidMin = (tempo - auxTempo)/60;
    	auxTempo += unidMin*60;
    	int dezSeg = (tempo - auxTempo)/10;
    	auxTempo += dezSeg*10; 
    	int unidSeg = (tempo-auxTempo)/1;
    	
    	int[] relogio = {dezMin,unidMin, dezSeg, unidSeg};
    	
    	return relogio;
    }
    
    public void mudarSprites(int[] hora) {
    	dezMinutoSprite.aparencia = setarAparencia(hora [0]);
    	unidMinutoSprite.aparencia = setarAparencia(hora [1]);
    	dezSegundoSprite.aparencia = setarAparencia(hora [2]);
    	unidSegundoSprite.aparencia = setarAparencia(hora [3]);
    }
    
    public int setarAparencia(int numero) {
    	switch (numero) {
		case 0:
			return 0;
		case 1:			
			return 2;
		case 2:
			return 4;
		case 3:
			return 6;
		case 4:
			return 8;
		case 5:
			return 10;
		case 6:
			return 12;
		case 7:
			return 14;
		case 8:
			return 16;
		case 9:
			return 18;
		}
    	
    	return 0;
    	
    }

	public int getDezenaMinuto() {
		return dezenaMinuto;
	}

	public void setDezenaMinuto(int dezenaMinuto) {
		this.dezenaMinuto = dezenaMinuto;
	}

	public int getUnidadeMinuto() {
		return unidadeMinuto;
	}

	public void setUnidadeMinuto(int unidadeMinuto) {
		this.unidadeMinuto = unidadeMinuto;
	}

	public int getDezenaSegundo() {
		return dezenaSegundo;
	}

	public void setDezenaSegundo(int dezenaSegundo) {
		this.dezenaSegundo = dezenaSegundo;
	}

	public int getUnidadeSegundo() {
		return unidadeSegundo;
	}

	public void setUnidadeSegundo(int unidadeSegundo) {
		this.unidadeSegundo = unidadeSegundo;
	}

	public Sprite getDezMinutoSprite() {
		return dezMinutoSprite;
	}

	public void setDezMinutoSprite(Sprite dezMinutoSprite) {
		this.dezMinutoSprite = dezMinutoSprite;
	}

	public Sprite getUnidMinutoSprite() {
		return unidMinutoSprite;
	}

	public void setUnidMinutoSprite(Sprite unidMinutoSprite) {
		this.unidMinutoSprite = unidMinutoSprite;
	}

	public Sprite getDezSegundoSprite() {
		return dezSegundoSprite;
	}

	public void setDezSegundoSprite(Sprite dezSegundoSprite) {
		this.dezSegundoSprite = dezSegundoSprite;
	}

	public Sprite getUnidSegundoSprite() {
		return unidSegundoSprite;
	}

	public void setUnidSegundoSprite(Sprite unidSegundoSprite) {
		this.unidSegundoSprite = unidSegundoSprite;
	}

	public Sprite getDoisPontos() {
		return doisPontos;
	}

	public void setDoisPontos(Sprite doisPontos) {
		this.doisPontos = doisPontos;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
    
    
}
