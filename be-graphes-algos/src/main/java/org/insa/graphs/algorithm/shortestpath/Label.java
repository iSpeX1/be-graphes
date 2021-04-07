package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Arc;



public class Label {
   
    private int current_sommet;

    private boolean marque;

    private int cost; 

    private Arc pere;

    public Label(int Current_Sommet, boolean Marque, int Cost, Arc Pere){
        this.current_sommet = Current_Sommet; 
        this.marque = Marque;
        this.cost = Cost; 
        this.pere = Pere;
    }

    public int getCost(){
        return this.cost;
    }

}
