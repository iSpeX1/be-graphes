package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.algorithm.utils.*;
import org.insa.graphs.algorithm.AbstractSolution.Status;
import org.insa.graphs.model.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class DijkstraAlgorithm extends ShortestPathAlgorithm {

    public DijkstraAlgorithm(ShortestPathData data) {
        super(data);
    }

    @Override
    protected ShortestPathSolution doRun() {
        final ShortestPathData data = getInputData();
        ShortestPathSolution solution = null;

        Graph graph = data.getGraph();
        Node origin = data.getOrigin();
        Node destination = data.getDestination();
        
        //On parcourt le graphe et on assigne un Label à chaque noeud
        HashMap<Node, Label> etiquettes = new HashMap<Node, Label>();
        for (Node n : graph.getNodes()) {
            etiquettes.put(n, createLabel(n, Float.POSITIVE_INFINITY , null, data));
        }
        
        //Initialisation du tas binaire 
        BinaryHeap<Label> tas = new BinaryHeap<Label>();
        
        //Insertion de l'origine
        etiquettes.get(origin).setCost(0);
        tas.insert(etiquettes.get(origin));
        notifyOriginProcessed(origin);

        boolean end = false ; 

        while(!tas.isEmpty() && !end){
            Label label = tas.findMin();
            tas.remove(label);
            label.setMark();
            notifyNodeMarked(label.getNode());

            //Si on est arrivé à bon port, on arrête
            if (label.getNode() == destination){
                end = true; 
                notifyDestinationReached(destination);
                continue;
            }

            //On parcourt les successeurs 
            for (Arc arc : label.getNode().getSuccessors()){

                //Si on ne peut pas empreinter l'arc, on change de chemin
                if (!data.isAllowed(arc)) {
                    continue;
                }

                //On récupère le label du successeur
                Node node = arc.getDestination();
                notifyNodeReached(node);

                Label labelo = etiquettes.get(node);
                
                if(!labelo.isMarked()){
                    float oldCost = labelo.getCost();
                    float newCost = (float) (label.getCost() + data.getCost(arc));

                    if (newCost < oldCost){
                        labelo.setCost(newCost);
                        tas.insert(labelo);
                        labelo.setFather(arc);
                    }
                }
            }
        }
        
        // On test si la destination a ou non un prédécesseur

        Label dest = etiquettes.get(destination);
        
        if (dest.getFather() == null) {  //Le chemin est impossible
            solution = new ShortestPathSolution(data, Status.INFEASIBLE);
        } else { //On crée la liste à partir des pères
            ArrayList<Arc> arcs = new ArrayList<Arc>();
            Arc arc = dest.getFather();

            while (arc != null) {
                arcs.add(arc);
                arc = etiquettes.get(arc.getOrigin()).getFather();
            }

            // On inverse la liste car elle est à l'envers
            Collections.reverse(arcs);

            // On renvoie la solution
            solution = new ShortestPathSolution(data, Status.OPTIMAL, new Path(graph, arcs));
        }
        return solution;
    }

    protected Label createLabel(Node node, float cost, Arc pere, ShortestPathData data){
        return new Label(node, Float.POSITIVE_INFINITY, null);
    }

}