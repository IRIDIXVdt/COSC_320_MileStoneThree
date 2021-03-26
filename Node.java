

public class Node implements Comparable<Node>{
	public int nodeIndex;
	public int cost;
	public String path;
	
	public Node(int nodeIndex, int cost, String path) {
		this.nodeIndex = nodeIndex;
		this.cost = cost;
		this.path = path;
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