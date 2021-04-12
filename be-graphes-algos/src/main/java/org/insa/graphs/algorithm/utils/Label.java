package org.insa.graphs.algorithm.utils;

import org.insa.graphs.model.*;

public class Label implements Comparable<Label>{
   
    private Node current_sommet;

    private boolean marque;

    private float cost; 

    private Arc pere;

    public Label(Node current_sommet, float cost, Arc pere){
        this.current_sommet = current_sommet; 
        this.marque = false;
        this.cost = cost; 
        this.pere = pere;
    }

    public void setCost(float cost){
        this.cost = cost;
    }

    public float getCost(){
        return this.cost;
    }

    public void setMark(){
        this.marque = true;
    }

    @Override
    public int compareTo(Label other) {
        return Float.compare(this.cost,other.cost);
    }



}
