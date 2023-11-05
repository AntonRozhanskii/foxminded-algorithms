package com.fox._6._2;

import com.fox._6.ListWeightedGraph;
import com.fox._6.WeightedGraph;

import java.util.Map;

public class PrimAlgorithm {

    public ListWeightedGraph find(WeightedGraph graph, int start) {
        int[] vertices = graph.getVertices();
        boolean[] finished = new boolean[vertices.length];
        int[] parents = new int[vertices.length];
        int[] distances = new int[vertices.length];

        for (int i = 0; i < vertices.length; i++) {
            parents[i] = i;
            distances[i] = Integer.MAX_VALUE;
        }

        distances[start] = 0;

        for (int i = 0; i < vertices.length; i++) {
            // find min weight
            int minWeightIndex = -1;
            int minWeight = Integer.MAX_VALUE;
            for (int j = 0; j < vertices.length; j++) {
                if (!finished[j] && distances[j] < minWeight) {
                    minWeight = distances[j];
                    minWeightIndex = j;
                }
            }

            finished[minWeightIndex] = true;
            Map<Integer, Integer> neighbors = graph.getAdjacent(minWeightIndex);
            for (Map.Entry<Integer, Integer> edge : neighbors.entrySet()) {
                if (!finished[edge.getKey()]) {
                    if (distances[edge.getKey()] > edge.getValue()) {
                        distances[edge.getKey()] = edge.getValue();
                        parents[edge.getKey()] = minWeightIndex;
                    }
                }
            }
        }

        ListWeightedGraph result = new ListWeightedGraph(vertices.length);
        for (int i = 0; i < vertices.length; i++) {
            if (i != start) {
                result.addVertex(i, parents[i], distances[i]);
            }
        }
        return result;
    }
}
