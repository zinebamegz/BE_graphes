package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Node;


public class LabelStar extends Label implements Comparable<Label> {


	private double EstimatedCost;
	
	public LabelStar (Node CurrentNode) {
		super(CurrentNode);
		this.EstimatedCost = Double.POSITIVE_INFINITY;
	}
	 @Override
	public double getTotalCost() {
		return this.EstimatedCost + this.getCost();
	}
	  public double getEstimatedCost() {
	        return this.EstimatedCost;
	    }
	  public void setEstimatedCost(double EstimatedCost) {
	        this.EstimatedCost = EstimatedCost;
	    } 
    public int compareTo(LabelStar label) {
    	return Double.compare(this.getEstimatedCost(), label.getTotalCost() - label.getCost());
	}
}


