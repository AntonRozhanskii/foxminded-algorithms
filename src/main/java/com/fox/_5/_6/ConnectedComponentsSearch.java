package com.fox._5._6;

import com.fox._5.Graph;
import com.fox._5.GraphSearch;

import java.util.*;
import java.util.stream.Collectors;

public class ConnectedComponentsSearch {

    private final GraphSearch search;

    public ConnectedComponentsSearch(GraphSearch search) {
        this.search = search;
    }

    public Map<Integer, List<List<Integer>>> find(Graph graph) {
        int[] vertices = graph.getVertices();
        boolean[] visited = new boolean[vertices.length];
        int componentsNumber = 0;
        List<List<Integer>> connectedComponents = new ArrayList<>();

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                componentsNumber++;
                List<Integer> traverse = Arrays.stream(search.traverse(graph, i))
                        .peek(n -> visited[n] = true)
                        .boxed()
                        .collect(Collectors.toList());
                connectedComponents.add(traverse);
            }
        }

        Map<Integer, List<List<Integer>>> result = new HashMap<>();
        result.put(componentsNumber, connectedComponents);

        return result;
    }
}
