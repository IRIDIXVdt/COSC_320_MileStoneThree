

public class Node implements Comparable<Node>{
	public int nodeIndex;
	public double monetaryCost;
	public double waitTimeCost;
	public double flightTimeCost;
	public String path;
	public double x1,x2,x3;//xi should be the coefficients for each costs 
	
	public Node(int nodeIndex, double monetaryCost, double waitTimeCost, double flightTimeCost, String path){
		this.nodeIndex = nodeIndex;
		this.monetaryCost = monetaryCost;
		this.waitTimeCost = waitTimeCost;
		this.flightTimeCost = flightTimeCost;
		this.path = path;
	}

	public Node(int nodeIndex, double monetaryCost, String path) {
		this(nodeIndex,monetaryCost,0,0,path);
	}

	public int compareTo(Node o) {
		if(this.cost < o.cost) {
			return -1;
		} else{
			return 1;
		} 
	}
	
	public boolean equals(Object obj) {
		Node x = (Node) obj;
		if(x.nodeIndex == this.nodeIndex && x.cost == this.cost) {
			return true;
		}
		return false;
	}
}