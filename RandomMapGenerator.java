import java.util.LinkedList;

public class RandomMapGenerator {
    LinkedList<Node>[] PathCostGraph;
    int size;


    public RandomMapGenerator(int size){
        //notice that this is merely a graph of costs, so we do not have to obey any kind of triangular inequality
        PathCostGraph = new LinkedList[size];
        for(int i = 0 ; i< size ; i++)//now we initialize an array of linkedlists
            PathCostGraph[i] = new LinkedList<Node>();
        for(int i = 0; i< size; i++){
            PathCostGraph[i].add(getRandomCostNode(i,80,0,0));
        }//so the head of each linkedlist represents a city, the rest illustrate the available path
        
    }

    public void formEdge(Node node1, Node node2){
        //notice that there is at MOST one undirect edge between two nodes
        //we will make sure that this holds using the following for loop
        for(Node i: PathCostGraph[node1.getIndex()])
            if(i.getIndex() == node2.getIndex())
                return;
        PathCostGraph[node1.getIndex()].add(grcS(node2.getIndex()));
        PathCostGraph[node2.getIndex()].add(grcS(node1.getIndex()));
    }

    public Node getRandomCostNode(int index, int range1, int range2, int range3){//we generate a random cost node
        return new Node(index,rwr(range1),rwr(range2),rwr(range3));
    }

    public Node grcS(int index){//simple version of getRandomCostNode
        int range = (int)(50 + Math.random()*100);
        return getRandomCostNode(index, range,0,0);
    }

    public double rwr(double range){//random number with a predefined range
        if(range == 0)
            return 0;
        else
            return range+ Math.random()*range;
    }

    public LinkedList<Node> getList(){
        return null;
    }
    
}
