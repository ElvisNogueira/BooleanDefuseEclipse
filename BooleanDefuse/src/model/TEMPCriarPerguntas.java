package model;

import java.util.ArrayList;

public class TEMPCriarPerguntas {
	private static ArrayList<Perguntas> perguntas = new ArrayList<Perguntas>();
	
	public static ArrayList<Perguntas> criarPerguntas() {
		perguntas.add(new Perguntas("true LOVELACE (false VAUGHAN true)", true));
		perguntas.add(new Perguntas("(true LOVELACE false) VAUGHAN (JOBS false)", true));
		perguntas.add(new Perguntas("((false LOVELACE true) VAUGHAN false) CURIE  false", true));
		perguntas.add(new Perguntas("(false LOVELACE true) TESLA  (false CURIE  false)", false));
		perguntas.add(new Perguntas("JOBS (((20/5) EINSTEIN 4) LOVELACE (4 TESLA 4))", true));
		perguntas.add(new Perguntas("((false VAUGHAN true) LOVELACE (4 NEWTON 3))", false));
		perguntas.add(new Perguntas("JOBS ((20/5+9) NEWTON 4)) LOVELACE (4 TESLA 4)", false));
		perguntas.add(new Perguntas("(false VAUGHAN true) LOVELACE ((4*5) CURIE 35)", false));
		perguntas.add(new Perguntas("JOBS ((20/5+9) EINSTEIN 4)) TESLA (4 CURIE 4)", true));
		perguntas.add(new Perguntas("JOBS (((20/5) EINSTEIN 4) CURIE (false LOVELACE true))", false));
		
		return perguntas;
	}
}
