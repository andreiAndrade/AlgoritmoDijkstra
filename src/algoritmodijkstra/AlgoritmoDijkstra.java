/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmodijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Andrei Andrade
 */
public class AlgoritmoDijkstra {

    public static final List<Vertice> GRAFO = criarGrafo();
    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) {
        int cont;
        Scanner sc;
        int indexOrigem;
        int indexDestino;
        
        System.out.println("Digite o vertice de origem:");
        cont = 1;
        for (Vertice v : GRAFO) {
            System.out.println(cont++ + ") " + v.toString());
        }
        System.out.print("Numero: ");
        sc = new Scanner(System.in);
        indexOrigem = sc.nextInt() - 1;
        
        System.out.println("");
        
        System.out.println("Digite o vertice de destino:");
        cont = 1;
        for (Vertice v : GRAFO) {
            System.out.println(cont++ + ") "  + v.toString());
        }
        System.out.print("Numero: ");
        sc = new Scanner(System.in);
        indexDestino = sc.nextInt() - 1;
        
        calcularRota(GRAFO.get(indexOrigem), GRAFO.get(indexDestino));
    }
    
    private static List<Vertice> criarGrafo(){
        List<Vertice> grafo = new ArrayList();
        
        Vertice vA = new Vertice("a");
        Vertice vB = new Vertice("b");
        Vertice vC = new Vertice("c");
        Vertice vD = new Vertice("d");
        Vertice vE = new Vertice("e");
        
        vA.addArestas(new Aresta(2, vB), new Aresta(4, vC));
        vB.addArestas(new Aresta(2, vA), new Aresta(3, vC), new Aresta(11, vD));
        vC.addArestas(new Aresta(4, vA), new Aresta(1, vD), new Aresta(3, vB));
        vD.addArestas(new Aresta(2, vE), new Aresta(1, vC), new Aresta(11, vB));
        vE.addArestas(new Aresta(1, vD));
        
        grafo.addAll(Arrays.asList(vA, vB, vC, vD, vE));
        
        return grafo;
    }
    
    private static void calcularRota(Vertice origem, Vertice destino) {
        List<String> rota = new ArrayList();
        Vertice atual;
        
        setVerticeRaiz(origem);
        dijkstra();
        
        atual = destino;
        do {
            rota.add(atual.getNome());
            atual = atual.getPrecedente();
        } while(!atual.equals(origem));
        
        rota.add(origem.getNome());
        
        Collections.reverse(rota);
        
        for (String s : rota) {
            System.out.print(s);
            if(!s.equals(destino.getNome())) {
                System.out.print(" -> ");
            }
        }
    }
    
    private static void setVerticeRaiz(Vertice vertice) {
        vertice.setEstimativa(0);
        vertice.addArestas(new Aresta(0, vertice));
    }
    
    private static void dijkstra() {     
        for(int i = 0; i < GRAFO.size(); i++){
            Vertice v = encontraMenor();
            if (v != null){
                for (Aresta a : v.getArestas()) {
                    if (a.getDestino().getEstimativa() >= v.getEstimativa() + a.getCusto()){
                        a.getDestino().setEstimativa(v.getEstimativa() + a.getCusto());
                        a.getDestino().setPrecedente(v);
                    }
                }
                v.setAberto(true);
            }
        }
        /*for (Vertice v : GRAFO) {
            System.out.println("Vertice: " + v.getNome());
            System.out.println("Estimativa: " + v.getEstimativa());
            System.out.println("Precedente: " + v.getPrecedente().getNome());
        }*/
    }
    
    private static Vertice encontraMenor() {
        Collections.sort(GRAFO);
        
        for (Vertice v : GRAFO) {
            if (!v.isAberto())
                return v;
        }
        
        return null;
    }
    
}