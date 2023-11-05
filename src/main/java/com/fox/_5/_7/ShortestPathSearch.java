package com.fox._5._7;

import com.fox._5.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ShortestPathSearch {

    public PathDescription createMap(Graph graph, int start) {
        int[] vertices = graph.getVertices();
        int[] parents = new int[vertices.length];
        int[] distances = new int[vertices.length];
        List<Boolean> visited = new ArrayList<>();
        Queue<Integer> queue = new ArrayBlockingQueue<>(vertices.length);


        for (int i = 0; i < vertices.length; i++) {
            parents[i] = i;
            distances[i] = Integer.MAX_VALUE;
            visited.add(false);
        }

        queue.add(start);
        distances[start] = 0;
        visited.set(start, true);

        while(!queue.isEmpty()) {
            int top = queue.remove();
            //handle
            {
                int[] neighbors = graph.getEdges(top);
                for(int adjacent : neighbors) {
                    if (!Boolean.TRUE.equals(visited.get(adjacent))) {
                        queue.add(adjacent);
                        parents[adjacent] = top;
                        // examine distance
                        int newDistance = distances[parents[adjacent]] + 1;
                        if (distances[adjacent] > newDistance) {
                            distances[adjacent] = newDistance;
                        }
                        // mark as visited?
                        visited.set(adjacent, true);
                    }
                }
            }
        }

        return new PathDescription(start, distances, parents);
    }

    public int[] find(Graph graph, int start, int end) {
        int[] vertices = graph.getVertices();
        int[] parents = new int[vertices.length];
        int[] distances = new int[vertices.length];
        List<Boolean> visited = new ArrayList<>();
        Queue<Integer> queue = new ArrayBlockingQueue<>(vertices.length);


        for (int i = 0; i < vertices.length; i++) {
            parents[i] = i;
            distances[i] = Integer.MAX_VALUE;
            visited.add(false);
        }

        queue.add(start);
        distances[start] = 0;
        visited.set(start, true);

        while(!queue.isEmpty()) {
            int top = queue.remove();
            //handle
            {
                int[] neighbors = graph.getEdges(top);
                for(int adjacent : neighbors) {
                    if (!Boolean.TRUE.equals(visited.get(adjacent))) {
                        queue.add(adjacent);
                        parents[adjacent] = top;
                        // examine distance
                        int newDistance = distances[parents[adjacent]] + 1;
                        if (distances[adjacent] > newDistance) {
                            distances[adjacent] = newDistance;
                        }
                        // mark as visited?
                        visited.set(adjacent, true);
                    }
                }
            }
        }

        int length = distances[end] + 1;
        int[] path = new int[length];
        int prev = end;

        do {
            path[--length] = prev;
            prev = parents[prev];
        } while (length > 0);
        return path;
    }
}
