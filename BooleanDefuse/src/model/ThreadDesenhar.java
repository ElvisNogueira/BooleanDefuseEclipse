package model;

import view.Tela;

public class ThreadDesenhar extends Thread{
	Tela tela;
	
	public ThreadDesenhar(Tela tela){
		this.tela=tela;
	}
	
	public void run(){
		while(true){
			try {
				Thread.sleep(1000/30);
			}catch (InterruptedException e) {e.printStackTrace();}
				Gameloop.desenhar(tela);
			
		}
	}
}
