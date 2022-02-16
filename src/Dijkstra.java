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


        path.add(start);

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

