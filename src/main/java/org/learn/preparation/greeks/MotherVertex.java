package org.learn.preparation.greeks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MotherVertex {

    public Integer[] findMotherVertices(int[][] graph) {

        int n = graph.length;
        Set<Integer> mothers = new HashSet<>();

        //for each vertex:
        for (int currVertex = 0; currVertex < n; currVertex++) {
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(currVertex);

            boolean[] visitedVertices = new boolean[n];
            visitedVertices[currVertex] = true;
            while (queue.size() != 0) {
                int curr = queue.remove(0);
                if (mothers.contains(curr)) {
                    mothers.add(currVertex);
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (graph[curr][k] == 1 && !visitedVertices[k]) {
                        queue.add(k);
                        visitedVertices[k] = true;
                    }
                }
            }
            boolean isMother = true;
            for (int i = 0; i < n; i++) {
                if (!visitedVertices[i]) {
                    isMother = false;
                    break;
                }
            }
            if (isMother)
                mothers.add(currVertex);

        }
        return mothers.toArray(new Integer[mothers.size()]);
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };

//        int[][] graph = {
//                {0, 1, 1, 0, 0, 0, 0},
//                {0, 0, 0, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0},
//                {0, 1, 0, 0, 0, 0, 0},
//                {0, 0, 1, 0, 0, 0, 1},
//                {1, 0, 0, 0, 1, 0, 0}
//        };
        MotherVertex motherVertex = new MotherVertex();
        System.out.println("Mothers are :" + Arrays.toString(motherVertex.findMotherVertices(graph)));
    }


}
