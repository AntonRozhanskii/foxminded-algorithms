package com.fox._6._1;

import com.fox._6.WeightedGraph;
import com.fox._6.WeightedGraphReader;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    @Test
    void find() {
        WeightedGraph graph = WeightedGraphReader.readGraph("src/test/resources/6.1.graph.txt");
        Dijkstra search = new Dijkstra();
        List<Integer> nodes = List.of(0, 1, 3, 4, 6, 7);
        Map<Integer, List<Integer>> expected = Map.of(17, nodes);


        var actual = search.find(graph, 0, 7);

        assertEquals(expected, actual);
    }
}