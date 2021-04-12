package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.algorithm.utils.Label;
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
        // TODO:

        HashMap<Node, Label> Etiquette = new HashMap<Node, Label>();

        //On recupere la taille du graphe

        //Pour initiqliser le grqphe et associer un label q chaque noeud 
        //on vq parcourir l'ensemble du graph et faire un hashmap put(noeud,Label)
        

        return solution;
    }

}
