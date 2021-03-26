import java.util.*;

public class FlightNetwork {
   public static void main(String args[]){
      ArrayList<LinkedList<Node>> FlightMap = new ArrayList<LinkedList<Node>>();
      //  AlgorithmAforFlightNetwork();

      int[][] p = new int[5][5];
      p[0][1] = 50;
      p[1][0] = 50;
      p[1][2] = 60;
      p[2][1] = 60;
      p[2][3] = 20;
      p[3][2] = 20;
      p[3][4] = 70;
      p[4][3] = 70;
      p[4][0] = 100;
      p[0][4] = 100;
      USC TEST = new USC(5, p);
      TEST.userInput(0, 3);
      System.out.println();
      RandomMapGenerator map = new RandomMapGenerator(10000);
      System.out.println(map);
   } 

   public static void AlgorithmAforFlightNetwork(ArrayList<LinkedList<Node>> FlightMap, Node ini, Node fin){
      //yet to be filled
   }

   public static LinkedList<Node>[] RandomMapGenerator(int size){
      return null;
   }
   
}
