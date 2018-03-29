/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA;

import static GA.GA.populacaoOrdenada;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Janssen
 */
public class GA extends Individuo{
    private static final int POP = 20;    
    private static final int GERACAO = 10;    
    static Individuo[] populacao = new Individuo[20];
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
    
    
    
    public static void selecionar(ArrayList<Individuo> populacaoOrdenada){
        System.out.println(populacaoOrdenada.size());
        Individuo novoIndividuo1 = new Individuo();
        Individuo novoIndividuo2 = new Individuo();
        for(int i = 0; i < POP - 1; i += 2){
//            System.out.println(i);
            int[] genesIndividuo1 = Arrays.copyOfRange(populacaoOrdenada.get(i).genes, 0, 3);
            int[] genesIndividuo2 = Arrays.copyOfRange(populacaoOrdenada.get(i+1).genes, 0, 3);
            
            int[] novosGenesIndividuo1 = combine(genesIndividuo2, Arrays.copyOfRange(populacaoOrdenada.get(i).genes, 3, 6));
            int[] novosGenesIndividuo2 = combine(genesIndividuo1, Arrays.copyOfRange(populacaoOrdenada.get(i+1).genes, 3, 6));
            
            novoIndividuo1.setGenes(novosGenesIndividuo1);
            novoIndividuo2.setGenes(novosGenesIndividuo2);
//            System.out.println("novos genes - " + Arrays.toString(novosGenesIndividuo1));
            populacaoOrdenada.add(novoIndividuo1);
            populacaoOrdenada.add(novoIndividuo2);
        }
        
        imprimirPopulacaoOrdenada(populacaoOrdenada);
        ordenarPopulacao(populacaoOrdenada);
    }
    
    public static int[] combine(int[] a, int[] b){
        int length = a.length + b.length;
        int[] result = new int[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        gerarPopulacao();
        ordenarPopulacao(populacao);
        selecionar(populacaoOrdenada);
        
        
    }
   
    
}
