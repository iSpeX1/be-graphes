package org.insa.graphs.algorithm.utils;

import org.insa.graphs.model.*;
import org.insa.graphs.algorithm.shortestpath.*;
import org.insa.graphs.algorithm.AbstractInputData;

public class LabelStar extends Label implements Comparable<Label> {
    
    private float realCost;
	
    public LabelStar(Node node, float cost, Arc pere, ShortestPathData data) {
        super(node, cost, pere);
        float vitesse = (data.getGraph().getGraphInformation().getMaximumSpeed() * 1000) / 3600;
        float distanceDirecte = (float)Point.distance(node.getPoint(), data.getDestination().getPoint());
        if (data.getMode() == AbstractInputData.Mode.LENGTH) {
        	this.realCost = distanceDirecte;
        } else {
        	this.realCost = distanceDirecte / vitesse;
        }
    }
    
    @Override
    public float getTotalCost() {
 	   return this.getCost() + this.realCost;
    }

}
