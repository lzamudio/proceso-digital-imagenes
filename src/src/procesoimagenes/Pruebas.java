/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesoimagenes;

/**
 *
 * @author luisenriquezamudiocervantes
 */
public class Pruebas {
    
    public static void main(String[] args){
        int[][] matrix = new int [200][354];
        int e = 1;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = e++;
            }
        }
        
        
        int x = 0;
        int y = 352;
        int w = 8;
        int h = 8;
        
        
        if(matrix.length-(x+w) < 0){
            w = w + (matrix.length-(x+w));
        }
        if(matrix[0].length-(y+h) < 0){
            h = h + (matrix[0].length-(y+h));    
        }
        
        int[][] subregion = new int[w][h];
                
        
        for(int i = 0; i < w ; i++) {
            for(int j = 0; j < h; j++) {
                subregion[i][j] = matrix[x+i][y+j];
            }
        }
        
        for(int i = 0; i < subregion.length; i++) {
            for (int j = 0; j < subregion[0].length; j++) {
                System.out.print("-"+subregion[i][j]+"-");
            }
            System.out.println("");
        }
        
    }
    
}
