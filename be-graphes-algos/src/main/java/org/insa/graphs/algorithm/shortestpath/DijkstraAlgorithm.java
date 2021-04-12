package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.algorithm.utils.*;
import org.insa.graphs.model.*;

import java.util.HashMap;

public class DijkstraAlgorithm extends ShortestPathAlgorithm {
    
    public DijkstraAlgorithm(ShortestPathData data) {
        super(data);
    }

    @Override
    protected ShortestPathSolution doRun() {
        final ShortestPathData data = getInputData();
        ShortestPathSolution solution = null;

        //On parcourt le graph et on assigne un Label à chaque noeud
        HashMap<Node, Label> etiquettes = new HashMap<Node, Label>();
        for (Node n : data.getGraph().getNodes()) {
            etiquettes.put(n, new Label(n, Float.POSITIVE_INFINITY , null));
        }
        
        //Initialisation du tas binaire 
        BinaryHeap<Label> tas = new BinaryHeap<Label>();
        //Insertion de l'origine
        etiquettes.get(data.getOrigin()).setCost(0);
        tas.insert(etiquettes.get(data.getOrigin()));

        //Label le plus intéressant
        Label small = null;
        // Node de destination
        Node dest = data.getDestination();


        return solution;
    }

}
