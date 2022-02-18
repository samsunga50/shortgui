// used for ArrayList nodes
import java.util.ArrayList;

import java.util.Random;


public class Main {
    // n is used to store the number of nodes
    public static int n = 7;

    // start is the index of the starting node in the array nodes
    public static int start = 0;

    public static ArrayList<Node> nodes = new ArrayList<Node>();

    // takes an array of type double and returns the index of the smallest element
    public static int findMin(double[] distance){
        double min = Double.MAX_VALUE;

        int size = distance.length;
        int index = -1;

        for (int i = 0; i < size; i++){
            if (distance[i] < min){
                min = distance[i];
                index = i;
            }
        }

        return index;
    }


    public static void createNodes(){

        Random rand = new Random();

        // nodes are assigned random x, y coordinates
        for (int i = 0; i < n; i++) {
            nodes.add(i, new Node("" + i));
            nodes.get(i).setX(rand.nextInt(100, 1100));
            nodes.get(i).setY(rand.nextInt(100, 900));
        }


        // each node is connected to every other nodes (besides itself)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                if (i != j){
                    double distance  = nodes.get(i).calculateDistance(nodes.get(j));
                    nodes.get(i).addDestination(nodes.get(j), distance);
                    nodes.get(j).addDestination(nodes.get(i), distance);
                }
            }
        }

        // displays the edges
        for (Node n: nodes) {
            for (Node p: n.getAdjacentNodes().keySet()){
                System.out.println(n.getName() + " --> " + p.getName() + ": " + n.getAdjacentNodes().get(p));
            }
        }
    }


    public static void displayPath(){
        Dijkstra T = new Dijkstra();

        // stores the distance of each of the paths with different starting nodes
        double[] distance = new double[n];



        for (int i = 0; i < n; i++){

            //temporary variable to store shortest path of each node
            ArrayList<Integer> path = T.dijkstra(i);

            nodes.get(i).setShortestPath(path);

            //getting distance of last node in path, which is the distance of the path
            distance[i] = nodes.get(path.get(path.size() - 1)).getDistance();
        }

        System.out.println();
        for (int i = 0; i < n; i++){
            System.out.println(i + ": " + distance[i]);
        }

        // find the shortest path
        start = findMin(distance);

        System.out.println();
        System.out.println("Shortest path is " + nodes.get(start).getShortestPath() + " with distance: " + distance[start]);
    }
    
    public static void main(String[] args) {

        new MyFrame();
    }
}
