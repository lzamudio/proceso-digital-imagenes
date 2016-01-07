/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesoimagenes;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author luisenriquezamudiocervantes
 */
public class ProcesarImagenes {
    
    public static void main(String[] args){
        JOptionPane.showMessageDialog(null, "Se generó el archivo fotomosaico.html exitosamente ", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
//        ProcesarImagenes pros = new ProcesarImagenes();
//        File dir = new File("imgs");
//        String[] ficheros = dir.list();
//        for (String fichero : ficheros) {
//            if(fichero.endsWith(".jpg")){                
//                try {
//                    File f = new File("imgs/"+fichero);
//                    String nombre = pros.promedioRGB(ImageIO.read(f));
//                    if(!f.renameTo(new File("imgs/"+nombre))){
//                        System.out.println("Error: "+"imgs/"+fichero);
//                    }
//                } catch (IOException ex) {
////                    Logger.getLogger(ProcesarImagenes.class.getName()).log(Level.SEVERE, null, ex);
//                    System.out.println("Error");
//                }
//            }
//            
//        }
    }
    
    public String promedioRGB(BufferedImage img){
        Color c;        
        double r = 0;
        double g = 0;
        double b = 0;
        for( int i = 0; i < img.getWidth(); i++ ){
            for( int j = 0; j < img.getHeight(); j++ ){
                
                c = new Color(img.getRGB(i,j));
                r += c.getRed();
                g += c.getGreen();
                b += c.getBlue();
            }
        }
        
        r = (r / (img.getWidth()*img.getHeight()));
        g = (g / (img.getWidth()*img.getHeight()));
        b = (b / (img.getWidth()*img.getHeight()));
        
        return (int)r+"-"+(int)g+"-"+(int)b+".jpg" ;
    }
    
}
