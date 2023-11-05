package com.fox._6;

import java.util.*;
import java.util.stream.IntStream;

public class ListWeightedGraph implements WeightedGraph {

    private final List<Map<Integer, Integer>> graph;

    public ListWeightedGraph(int vertices) {
        this.graph = new ArrayList<>(vertices);
        IntStream.range(0, vertices)
                .forEach(v -> this.graph.add(new HashMap<>()));
    }

    public ListWeightedGraph addVertex(int vertex, int neighbor, int weight) {
        this.graph.get(vertex).put(neighbor, weight);
        this.graph.get(neighbor).put(vertex, weight);
        return this;
    }

    @Override
    public Map<Integer, Integer> getAdjacent(int vertex) {
        return graph.get(vertex);
    }

    @Override
    public int[] getVertices() {
        return IntStream.range(0, graph.size()).toArray();
    }

    @Override
    public String toString() {
        return "ListWeightedGraph{" +
                "graph=" + graph +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListWeightedGraph that = (ListWeightedGraph) o;
        return graph.equals(that.graph);
    }

    @Override
    public int hashCode() {
        return Objects.hash(graph);
    }
}
