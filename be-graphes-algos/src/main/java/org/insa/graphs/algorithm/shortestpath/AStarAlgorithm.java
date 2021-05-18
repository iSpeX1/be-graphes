package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.algorithm.utils.*;
import org.insa.graphs.model.*;

public class AStarAlgorithm extends DijkstraAlgorithm {

    public AStarAlgorithm(ShortestPathData data) {
        super(data);
    }

    @Override
    protected Label createLabel(Node node, float cost, Arc pere, ShortestPathData data) {
    	return new LabelStar(node, cost, pere, data);
    }
}
