/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    }
    
    public Perguntas selecionarPergunta () {
    	Random random = new Random();
    	ArrayList<Perguntas> perguntas = PerguntasDao.getAll();
    	
    	return perguntas.get(random.nextInt(perguntas.size()));
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
