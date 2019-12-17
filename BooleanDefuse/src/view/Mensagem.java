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
		Object[] options = { "Sim", "N�o" };
		return JOptionPane.showOptionDialog(null, mensagem, "Confirma��o", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	}
	
	public static void dicas(int modulo) {
		switch (modulo) {
			case 0:
				JOptionPane.showMessageDialog(null, "                                M�dulo fios\r\n" + 
						"\r\n" + 
						"Para desarmar este m�dulo voc� precisa cortar alguns\r\n" + 
						"fios espec�ficos.Para saber quais ter�o que ser cortados,\r\n" + 
						"diga ao seu parceir@ qual a posi��o de cada um deles e\r\n" + 
						"aguarde que ele resolvaas equa��es booleanas atreladas\r\n" + 
						"a eles e diga se deve ou n�o cort�-los.\r\n" + 
						"", "Dica", JOptionPane.QUESTION_MESSAGE);	
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "                                M�dulo Quiz\r\n" + 
						"\r\n" + 
						"Para desarmar este m�dulo basta dizer ao seu parceir@\r\n"
						+ "quais os\\n nomes que est�o em caixa alta. Ele dir�\r\n" + 
						"os operadores l�gicos erelacionais que est�o atrelados\r\n" + 
						"a eles. Por fim, substitua os nomes pelos respectivos\r\n" + 
						"operadores e resolva a equa��o, pressionando por fim o\r\n"
						+ "bot�o correspondente ao resultado.", "Dica", JOptionPane.QUESTION_MESSAGE);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "                     M�dulo Teste de Mesa\r\n" + 
						"\r\n" + 
						"Para desarmar este m�dulo basta dizer ao seu parceir@\r\n" + 
						"qual a letra grega que est� contida no display, al�m\r\n" + 
						"dos n�meros gravados abaixo. Como resposta ele lhe dir�\r\n" + 
						"um n�mero que dever� ser inserido no campo com o nome sa�da.\r\n" + 
						"", "Dica", JOptionPane.QUESTION_MESSAGE);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "                        M�dulo Morse\r\n" + 
						"\r\n" + 
						"Para desarmar este m�dulo basta dizer ao seu parceir@\r\n" + 
						"o c�digo morse que est� sendo mostrado no papel para \r\n" + 
						"que ele procure a tradu��o no manual. Cada linha \r\n" + 
						"corresponde a um dos campos de texto. Ap�s preencher \r\n" + 
						"os tr�s campos, no quarto deve ser colocado a resposta \r\n" + 
						"da equa��o formada (V ou F).\r\n" + 
						"", "Dica", JOptionPane.QUESTION_MESSAGE);
				break;
			default:
				break;
		}
	}
	
}
