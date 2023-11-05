package com.fox._5._4;

import com.fox._5.Graph;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearchRecursion implements DepthFirstSearch {

    private List<Integer> traversal;

    @Override
    public int[] traverse(Graph graph, int startVertex){
        traversal = new ArrayList<>();
        dive(graph, startVertex);

        return traversal.stream().mapToInt(i -> i).toArray();
    }

    private void dive(Graph graph, int index) {
        if (this.traversal.contains(index)) {
            return;
        }
        handle(index);
        int[] edges = graph.getEdges(index);
        this.traversal.add(index);
        for (int edge : edges) {
            dive(graph, edge);
        }
    }

    private void handle(int e) {
        System.out.println("rec > " + e);
    }
}
