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
import view.Mensagem;

/**
 *
 * @author Elvis Nogueira
 */
public class ModuloQuiz {
    private Sprite ledStatus;
    private boolean status;
    private Perguntas pergunta;
    
    public ModuloQuiz() {
    	
    	try {
			ledStatus = new Sprite("Imagens/LED STATUS.png", 0, 65, 22, 1, 2, 785, 170);
		} catch (IOException e) {
			Mensagem.mostrar("Erro ao carregar Sprite! Verifique se o arquivo  do caminho \"Imagens/LED STATUS.png\" está no seu computado!", Util.ERRRO);
		}
    	
    	initModQuiz();
    }
    
    public void initModQuiz() {
    	pergunta = selecionarPergunta();
    	status = false;
    	ledStatus.aparencia = 0;
    }
    
    public Perguntas selecionarPergunta () {
    	Random random = new Random();
    	ArrayList<Perguntas> perguntas = PerguntasDao.getAll();
    	
    	return perguntas.get(random.nextInt(perguntas.size()));
    }
    
    public boolean corrigirResposta(boolean respRecebida) {
    	if(respRecebida==pergunta.getResposta()) {
    		status = true;
    		return true;
    	}
    		
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

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setPergunta(Perguntas pergunta) {
		this.pergunta = pergunta;
	}
    
    
    
}
