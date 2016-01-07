/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesoimagenes;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author luisenriquezamudiocervantes
 */
public class Filtros {
    private BufferedImage imgTmp;
    private ArrayList<String> imgs;
    
    public Filtros(){
        imgs = new ArrayList<String>();
        cargaImagenes();
    }
    
    public BufferedImage rojo(BufferedImage img){
        Color c;        
        imgTmp = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        for( int i = 0; i < img.getWidth(); i++ ){
            for( int j = 0; j < img.getHeight(); j++ ){
                c = new Color(img.getRGB(i,j));
                imgTmp.setRGB(i,j,new Color(c.getRed(),0,0).getRGB());
            }
        }
        return imgTmp;
    }
    public BufferedImage verde(BufferedImage img){
        Color c;        
        imgTmp = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        for( int i = 0; i < img.getWidth(); i++ ){
            for( int j = 0; j < img.getHeight(); j++ ){
                c = new Color(img.getRGB(i,j));
                imgTmp.setRGB(i,j,new Color(0,c.getGreen(),0).getRGB());
            }
        }
        return imgTmp;
    }
    public BufferedImage azul(BufferedImage img){
        Color c;        
        imgTmp = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        for( int i = 0; i < img.getWidth(); i++ ){
            for( int j = 0; j < img.getHeight(); j++ ){
                c = new Color(img.getRGB(i,j));
                imgTmp.setRGB(i,j,new Color(0,0,c.getBlue()).getRGB());
            }
        }
        return imgTmp;
    }
    public BufferedImage grises(BufferedImage img){
        Color c;        
        imgTmp = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        for( int i = 0; i < img.getWidth(); i++ ){
            for( int j = 0; j < img.getHeight(); j++ ){
                c = new Color(img.getRGB(i,j));
                int p = (c.getBlue()+c.getGreen()+c.getRed())/3;
                imgTmp.setRGB(i,j,new Color(p,p,p).getRGB());
            }
        }
        return imgTmp;
    }
    public BufferedImage grisesFormula(BufferedImage img){
        Color c;        
        imgTmp = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        for( int i = 0; i < img.getWidth(); i++ ){
            for( int j = 0; j < img.getHeight(); j++ ){
                c = new Color(img.getRGB(i,j));
                int p = (int)(c.getBlue()*0.11+ c.getGreen()*0.59+c.getRed()*0.3);
                imgTmp.setRGB(i,j,new Color(p,p,p).getRGB());
            }
        }
        return imgTmp;
    }
    public BufferedImage negativo(BufferedImage img){
        Color c;        
        imgTmp = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        for( int i = 0; i < img.getWidth(); i++ ){
            for( int j = 0; j < img.getHeight(); j++ ){
                c = new Color(img.getRGB(i,j));
                imgTmp.setRGB(i,j,new Color(255-c.getRed(),255-c.getGreen(),255-c.getBlue()).getRGB());
            }
        }
        return imgTmp;
    }
    public BufferedImage altoContraste(BufferedImage img){
        Color c;        
        imgTmp = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        for( int i = 0; i < img.getWidth(); i++ ){
            for( int j = 0; j < img.getHeight(); j++ ){
                c = new Color(img.getRGB(i,j));
                int p = (c.getBlue()+c.getGreen()+c.getRed())/3;
                if(p > 127){
                    p = 255;
                }else{
                    p = 0;
                }
                imgTmp.setRGB(i,j,new Color(p,p,p).getRGB());
            }
        }
        return imgTmp;
    }
    public BufferedImage sepia(BufferedImage img){
        Color c;        
        imgTmp = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        for( int i = 0; i < img.getWidth(); i++ ){
            for( int j = 0; j < img.getHeight(); j++ ){
                c = new Color(img.getRGB(i,j));
                double r= Math.min(Math.max((c.getRed()*.393 + c.getGreen()*.769 + c.getBlue()*.189), 0), 255);
                double g= Math.min(Math.max((c.getRed()*.349 + c.getGreen()*.686 + c.getBlue()*.168), 0), 255);
                double b= Math.min(Math.max((c.getRed()*.272 + c.getGreen()*.534 + c.getBlue()*.131), 0), 255);
                imgTmp.setRGB(i,j,new Color((int)r,(int)g,(int)b).getRGB());
            }
        }
        return imgTmp;
    }
    public BufferedImage luzNegra(BufferedImage img){
        Color c;        
        imgTmp = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        int fxWeight = 2;
        for( int i = 0; i < img.getWidth(); i++ ){
            for( int j = 0; j < img.getHeight(); j++ ){
                c = new Color(img.getRGB(i,j));
                int l = (222 * c.getRed() + 707 * c.getGreen()+ 71 * c.getBlue())/1000;
                double r = Math.min(Math.max((Math.abs(c.getRed() - l) * fxWeight), 0), 255);
                double g = Math.min(Math.max((Math.abs(c.getGreen() - l) * fxWeight), 0), 255);
                double b = Math.min(Math.max((Math.abs(c.getBlue() - l) * fxWeight), 0), 255);
                imgTmp.setRGB(i,j,new Color((int)r,(int)g,(int)b).getRGB());
            }
        }
        return imgTmp;
    }
    public BufferedImage mosaico(BufferedImage img){
        Color c;        
        int ancho = 5;
        imgTmp = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        for( int x = 0; x < img.getWidth(); x += ancho ){
            for( int y = 0; y < img.getHeight(); y += ancho ){
                c = calculaPromedioRGB(subMatriz(img, x, y, ancho, ancho));
                for (int i = 0; i < ancho; i++) {
                    for (int j = 0; j < ancho; j++) {
                        if(x+i < img.getWidth() && y+j < img.getHeight() ){
                            imgTmp.setRGB(x+i,y+j,c.getRGB());
                        }
                    }
                }
            }
        }
        return imgTmp;
    }
    public void fotomosaico(BufferedImage img){
        Color c;        
        int ancho = 10;
        int ancho2 = 15;
        String tabla = "<!DOCTYPE html><html><body><table  border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >";
        for( int x = 0; x < img.getWidth(); x += ancho ){
            tabla += "<tr>";
            for( int y = 0; y < img.getHeight(); y += ancho2 ){
                c = calculaPromedioRGB(subMatriz(img, x, y, ancho, ancho2));
                int distanciaLineal = (65535 * c.getRed()) + (256 * c.getGreen()) + c.getBlue();
                String foto = buscaDiferenciaLineal(distanciaLineal);
                tabla += "<td><img src=\"imgs/"+foto+"\" style=\"width: 10px;height:15px\" ></td>";

            }
            tabla += "</tr>";
        }
        tabla += "</table></body></html>";
//        System.out.println(tabla);
        
        FileWriter fichero = null;
        PrintWriter pw;
        try {
            fichero = new FileWriter("fotomosaico.html");
            pw = new PrintWriter(fichero);
            pw.println(tabla);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    public String buscaDiferenciaLineal(int distancia){
        double delta = Double.MAX_VALUE;
        String i = "";
        for (String img : imgs) {
            String[] temp = img.substring(0, img.indexOf(".jpg")).split("-");
            int d = (65535 * Integer.parseInt(temp[0])) + (256 * Integer.parseInt(temp[1])) + Integer.parseInt(temp[2]);
            if(Math.abs(d-distancia) < delta){
                delta = Math.abs(d-distancia);
                i = img;
            }
        }
        return i;   
    }
    private void cargaImagenes(){
        File dir = new File("imgs");
        String[] ficheros = dir.list();
        for (String fichero : ficheros) {
            if (fichero.endsWith(".jpg")) {
                imgs.add(fichero);
            }
        }
    }
    
    private int[][] subMatriz(BufferedImage matrix,int x, int y, int w, int h){
        
        if(matrix.getWidth()-(x+w) < 0){
            w = w + (matrix.getWidth()-(x+w));
        }
        if(matrix.getHeight()-(y+h) < 0){
            h = h + (matrix.getHeight()-(y+h));    
        }
        
        int[][] subregion = new int[w][h];
                
        
        for(int i = 0; i < w ; i++) {
            for(int j = 0; j < h; j++) {
                subregion[i][j] = matrix.getRGB(x+i,y+j);
            }
        }
        
        return subregion;
    }
    private Color calculaPromedioRGB(int[][] matrix){
        Color c;      
        double r = 0;
        double g = 0;
        double b = 0;
        for( int x = 0; x < matrix.length; x++ ){
            for( int y = 0; y < matrix[0].length; y++){
                c = new Color(matrix[x][y]);
                r += c.getRed();
                g += c.getGreen();
                b += c.getBlue();
            }
        }
        
        r = r / (matrix.length*matrix[0].length);
        g = g / (matrix.length*matrix[0].length);
        b = b / (matrix.length*matrix[0].length);
        
        return new Color((int)r,(int)g,(int)b);
    }
    public BufferedImage att(BufferedImage img){
        return ATT.filtra(img);
    }
    public BufferedImage bordes(BufferedImage img){
 
        double[][] filter = {
            {0,  0,  0,  0,  0},
            {0,  0,  0,  0,  0},
            {-1, -1,  2,  0,  0},
            {-1, -1,  2,  0,  0},
            {0,  0,  0,  0,  0},
        };
       
        double factor = 1.0 ;
        double bias = 0.0; 
          
        return aplicaFiltroMatrizConvolucion(filter, factor, bias, img);
    }
    public BufferedImage sharpen(BufferedImage img){
 
        double[][] filter = {
            {1,  1,  1},
            {1, -7,  1},
            {1,  1,  1},
        };
       
        double factor = 1.0;
        double bias = 0.0; 
          
        return aplicaFiltroMatrizConvolucion(filter, factor, bias, img);
    }
    public BufferedImage emboss(BufferedImage img){
 
        double[][] filter = {
            {-1, -1,  0},
            {-1,  0,  1},
            {0,  1,  1},
        };
       
        double factor = 1.0;
        double bias = 128.0; 
          
        return aplicaFiltroMatrizConvolucion(filter, factor, bias, img);
    }
    public BufferedImage blur(BufferedImage img){
 
        double[][] filter = {
            {0.0, 0.2,  0.0},
            {0.2, 0.2,  0.2},
            {0.0, 0.2,  0.0},
        };
       
        double factor = 1.0;
        double bias = 0.0; 
          
        return aplicaFiltroMatrizConvolucion(filter, factor, bias, img);
    }
    public BufferedImage motionBlur(BufferedImage img){
 
        double[][] filter = {
            {1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1},
        };
       
        double factor = 1.0 / 9.0;
        double bias = 0.0; 
          
        return aplicaFiltroMatrizConvolucion(filter, factor, bias, img);
        
    }
    private BufferedImage aplicaFiltroMatrizConvolucion(double[][] filter, double factor, double bias, BufferedImage img){
          
        imgTmp = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        for( int x = 0; x < img.getWidth(); x++ ){
            for( int y = 0; y < img.getHeight(); y++ ){
                int r =0, g=0, b=0;

                for(int filterX = 0; filterX < filter.length; filterX++) 
                    for(int filterY = 0; filterY < filter.length; filterY++) { 
                    int imageX = (x - filter.length / 2 + filterX + img.getWidth()) % img.getWidth(); 
                    int imageY = (y - filter.length / 2 + filterY + img.getHeight()) % img.getHeight(); 
                    Color c = new Color(img.getRGB(imageX,imageY));
                    r += c.getRed() * filter[filterX][filterY]; 
                    g += c.getGreen() * filter[filterX][filterY]; 
                    b += c.getBlue() * filter[filterX][filterY]; 
                } 
                imgTmp.setRGB(x,y,new Color(Math.min(Math.max((int)(factor * r + bias), 0), 255),Math.min(Math.max((int)(factor * g + bias), 0), 255),Math.min(Math.max((int)(factor * b + bias), 0), 255)).getRGB());
            }
        }
        return imgTmp;
    }
}
