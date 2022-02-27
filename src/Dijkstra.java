import java.util.ArrayList;

public class Dijkstra {
    // Finding the minimum distance
    private static int findMinDistance(ArrayList<Integer> adjacents) {
        double minimumDistance = Double.MAX_VALUE;
        int min = -1;
        for (int i = 0; i < adjacents.size(); i++) {
            if (Main.nodes.get(adjacents.get(i)).getDistance() <= minimumDistance){
                    minimumDistance = Main.nodes.get(adjacents.get(i)).getDistance();
                    min = i;
            }
        }

        // returns index of node with min total distance
        return min;
    }


    public static ArrayList<Integer> dijkstra(int start) {
        int count = Main.nodes.size();

        ArrayList<Integer> path = new ArrayList<>();

        // stores the nodes which have been traversed
        ArrayList<Integer> adjacents = new ArrayList<>();


        Main.nodes.get(start).setDistance(0);
        path.add(start);

        do {
            // for each node adjacent to start
            for (Node n: Main.nodes.get(start).getAdjacentNodes().keySet()) {

                //index of adjacent node in ArrayList nodes
                int j = Integer.valueOf(n.getName());

                //if node is not already part of path
                if (!path.contains(j)) {
                    double distance = Main.nodes.get(start).calculateDistance(Main.nodes.get(j));
                    double totalDistance = distance + Main.nodes.get(start).getDistance();

                    Main.nodes.get(j).setPrevious(start);
                    Main.nodes.get(j).setDistance(totalDistance);

                    if (!adjacents.contains(j))
                    {
                        adjacents.add(j);
                    }


                } // if loop adjacent
            }


            int destinationpath = findMinDistance(adjacents);
            if (destinationpath != -1){

                path.add(adjacents.get(destinationpath));
                start = adjacents.get(destinationpath);

                adjacents.remove(destinationpath);
                Main.nodes.get(start).setPrevious(-1);
            }

        } while (!adjacents.isEmpty()); // if adjacents is empty, all nodes are part of the path

        return path;
    }

}

