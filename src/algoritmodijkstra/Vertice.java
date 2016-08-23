/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmodijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Andrei Andrade
 */
public class Vertice implements Comparable<Vertice>{
    private Vertice precedente;
    private int estimativa;
    private String nome;
    private List<Aresta> arestas;
    private boolean aberto;
    
    public Vertice(String nome){
        this.nome = nome;
        this.estimativa = 1000;
        this.aberto = false;
    }

    public Vertice getPrecedente() {
        return precedente;
    }

    public void setPrecedente(Vertice precedente) {
        this.precedente = precedente;
    }

    public int getEstimativa() {
        return estimativa;
    }

    public void setEstimativa(int estimativa) {
        this.estimativa = estimativa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(List<Aresta> arestas) {
        this.arestas = arestas;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }
    
    public void addArestas(Aresta... arestas) {
        if (this.arestas == null)
            this.arestas = new ArrayList();
        this.arestas.addAll(Arrays.asList(arestas));
    }

    @Override
    public int compareTo(Vertice o) {
        if (this.estimativa <= o.getEstimativa())
            return -1;
        else
            return 1;
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
    
    public boolean equals(Vertice v) {
        return this.nome.equals(v.getNome());
    }
    
}
