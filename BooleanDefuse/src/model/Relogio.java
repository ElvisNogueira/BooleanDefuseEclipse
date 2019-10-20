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
		} catch (IOException e) {
			e.printStackTrace();
		}
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
