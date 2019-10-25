/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    	fios = sortearFios();
    	
    }
    
    private Fios[] sortearFios() {
    	Random numAleatorio = new Random();
    	ArrayList<Fios> fiosXML = FiosDao.getAll();
    	fios[0]=fiosXML.get(numAleatorio.nextInt(fiosXML.size()));
    	int i = 0;
    	int sorteado;
    	boolean flag = true;
    	while(i<3) {
    		sorteado = numAleatorio.nextInt(fiosXML.size());
    		if(fios.length==0) {
    			fios[0]=fiosXML.get(sorteado);
    			i++;
    		}else {
    			for (Fios fio : fios) {
					if(fio==fiosXML.get(sorteado))
						flag = false;
				}
    			if(flag) {
    				fios[i]=fiosXML.get(sorteado);
    				i++;
    			}else
    				flag = true;
    		}
    	}
    	
    	return fios;
    }
    
    private Sprite[] setarSprites(Fios[] vetorFios) {
    	
    	
    	return null;
    }
    
}
