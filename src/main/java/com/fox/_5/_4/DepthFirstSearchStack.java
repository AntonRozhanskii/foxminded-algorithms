package com.fox._5._4;

import com.fox._5.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchStack implements DepthFirstSearch{

    @Override
    public int[] traverse(Graph graph, int startVertex) {
        int[] vertices = graph.getVertices();
        List<Integer> traversal = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(vertices[startVertex]);


        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (!traversal.contains(current)) {
                traversal.add(current);
                handle(current);
            }
            int[] edges = graph.getEdges(current);
            for(int i = edges.length - 1; i >= 0; i--) {
                int edge = edges[i];
                if (!traversal.contains(edge)) {
                    stack.push(edge);
                }
            }
        }

        return traversal.stream().mapToInt(i -> i).toArray();
    }

    private void handle(int vertex) {
        System.out.println("sta > " + vertex);
    }
}
