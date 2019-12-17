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

import dao.PerguntasDao;
import view.Mensagem;

/**
 *
 * @author Elvis Nogueira
 */
public class ModuloQuiz {
    private Sprite ledStatus, ajuda;
    private boolean status;
    private Perguntas pergunta;
    
    public ModuloQuiz() {
    	
    	try {
			ledStatus = new Sprite("Imagens/LED STATUS.png", 0, 65, 22, 1, 2, 785, 170);
			ajuda = new Sprite("Imagens/icone ajuda sprite.png", 0, 34, 30, 1, 3, 629, 165);
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
    
    public boolean colisaoAjuda(int posXMouse,int posYMouse) {
    	if(colide(ajuda, posXMouse, posYMouse+30)) {
			ajuda.aparencia=1;
			Sons.tocar("Sons/select.wav");
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

	public Sprite getAjuda() {
		return ajuda;
	}
    
    
    
}
