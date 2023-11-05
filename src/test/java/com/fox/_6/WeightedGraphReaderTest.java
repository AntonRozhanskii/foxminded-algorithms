package com.fox._6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightedGraphReaderTest {

    @Test
    void readGraph() {
        var graph = WeightedGraphReader.readGraph("src/test/resources/6.1.graph.txt");
        System.out.println(graph);
    }
}