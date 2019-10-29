/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;

import javax.swing.ImageIcon;

import view.Mensagem;

/**
 *
 * @author Elvis Nogueira
 */
public class ModuloTesteMesa {
    private Sprite simbolo,ledStatus;
    private boolean status;
    private String[] entradas;
    private String saida;
    
    public ModuloTesteMesa() {
    	try {
			simbolo = new Sprite("Imagens/simbCod.png", 0, 194, 111, 1, 3, 895, 225);
		} catch (IOException e) {
			Mensagem.mostrar("Erro ao carregar Sprite", Util.ERRRO);
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

	public Sprite getSimbolo() {
		return simbolo;
	}

	public Sprite getLedStatus() {
		return ledStatus;
	}

	public boolean isStatus() {
		return status;
	}

	public String[] getEntradas() {
		return entradas;
	}

	public String getSaida() {
		return saida;
	}
    
    
    
    
}
