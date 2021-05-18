package org.insa.graphs.algorithm.utils;

import org.insa.graphs.model.*;
import org.insa.graphs.algorithm.shortestpath.*;

import javax.management.RuntimeErrorException;

import org.insa.graphs.algorithm.AbstractInputData;

public class LabelStar extends Label {
    
    private float realCost;
	
    public LabelStar(Node node, float cost, Arc pere, ShortestPathData data) {
        super(node, cost, pere);
        
        float speed = Math.max(data.getMaximumSpeed(), data.getGraph().getGraphInformation().getMaximumSpeed()) / (3600/1000);
        float distanceDirecte = (float)Point.distance(node.getPoint(), data.getDestination().getPoint());
        
        if (data.getMode() == AbstractInputData.Mode.LENGTH) {
        	this.realCost = distanceDirecte;
        } else {
        	this.realCost = distanceDirecte / speed;
        }
    }
    
    @Override
    public float getTotalCost() {
 	   return this.getCost() + this.realCost;
    }

}
