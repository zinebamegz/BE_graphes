package org.insa.graphs.algorithm.shortestpath;

import java.util.List;
import org.insa.graphs.model.Node;
import org.insa.graphs.model.Point;
import org.insa.graphs.algorithm.AbstractInputData;

public class AStarAlgorithm extends DijkstraAlgorithm {
	
    public AStarAlgorithm(ShortestPathData data) {
        super(data);
    }
    
   protected Label[] InitialiseLabels() {
	   LabelStar ArrayLabels[] = new LabelStar[nbNodes] ;
	   List<Node> nodes = graph.getNodes();
	   
	   double Cost = 0;
	   int MaxSpeed =  data.getMaximumSpeed() ; 
	   Point Destination = data.getDestination().getPoint() ; 
	   for (Node node : nodes) {
		   ArrayLabels[node.getId()] = new LabelStar(node);
		   
		   // the cost is the distance between this point and the destination point, in meters
		   if(data.getMode() == AbstractInputData.Mode.LENGTH) {
			   Cost = node.getPoint().distanceTo(Destination);
			   
			   //or it's the time (ie Distance divided by speed) 
	       	} else {
	       		Cost = node.getPoint().distanceTo(Destination) / MaxSpeed; 
	       	}
      
		   ArrayLabels[node.getId()].setEstimatedCost(Cost);
	   }
	   
	   return ArrayLabels ; 
    }
   
}
