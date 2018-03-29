/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA;

import java.util.Arrays;

/**
 *
 * @author WIBSA-PC144
 */
public class Individuo {
   int[] genes = new int[6];
   int aptidao = 0;

//    public Individuo() {
//        for(int i = 0; i < genes.length; i++){
//            genes[i] = 0;
//        }
//        aptidao = 0;
//    }

    public int[] getGenes() {
        return genes;
    }

    public void setGenes(int[] genes) {
        this.genes = genes;
    }

    public int getAptidao() {
        return aptidao;
    }

    public void setAptidao(int aptidao) {
        this.aptidao = aptidao;
    }
    
    public String toString() {
        return ("Genes: " + Arrays.toString(this.getGenes())+
                    " - Aptidao: " + this.getAptidao());
   }
}
