package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.Util;
import model.VocabuloMorse;
import view.Mensagem;

public class VocabulosDao {
private static XStream xstream = new XStream(new DomDriver());
	
	public static  String gerarXml(List<VocabuloMorse> lista) {
		return xstream.toXML(lista);
	}
	
	public static void insert(ArrayList<VocabuloMorse> vocabulos, String nomeArq) {
		 try {
	            File arquivo = new File("XML/"+nomeArq+".xml");
	            PrintWriter escrever = new PrintWriter(arquivo);
	            escrever.write(xstream.toXML(vocabulos));
	            escrever.flush();
	            escrever.close();
	            
	        } catch (FileNotFoundException e) {
	           Mensagem.mostrar("Erro ao criar XML", Util.ERRRO);
	        }        
		
	}
	
	public static ArrayList<VocabuloMorse> getAll(String nomeArq){
		try {
            FileReader leitor = new FileReader("XML/"+nomeArq+".xml");
            
            return (ArrayList<VocabuloMorse>) xstream.fromXML(leitor);
        } catch (FileNotFoundException ex) {
            Mensagem.mostrar("Erro ao ler XML", Util.ERRRO);
        }
         
        return null;         
	}
}
