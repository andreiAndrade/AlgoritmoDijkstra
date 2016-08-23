/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmodijkstra;

/**
 *
 * @author Andrei Andrade
 */
public class Aresta {
    private int custo;
    private Vertice destino;
    
    public Aresta(int custo, Vertice destino) {
        this.custo = custo;
        this.destino = destino;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }
}
