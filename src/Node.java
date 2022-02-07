import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {

    private String name;
    private LinkedList<Node> shortestPath = new LinkedList<>(); // can be removed
    private double distance = Integer.MAX_VALUE;
    private int previous = -2;
    private Map<Node, Double> adjacentNodes = new HashMap<>();

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

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(LinkedList<Node> shortestPath) {
        this.shortestPath = shortestPath;
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

    public double calculateDistance(Node A){
        return Math.pow((Math.pow(A.getX() - this.getX(), 2) + Math.pow(A.getY() - this.getY(), 2)), 0.5);
    }


}