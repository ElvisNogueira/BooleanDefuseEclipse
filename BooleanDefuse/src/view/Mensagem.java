package view;

import javax.swing.JOptionPane;

import model.Util;

public class Mensagem {
	public static void mostrar(String mensagem, int tipo) {
		switch (tipo) {
		case Util.ERRRO:
			JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);			
			break;
			
		case Util.SUCESSO:
			JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.WARNING_MESSAGE);			
			break;
		case Util.INFO:
			JOptionPane.showMessageDialog(null, mensagem, "Info", JOptionPane.INFORMATION_MESSAGE);			
			break;
			
		}
	}
	
	public static int mostrarPergunta (String mensagem) {
		Object[] options = { "Sim", "Não" };
		return JOptionPane.showOptionDialog(null, mensagem, "Confirmação", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	}
}
