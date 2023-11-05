package com.fox._5;

public interface GraphSearch {

    default int[] traverse(Graph graph) {
        return this.traverse(graph, 0);
    }

    int[] traverse(Graph graph, int startVertex);
}
