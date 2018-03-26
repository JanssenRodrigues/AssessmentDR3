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
public class GA extends Individuo{
    private static final int POP = 3;    
    static Individuo[] populacao = new Individuo[6];
    static Individuo[] populacaoOrdenada = new Individuo[6];
    
    static Random rnd = new Random();
    
    public static void gerarPopulacao(){
        System.out.println("POPULACAO INICIAL COM GENES: ");
        
        for(int i = 0; i < POP; i++){
            Individuo individuo = new Individuo();
            populacao[i] = individuo;
//            int[] individuo = new int[6];
            for(int k = 0; k < individuo.getGenes().length; k++){
                if(rnd.nextDouble() < 0.5){
                    populacao[i].genes[k] = 0;
                } else {
                    populacao[i].genes[k] = 1;
                }       
                populacao[i] = individuo;
            }
//            System.out.print("Individuo " + i + " - ");
//            calcularAptidao(populacao[i]); //INDIVIDUO i DENTRO DE POPULACAO.
//            System.out.println(Arrays.toString(populacao[i]));
            System.out.print("INDIVIDUO " + i + " - ");
            System.out.println(Arrays.toString(populacao[i].getGenes()));
            calcularAptidao(populacao[i]);
        }
    }
    
    public static void calcularAptidao(Individuo individuo){
//        System.out.println(Arrays.toString(individuo));
        int aptidao = 0;
        for(int i = 0; i < individuo.getGenes().length; i++){
            aptidao += individuo.genes[i];
        }
        individuo.setAptidao(aptidao);
//        System.out.println(Arrays.toString(individuo));
        
        System.out.println("Aptidao : " + aptidao);
        System.out.println("----------------");
    }
    
    public static void ordenarPopulacao(Individuo[] populacao){
        
        System.out.println("ORDENANDO POPULACAO");
        for(int i = 6; i > 0; i--) {
//            System.out.println(i);
//            System.out.println(populacao[i].aptidao);
            for(int k = 0; k < populacao.length; k++) {
//                System.out.println(populacao[k].getAptidao());
                if(populacao[k].getAptidao() == i){
                    populacaoOrdenada[k] = populacao[k];
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        gerarPopulacao();
//        ordenarPopulacao(populacao);
//        for(int i = 0; i <  populacao.length; i++) {
//            System.out.print("individuo " + i + " - ");
//            System.out.println(Arrays.toString(populacao[i]));
//        }
        ordenarPopulacao(populacao);
    }
   
    
}
