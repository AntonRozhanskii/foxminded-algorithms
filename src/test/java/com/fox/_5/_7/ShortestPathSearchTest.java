package com.fox._5._7;

import com.fox._5.Graph;
import com.fox._5.GraphReader;
import com.fox._5._3.MatrixGraph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestPathSearchTest {

    private final ShortestPathSearch shortestPathSearch = new ShortestPathSearch();

    @Test
    void buildMap() {
        var graphDescription = GraphReader.readGraph("src/test/resources/_5/5.4.graph.txt");
        Graph graph = new MatrixGraph(graphDescription);
        var expected = new PathDescription(0,
                new int[]{0, 1, 1, 2, 3, 3, 2, 3, 3},
                new int[]{0, 0, 0, 1, 3, 3, 2, 6, 3});

        var actual = shortestPathSearch.createMap(graph, 0);

        assertEquals(expected, actual);
    }

    @Test
    void find() {
        var graphDescription = GraphReader.readGraph("src/test/resources/_5/5.4.graph.txt");
        Graph graph = new MatrixGraph(graphDescription);
        var expected = new int[]{2, 6, 3, 8};

        var actual = shortestPathSearch.find(graph, 2, 8);
        System.out.println(Arrays.toString(actual));

        assertArrayEquals(expected, actual);
    }
}