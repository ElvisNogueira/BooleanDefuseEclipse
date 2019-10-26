/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Elvis Nogueira
 */
public class Util {
    public static final int ATIVADA=1, DESATIVADA=0, EXPLODIR=2;
    public static final int ALTURA=768, LARGURA=1366;
    public static final int ERRRO = 0, SUCESSO = 1, INFO = 2;
    public static Font arial = new Font("Arial", Font.BOLD, 10);
    public static final int FPS = 15;
    
    public static Font getFonte( String nomeFonte ){  
        Font font = null;  
        try{
        	font = Font.createFont(Font.TRUETYPE_FONT, new File("Fontes/"+nomeFonte+".ttf"));
        }
        catch(IOException|FontFormatException e){
             System.out.println("Merda " + e);
        }
            font = font.deriveFont(Font.PLAIN, 40);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
            return font;
    }  
    
    
}
