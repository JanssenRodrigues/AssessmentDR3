/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA;

import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author Janssen
 */
public class GA {
    private static final int POP = 20;
    static int[] individuo = new int[6];
    static int[][] populacao = new int[30][6];
    static int[][] populacaoOrdanada = new int[30][6];
    
    static Random rnd = new Random();
    
    public static void gerarPopulacao(){
        System.out.println("POPULACAO INICIAL COM GENES: ");
        for(int i = 0; i < POP; i++){
            for(int k = 0; k < individuo.length; k++){
                if(rnd.nextDouble() < 0.5){
                    populacao[i][k] = 0;
                } else {
                    populacao[i][k] = 1;
                }       
                populacao[i] = individuo;
            }
//            System.out.print("Individuo " + i + " - ");
//            calcularAptidao(populacao[i]); //INDIVIDUO i DENTRO DE POPULACAO.
//            System.out.println(Arrays.toString(populacao[i]));
            System.out.print("INDIVIDUO " + i + " - ");
            System.out.println(Arrays.toString(populacao[i]));
            calcularAptidao(populacao[i]);
        }
    }
    
    public static void calcularAptidao(int[] individuo){
//        System.out.println(Arrays.toString(individuo));
        int aptidao = 0;
        for(int i = 0; i < individuo.length; i++){
            aptidao += individuo[i];
        }
//        System.out.println(Arrays.toString(individuo));
        System.out.println("Aptidao : " + aptidao);
        System.out.println("----------------");
    }
    
    public static void ordenarPopulacao(int[][] populacao){
        System.out.println("ORDENANDO POPULACAO");
        for(int i = 0; i <  populacao.length; i++) {
            System.out.println("individuo " + i);
            System.out.println(Arrays.toString(populacao[i]));
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        gerarPopulacao();
//        ordenarPopulacao(populacao);
        for(int i = 0; i <  populacao.length; i++) {
            System.out.print("individuo " + i + " - ");
            System.out.println(Arrays.toString(populacao[i]));
        }
    }
   
    
}
