package com.fox._6._1;

import com.fox._6.WeightedGraph;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Dijkstra {

    public Map<Integer, List<Integer>> find(WeightedGraph graph, int start, int end) {
        int[] vertices = graph.getVertices();
        int[] distances = new int[vertices.length];
        boolean[] finalizedNodes = new boolean[vertices.length];
        int[] parents = new int[vertices.length];

        for (int i = 0; i < vertices.length; i++) {
            distances[i] = Integer.MAX_VALUE;
            parents[i] = i;
        }
        distances[start] = 0;
        finalizedNodes[start] = true;

        for (int i = vertices.length; i > 0; i--) {

            int minDistance = Integer.MAX_VALUE;
            int minDistanceIndex = start;
            // find minDistance not finalized vertex
            {
                for (int d = 0; d < distances.length; d++) {
                    if (!finalizedNodes[d]) {
                        if (distances[d] < minDistance) {
                            minDistance = distances[d];
                            minDistanceIndex = d;
                        }
                    }
                }
            }
            finalizedNodes[minDistanceIndex] = true;
            // renew distances
            {
                Map<Integer, Integer> adjacentMap = graph.getAdjacent(minDistanceIndex);
                for(Map.Entry<Integer, Integer> neighbor : adjacentMap.entrySet()) {
                    if (!finalizedNodes[neighbor.getKey()]) {
                        distances[neighbor.getKey()] = distances[minDistanceIndex] + neighbor.getValue();
                        parents[neighbor.getKey()] = minDistanceIndex;
                    }
                }
            }
        }

        // trace path
        LinkedList<Integer> path = new LinkedList<>();
        int current = end;
        while (current != parents[current]) {
            path.addFirst(current);
            current = parents[current];
        }
        path.addFirst(start);

        Map<Integer, List<Integer>> result = Map.of(distances[end], path);
        return result;
    }
}
