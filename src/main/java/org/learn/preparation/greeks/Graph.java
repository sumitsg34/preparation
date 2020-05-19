package org.learn.preparation.greeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
 */
public class Graph {

    //parameters
    static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean vis[], int nov) {
        // add your code here
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (queue.size() != 0) {
            int curr = queue.remove(0);
            ArrayList<Integer> adjcentNodes = list.get(curr);
            if (adjcentNodes != null) {
                adjcentNodes.forEach(
                        vertex -> {
                            if (!vis[vertex]) {
                                queue.add(vertex);
                                vis[vertex] = true;
                            }
                        }
                );
            }
            System.out.print(curr);
        }
    }


    static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[]) {
        List<Integer> vertices = list.get(src);
        vis[src] = true;
        System.out.println(src + " ");
        if (vertices != null) {
            vertices.forEach(v -> {
                if (!vis[v]) {
                    dfs(v, list, vis);
                }
            });
        }
    }


    public static void main(String[] args) {


    }

}
