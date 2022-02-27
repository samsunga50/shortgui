import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Node {

    private String name;

    // distance set to "infinity"
    private double distance = Double.MAX_VALUE;

    private int previous = -2;
    
    private Map<Node, Double> adjacentNodes = new HashMap<>();


    private ArrayList<Integer> shortestPath = new ArrayList<>();


    // x and y coordinates
    private int x;
    private int y;


    public Node(String name) {
        this.name = name;
    }

    public void addDestination(Node destination, double distance) {
        adjacentNodes.put(destination, distance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Node, Double> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<Node, Double> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getPrevious() {
        return previous;
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }

    public ArrayList<Integer> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(ArrayList<Integer> shortestPath) {
        this.shortestPath = shortestPath;
    }

    // calculates distance between this node and node A
    public double calculateDistance(Node A){
        return Math.pow((Math.pow(A.getX() - this.getX(), 2) + Math.pow(A.getY() - this.getY(), 2)), 0.5);
    }
}