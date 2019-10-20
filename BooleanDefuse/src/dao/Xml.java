package dao;

import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.Teste;

public class Xml {
	private static XStream xstream = new XStream(new DomDriver());
	
	
	
	public static  String gerarXml(List<Teste> lista) {
		return xstream.toXML(lista);
	}
	
	
	
}
