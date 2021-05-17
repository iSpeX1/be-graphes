package org.insa.graphs.algorithm.utils;

import org.insa.graphs.model.*;

public class Label implements Comparable<Label>{
   
    private Node node;

    private boolean marque;

    private float cost; 

    private Arc pere;

    public Label(Node node, float cost, Arc pere){
        this.node = node; 
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

    public float getTotalCost(){
        return this.cost;
    }

    public void setMark(){
        this.marque = true;
    }

    public boolean isMarked(){
        return this.marque;
    }

    @Override
    public int compareTo(Label other) {
        int resultat;
        if(this.getTotalCost() < other.getTotalCost()) {
            resultat = -1;
        }else if (this.getTotalCost() == other.getTotalCost()) {
            resultat = 0;
        } else {
            resultat = 1;
        }
        return resultat;
    }

    public Node getNode(){
        return this.node;
    }

    public void setFather(Arc pere){
        this.pere = pere;
    }

    public Arc getFather(){
        return this.pere;
    }

}
