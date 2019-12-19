/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;

import view.Mensagem;

/**
 *
 * @author Elvis Nogueira
 */
public class ModuloTesteMesa {
	private Sprite simbolo,ledStatus, ajuda;
	private boolean status;
	private int[] entradas;
	private String saida;

	public ModuloTesteMesa() {
		entradas = new int[3];
		try {
			ledStatus = new Sprite("Imagens/LED STATUS.png", 0, 65, 22, 1, 2, 1045, 170);
			ajuda = new Sprite("Imagens/icone ajuda sprite.png", 0, 34, 30, 1, 3, 885, 165);
		} catch (IOException e) {
			Mensagem.mostrar("Erro ao carregar Sprite! Verifique se o arquivo  do caminho \"Imagens/LED STATUS.png\" est� no seu computado!", Util.ERRRO);
		}
		
		try {
			simbolo = new Sprite("Imagens/simbCod.png", 0, 194, 111, 1, 3, 895, 225);
		} catch (IOException e) {
			Mensagem.mostrar("Erro ao carregar Sprite! Verifique se o arquivo  do caminho \"Imagens/simbCod.png\" est� no seu computado!", Util.ERRRO);
		}

		init();
	}

	public void init() {
		setarCod();
		status = false;
		ledStatus.aparencia = 0;
	}

	public boolean corrigir(String resposta) {
		if(!status) {
			try {
				switch (ledStatus.aparencia) {
				case 0:
					if(codTriangulo(entradas[0], entradas[1], entradas[2]) == Integer.parseInt(resposta)) {
						ledStatus.aparencia = 1;
						Sons.tocar("Sons/acerto.wav");
						return true;
					}
				case 1:
					if(codComp(entradas[0], entradas[1], entradas[2]) == Integer.parseInt(resposta)) {
						ledStatus.aparencia = 1;
						Sons.tocar("Sons/acerto.wav");
						return true;
					}	
				case 2:
					if(codCalc(entradas[0], entradas[1], entradas[2]) == Integer.parseInt(resposta)) {
						ledStatus.aparencia = 1;
						Sons.tocar("Sons/acerto.wav");
						return true;
					}	
				default:
					return false;
				}

			} catch (NumberFormatException e) {
				
			}
		} 	
		return false;
	}

	public void setarCod() {
		Random random = new Random();

		simbolo.aparencia = random.nextInt(3);
		for (int i = 0; i < entradas.length; i++) {
			entradas[i]=random.nextInt(8)+1;
		}
	}


	public int codTriangulo(int par1, int par2, int par3) {
		int a,b,c;

		a = par1;
		b = par2;
		c = par3;

		if((a < b+c) && (b<a+c) && (c < a+b)) {
			if((a == b) || (b == c))
				return 1;
			else if((a == b) || (b == c) || (a == c))
				return 2;
			else
				return 3; 
		}    	

		return 0;
	}

	public int codComp(int par1, int par2, int par3) {
		int a,b,c,s;

		s = 0;
		a = par1;
		b = par2;
		c = par3;

		if((a != b) && (c > a)) {
			if(a%2==0) {
				for(int i=0;i<c; i++) {
					s+=3;
				}

				return s;
			}else {
				for(int i=0;i<c; i++) {
					s+=2;
				}
			}

		}else {
			do {
				a++;
			}while(a<b);
			s = a;
			return s;
		}

		return 0;
	}

	public int codCalc(int par1, int par2, int par3) {
		int a,b,c,s;

		s = 0;
		a = par1;
		b = par2;
		c = par3;

		if((a > 2) && (b < 7) && (c%2 == 1)) {
			s = (a+2)*(b-2);
		}else if((a >= 2) || (c <= 1)) {
			s = (a+b)/c*(c+a);
		}else {
			s = (a + b)%c;
		}

		return s;
	}
	
	 public boolean colisaoAjuda(int posXMouse,int posYMouse) {
	    	if(colide(ajuda, posXMouse, posYMouse+30)) {
				ajuda.aparencia=1;
				return true;
			}else {
				ajuda.aparencia=0;
			}
	    	return false;
	    }
	    
	    private boolean colide(Sprite sprite1, int mouseX, int mouseY) {
	    	  Rectangle r1 = new Rectangle(sprite1.posX, sprite1.posY, sprite1.width, sprite1.height);
	    	  Rectangle r2 = new Rectangle(mouseX, mouseY, 1, 1);
	    	  
	    	  if (r1.intersects(r2)) {
	    	    return true;
	    	  }
	    	  
	    	  return false;
	    }

	public Sprite getSimbolo() {
		return simbolo;
	}

	public Sprite getLedStatus() {
		return ledStatus;
	}

	public boolean isStatus() {
		return status;
	}

	public int[] getEntradas() {
		return entradas;
	}

	public String getSaida() {
		return saida;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Sprite getAjuda() {
		return ajuda;
	}


	

}
