package model;

import java.util.ArrayList;
import java.util.List;

public class TEMPCriarFios {
	
	private static ArrayList<Fios> listaFios = new ArrayList<Fios>();
	
	public static ArrayList<Fios> criarFios(){
		listaFios.add(new Fios("1A", "Amarelo", false));
		listaFios.add(new Fios("1B", "Amarelo", true));
		listaFios.add(new Fios("1C", "Amarelo", false));
		listaFios.add(new Fios("2A", "Amarelo", false));
		listaFios.add(new Fios("2B", "Amarelo", true));
		listaFios.add(new Fios("2C", "Amarelo", false));
		listaFios.add(new Fios("3A", "Amarelo", true));
		listaFios.add(new Fios("3B", "Amarelo", true));
		listaFios.add(new Fios("3C", "Amarelo", true));
		
		listaFios.add(new Fios("1A", "Verde", true));
		listaFios.add(new Fios("1B", "Verde", true));
		listaFios.add(new Fios("1C", "Verde", false));
		listaFios.add(new Fios("2A", "Verde", false));
		listaFios.add(new Fios("2B", "Verde", true));
		listaFios.add(new Fios("2C", "Verde", true));
		listaFios.add(new Fios("3A", "Verde", false));
		listaFios.add(new Fios("3B", "Verde", true));
		listaFios.add(new Fios("3C", "Verde", false));
		
		listaFios.add(new Fios("1A", "Vermelho", true));
		listaFios.add(new Fios("1B", "Vermelho", true));
		listaFios.add(new Fios("1C", "Vermelho", true));
		listaFios.add(new Fios("2A", "Vermelho", false));
		listaFios.add(new Fios("2B", "Vermelho", false));
		listaFios.add(new Fios("2C", "Vermelho", true));
		listaFios.add(new Fios("3A", "Vermelho", false));
		listaFios.add(new Fios("3B", "Vermelho", false));
		listaFios.add(new Fios("3C", "Vermelho", false));
	
		return listaFios;
	}

}
