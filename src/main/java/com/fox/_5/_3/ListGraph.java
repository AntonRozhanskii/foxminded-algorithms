package com.fox._5._3;

import com.fox._5.Graph;
import com.fox._5.GraphDescription;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListGraph implements Graph {

    private final List<List<Integer>> graph;

    public ListGraph(GraphDescription graphDescription) {
        this.graph = Collections.unmodifiableList(new ArrayList<>(graphDescription.getSize().getVertices()));
        graph.forEach(l -> new ArrayList<>());
        graphDescription.getPairs().forEach(p -> {
            if (p.getAdjacent() != null) {
                graph.get(p.getNode()).add(p.getAdjacent());
            }
        });
    }

    @Override
    public int[] getVertices() {
        return new int[0];
    }

    @Override
    public int[] getEdges(int vertex) {
        return new int[0];
    }
}
