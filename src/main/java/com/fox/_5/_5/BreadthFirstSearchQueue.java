package com.fox._5._5;

import com.fox._5.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BreadthFirstSearchQueue implements BreadthFirstSearch {

    @Override
    public int[] traverse(Graph graph, int startVertex) {
        int[] vertices = graph.getVertices();
        Queue<Integer> queue = new ArrayBlockingQueue<>(vertices.length);
        List<Integer> traversal = new ArrayList<>();

        queue.add(startVertex);
        traversal.add(startVertex);
        while (!queue.isEmpty()) {
            int top = queue.poll();
            handle(top);

            for(int edge : graph.getEdges(top)) {
                if (!traversal.contains(edge)) {
                    traversal.add(edge);
                    queue.add(edge);
                }
            }
        }

        return traversal.stream().mapToInt(i -> i).toArray();
    }

    private void handle(int vertex) {
        System.out.println("> " + vertex);
    }
}
