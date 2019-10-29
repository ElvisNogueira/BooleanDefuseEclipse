/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import view.Mensagem;

/**
 *
 * @author Elvis Nogueira
 */
public class Util {
    public static final int ATIVADA=1, DESATIVADA=0, EXPLODIR=2;
    public static final int ALTURA=768, LARGURA=1366;
    public static final int ERRRO = 0, SUCESSO = 1, INFO = 2;
    public static final int TEMPO_JOGO_SEG = 300;
    public static Font arial = new Font("Arial", Font.BOLD, 10);
    public static Font gabriola = new Font("Gabriola", Font.BOLD, 10);
    public static Color azulBic = new Color(25,78,146);
    public static final int FPS = 15;
    
    public static Font getFont( String nomeFonte, int tamanho ){  
        Font font = null;  
        try{
        	font = Font.createFont(Font.TRUETYPE_FONT, new File("Fontes/"+nomeFonte+".ttf"));
        }
        catch(IOException|FontFormatException e){
             Mensagem.mostrar("Erro ao carregar fonte!", Util.ERRRO);
        }
            font = font.deriveFont(Font.PLAIN, tamanho);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
            return font;
    }  
    
    
}
