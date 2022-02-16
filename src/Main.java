import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static int n = 7;
    public static int start = 0;
    public static ArrayList<Node> nodes = new ArrayList<Node>();
    public static ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
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

        for (int i = 0; i < n; i++) {
            nodes.add(i, new Node("" + i));
            nodes.get(i).setX(rand.nextInt(50, 1000));
            nodes.get(i).setY(rand.nextInt(200, 800));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                if (i != j){
                    if (rand.nextInt(0, 3) == 1)
                    {
                        // to limit number of edges
                        if (nodes.get(i).getAdjacentNodes().size() < 3 && nodes.get(j).getAdjacentNodes().size() < 3){
                            double distance  = nodes.get(i).calculateDistance(nodes.get(j));
                            // graph[i][j] = distance;
                            // graph[j][i] = distance;
                            nodes.get(i).addDestination(nodes.get(j), distance);
                            nodes.get(j).addDestination(nodes.get(i), distance);
                        }
                    }
                }
            }
        }

        for (Node n: nodes) {
            for (Node p: n.getAdjacentNodes().keySet()){
                System.out.println(n.getName() + " --> " + p.getName() + ": " + n.getAdjacentNodes().get(p));
            }
        }
    }

    public static void displayPath(){
        Dijkstra T = new Dijkstra();

        double[] distance = new double[n];

        for (int i = 0; i < n; i++){
            path.add(T.dijkstra(i));
            distance[i] = nodes.get(path.get(i).get(path.get(i).size() - 1)).getDistance();
        }

        for (int i = 0; i < n; i++){
            System.out.println(i + ": " + distance[i]);
        }

        start = findMin(distance);

        System.out.println("Shortest path is " + path.get(start));


    }
    
    public static void main(String[] args) {
        new MyFrame();




        /*
        double graph[][] = new double[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                graph[i][j] = 0;
            }
        }

         */







        /*
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + ", ");
            }
            System.out.println();
        }

         */


        /*
        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);
        */



        /*
        Graph graph = new Graph();

        for (int i = 0; i < n; i++) {
            graph.addNode(nodes.get(i));
        }


         */
        //System.out.println(graph.toString());

        // graph = Dijkstra.calculateShortestPathFromSource(graph, nodes.get(0));


        //System.out.println(graph.getNodes().toString());
    }
}
