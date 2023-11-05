package com.fox._5._6;

import com.fox._5.Graph;
import com.fox._5.GraphDescription;
import com.fox._5.GraphReader;
import com.fox._5.GraphSearch;
import com.fox._5._3.MatrixGraph;
import com.fox._5._5.BreadthFirstSearchQueue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConnectedComponentsSearchTest {

    private final GraphSearch graphSearch = new BreadthFirstSearchQueue();
    private final ConnectedComponentsSearch componentsSearch = new ConnectedComponentsSearch(graphSearch);

    @Test
    void find() {
        GraphDescription graphDescription = GraphReader.readGraph("./src/test/resources/_5/5.6_1.graph.txt");
        Graph graph = new MatrixGraph(graphDescription);
        Map<Integer, List<List<Integer>>> expected = new HashMap<>();
        List<Integer> component1 = new ArrayList<>(){{
            add(0);
            add(1);
            add(2);
        }};
        List<Integer> component2 = new ArrayList<>(){{
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
        }};
        List<Integer> component3 = new ArrayList<>(){{
            add(8);
        }};
        List<List<Integer>> expectedComponents = List.of(component1, component2, component3);
        expected.put(3, expectedComponents);

        var actual = componentsSearch.find(graph);

        assertEquals(expected, actual);
    }
}