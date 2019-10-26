/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import dao.PerguntasDao;

/**
 *
 * @author Elvis Nogueira
 */
public class ModuloQuiz {
    private Sprite ledStatus;
    private boolean status;
    private Perguntas pergunta;
    
    public ModuloQuiz() {
    	pergunta = selecionarPergunta();
    	try {
			ledStatus = new Sprite("Imagens/LED STATUS.png", 0, 65, 22, 1, 2, 785, 170);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public Perguntas selecionarPergunta () {
    	Random random = new Random();
    	ArrayList<Perguntas> perguntas = PerguntasDao.getAll();
    	
    	return perguntas.get(random.nextInt(perguntas.size()));
    }
    
    public boolean corrigirResposta(boolean respRecebida) {
    	if(respRecebida==pergunta.getResposta())
    		return true;
    	return false;
    }

	public Sprite getLedStatus() {
		return ledStatus;
	}

	public boolean isStatus() {
		return status;
	}

	public Perguntas getPergunta() {
		return pergunta;
	}
    
    
    
}
