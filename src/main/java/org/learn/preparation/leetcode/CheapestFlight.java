package org.learn.preparation.leetcode;

import java.util.*;

public class CheapestFlight {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        // src -- [connected node, cost]
        Map<Integer, List<int[]>> paths = new HashMap<>();

        for (int i = 0; i < flights.length; i++) {

            int startingNode = flights[i][0];
            int destNode = flights[i][1];

            if (!paths.containsKey(startingNode))
                paths.put(startingNode, new ArrayList<>());
            paths.get(startingNode).add(new int[]{destNode, flights[i][2]});
        }

        LinkedList<int[]> queue = new LinkedList<>();

        // node, no of stops distance , total distance as of now ,
        queue.add(new int[]{src, 0, 0});

        boolean[] visited = new boolean[n];
        visited[src] = true;
        int cheapestCost = Integer.MAX_VALUE;
        visited[src] = true;
        while (!queue.isEmpty()) {

            int[] lastStop = queue.removeFirst();
            if (lastStop[1] > K) {
                break;
            }
            List<int[]> nextNodes = paths.get(lastStop[0]);

            if (nextNodes != null) {
                for (int[] node : nextNodes) {
                    // 0: dist , 1: cost
                    int next = node[0];
                    int cost = node[1];
                    //if (!visited[next]) {
                        visited[next] = true;
                        //dest?
                        if (next == dst) {
                            if (lastStop[2] + cost < cheapestCost) {
                                cheapestCost = lastStop[2] + cost;
                            }
                        } else {
                            int[] nextNode = new int[]{next, lastStop[1] + 1, lastStop[2] + cost};
                            queue.add(nextNode);
                        }
                   // }//
                }

            }
        }
        return cheapestCost;

    }

    public static void main(String[] args) {
        int[][] flights = {
                {0, 1, 100}, {1, 2, 100}, {0, 2, 500}
        };
        System.out.println(new CheapestFlight().findCheapestPrice(3, flights, 0, 2, 1));
    }
}
