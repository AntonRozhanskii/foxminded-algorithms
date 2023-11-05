package com.fox._5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphReaderTest {

    @Test
    void readGraph() {
        List<List<Integer>> graphData = new ArrayList<>();
        graphData.add(new ArrayList<>(){{add(3);add(2);}});
        graphData.add(new ArrayList<>(){{add(0);add(1);}});
        graphData.add(new ArrayList<>(){{add(0);add(2);}});
        GraphDescription expected = new GraphDescription(graphData);

        var actual = GraphReader.readGraph("src/test/resources/_5/graph.txt");

        assertEquals(expected, actual);
    }

    @Test
    void readDividedGraph() {
        List<List<Integer>> graphData = new ArrayList<>();
        graphData.add(new ArrayList<>(){{add(3);add(1);}});
        graphData.add(new ArrayList<>(){{add(0);add(2);}});
        graphData.add(new ArrayList<>(){{add(1);}});
        GraphDescription expected = new GraphDescription(graphData);

        var actual = GraphReader.readGraph("src/test/resources/_5/5.6.graph.txt");

        assertEquals(expected, actual);
    }
}