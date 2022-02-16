import java.util.ArrayList;

public class Dijkstra {
    // Finding the minimum distance
    private static int findMinDistance(ArrayList<Integer> adjacents) {
        double minimumDistance = Integer.MAX_VALUE;
        int min = -1;
        for (int i = 0; i < adjacents.size(); i++) {
            if (Main.nodes.get(adjacents.get(i)).getDistance() <= minimumDistance){
                    minimumDistance = Main.nodes.get(adjacents.get(i)).getDistance();
                    min = i;
                    System.out.println("min: " + min);
            }
        }

        // returns index of node with min total distance
        return min;

    }


    public static ArrayList<Integer> dijkstra(int start) {
        int count = Main.nodes.size();

        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<Integer> adjacents = new ArrayList<>();
        Main.nodes.get(start).setDistance(0);


        for (int i = 0; i < count; i++) {

            int neighbours = Main.nodes.get(start).getAdjacentNodes().size();
            for (int j = 0; j < count; j++) {
                if (Main.nodes.get(start).getAdjacentNodes().containsKey(Main.nodes.get(j)) && !path.contains(j)) {

                    double distance = Main.nodes.get(start).calculateDistance(Main.nodes.get(j));
                    double totalDistance = distance + Main.nodes.get(start).getDistance();

                    /*
                    if (totalDistance < Main.nodes.get(j).getDistance()) {
                        Main.nodes.get(j).setPrevious(start);
                        Main.nodes.get(j).setDistance(totalDistance);
                        System.out.println("dist: " + totalDistance + " for " + j);
                    }
                     */

                    Main.nodes.get(j).setPrevious(start);
                    Main.nodes.get(j).setDistance(totalDistance);
                    System.out.println("dist: " + totalDistance + " for " + j);

                    if (!adjacents.contains(j))
                    {
                        adjacents.add(j);
                    }
                    System.out.println(adjacents);

                } // if loop adjacent
            }


            int destinationpath = findMinDistance(adjacents);
            if (destinationpath != -1){
                // if shortest destination has a different starting node than start

                /*
                if (Main.nodes.get(adjacents.get(destinationpath)).getPrevious() != start){
                    start = Main.nodes.get(adjacents.get(destinationpath)).getPrevious();
                }
                 */

                path.add(start);
                path.add(adjacents.get(destinationpath));
                start = adjacents.get(destinationpath);

                adjacents.remove(destinationpath);
                Main.nodes.get(start).setPrevious(-1);

                System.out.println("path: " + path);

                System.out.println("start" + start);

                // Main.nodes.get(adjacents.get(destinationpath)).setPrevious(-1);
            }
        }
        return path;
    }

}
    /*
    public static ArrayList<Integer> dijkstra(double[][] graph, int source) {
        int count = graph.length;
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] visitedVertex = new boolean[count];
        double[] distance = new double[count];
        for (int i = 0; i < count; i++) {
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }

        // Distance of self loop is zero
        distance[source] = 0;
        path.add(source);

        for (int i = 0; i < count; i++) {

            // Update the distance between neighbouring vertex and source vertex
            int u = findMinDistance(distance, visitedVertex);
            if (u != -1) {
                visitedVertex[u] = true;
                path.add(u);

                // Update all the neighbouring vertex distances
                for (int v = 0; v < count; v++) {
                    if (!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) {
                        distance[v] = distance[u] + graph[u][v];
                        path.add(u);
                        path.add(v);
                    }
                }
            }


        }
        for (int i = 0; i < distance.length; i++) {
            System.out.println(String.format("Distance from %s to %s is %s", source, i, distance[i]));
        }
        return path;
    }

    // Finding the minimum distance
    private static int findMinDistance(double[] distance, boolean[] visitedVertex) {
        double minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visitedVertex[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

     */

