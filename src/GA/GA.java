/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA;

import java.util.ArrayList;
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
    static ArrayList<Individuo> populacaoOrdenada = new ArrayList<Individuo>();
    
    static Random rnd = new Random();
    
    public static void gerarPopulacao(){
        System.out.println("POPULACAO INICIAL COM GENES: ");
        
        for(int i = 0; i < POP; i++){
            Individuo individuo = new Individuo();
            populacao[i] = individuo;
            for(int k = 0; k < individuo.getGenes().length; k++){
                if(rnd.nextDouble() < 0.5){
                    populacao[i].genes[k] = 0;
                } else {
                    populacao[i].genes[k] = 1;
                }       
                populacao[i] = individuo;
            }
            System.out.print("INDIVIDUO " + i + " - ");
            System.out.println(Arrays.toString(populacao[i].getGenes()));
            calcularAptidao(populacao[i]);
        }
    }
    
    public static void calcularAptidao(Individuo individuo){
        int aptidao = 0;
        for(int i = 0; i < individuo.getGenes().length; i++){
            aptidao += individuo.genes[i];
        }
        individuo.setAptidao(aptidao);
        
        System.out.println("Aptidao : " + aptidao);
        System.out.println("----------------");
    }
    
    public static void ordenarPopulacao(Individuo[] populacao){        
        System.out.println("ORDENANDO POPULACAO");     
        for(int i = populacao.length - 1; i >= 0; i--) {
            for(int k = 0; k < populacao.length - 1; k++) {
                if(populacao[k] == null) {
                    System.out.println("Ignorando Individuo nulo...");
                } else if(populacao[k].aptidao == i) {
                    populacaoOrdenada.add(populacao[k]);
                }                   
            }
        }
        imprimirPopulacaoOrdenada(populacaoOrdenada);
    }
    
    public static void imprimirPopulacaoOrdenada(ArrayList<Individuo> populacaoOrdenada) {
        for(int i = 0; i < populacaoOrdenada.size(); i++){
            System.out.println(populacaoOrdenada.get(i).toString());
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        gerarPopulacao();
        ordenarPopulacao(populacao);
    }
   
    
}
