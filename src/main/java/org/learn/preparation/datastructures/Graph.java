package org.learn.preparation.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public static class Edge {
        Vertex v1;
        Vertex v2;
        int weight;

        Edge(Vertex v1, Vertex v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
    }

    public static class Vertex {
        int id;// start
        List<Edge> edges;

        public Vertex(int id) {
            this.id = id;
        }
    }

    public void bfs(Vertex head) {
        List<Vertex> queue = new ArrayList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            Vertex curr = queue.remove(0);
            System.out.print(curr.id + " ");
            if (curr.edges != null) {
                curr.edges.forEach(
                        edge -> queue.add(edge.v2)
                );
            }
        }
    }

    public static void main(String[] args) {

        Vertex _1 = new Vertex(1);
        Vertex _2 = new Vertex(2);
        Vertex _3 = new Vertex(3);
        Vertex _4 = new Vertex(4);
        Vertex _5 = new Vertex(5);
        Vertex _6 = new Vertex(6);
        Vertex _7 = new Vertex(7);
        Vertex _10 = new Vertex(10);
        Vertex _11 = new Vertex(11);
        Vertex _12 = new Vertex(12);

        Edge _1_2 = new Edge(_1, _2, 0);
        Edge _1_3 = new Edge(_1, _3, 0);
        Edge _1_4 = new Edge(_1, _4, 0);

        List<Edge> _1_edges = new ArrayList<>();
        _1_edges.add(_1_2);
        _1_edges.add(_1_3);
        _1_edges.add(_1_4);
        _1.edges = _1_edges;

        Edge _2_5 = new Edge(_2, _5, 0);
        List<Edge> _2_edges = new ArrayList<>();
        _2_edges.add(_2_5);
        _2.edges = _2_edges;

        Edge _5_7 = new Edge(_5, _7, 0);
        List<Edge> _5_edges = new ArrayList<>();
        _5_edges.add(_5_7);
        _5.edges = _5_edges;

        Edge _4_6 = new Edge(_4, _6, 0);
        List<Edge> _4_edges = new ArrayList<>();
        _4_edges.add(_4_6);
        _4.edges = _4_edges;

        Edge _3_10 = new Edge(_3, _10, 0);
        List<Edge> _3_edges = new ArrayList<>();
        _3_edges.add(_3_10);
        _3.edges = _3_edges;

        Edge _10_11 = new Edge(_10, _11, 0);
        List<Edge> _10_edges = new ArrayList<>();
        _10_edges.add(_10_11);
        _10.edges = _10_edges;


        Edge _11_12 = new Edge(_11, _12, 0);
        List<Edge> _11_edges = new ArrayList<>();
        _11_edges.add(_11_12);
        _11.edges = _11_edges;



        new Graph().bfs(_1);


    }


}
