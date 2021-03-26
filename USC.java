

import java.util.*;

	 
public class USC{
	
	private PriorityQueue<Node> frontier = new PriorityQueue<>();
	private int ver;//vertex numbers
	private int[][] map;//flight map
	
	public USC() {
		
	}
	
	public USC(int ver, int[][] map) { //load map
		this.ver = ver;
		this.map = map;
	}

	public List<Node> search(int initialState, int finalState){
		List<Node> results = new ArrayList<>();
		for(int i = 0; i < ver; i++) { //initial frontier
			if(map[initialState][i]>0) {
				Node x = new Node(i, map[initialState][i], initialState+"->"+i);
				frontier.add(x);
			}
		}
		System.out.println("initial frontier: "); //test
		frontier.forEach((a)->System.out.println("(node,cost): (" + a.nodeIndex + "," + a.getCost() + ")")); //test
		while(true) {
			Node branch = frontier.poll(); 
			if(branch.nodeIndex == finalState) {
				results.add(branch);
				Node newNode = frontier.peek();
					while(newNode != null && newNode.nodeIndex == finalState && newNode.getCost() == branch.getCost()) {
						results.add(frontier.poll());
						newNode = frontier.peek();
					}
				return results;
			}
		System.out.println("branch to continue: ("+ branch.nodeIndex+","+branch.getCost() + ")" + "\n"); //test
		updateFrontier(branch);	
		}
	}
		
		
	public void updateFrontier(Node branch) {
		for(int i = 0; i < ver; i++) {
			if(map[branch.nodeIndex][i] > 0) {
				Node x = new Node (i, branch.getCost() + map[branch.nodeIndex][i], branch.path + " -> " + i);
				frontier.add(x);
			}
		}
		System.out.println("New Branches: "); //test
		frontier.forEach((a)->System.out.println("(node,cost:) ("+a.nodeIndex+","+a.getCost() + ")")); //test
	}
	
	public void userInput(int s, int e) {
		List<Node> results = this.search(s, e);
		for(Node result : results) {
			System.out.println("Total Cost: " + result.getCost() + "\n" + "Total Path: "+ result.path);
		}
	}

}

