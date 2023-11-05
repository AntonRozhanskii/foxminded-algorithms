package com.fox._6._2;

import com.fox._6.ListWeightedGraph;
import com.fox._6.WeightedGraph;
import com.fox._6.WeightedGraphReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimAlgorithmTest {

    @Test
    void find() {
        WeightedGraph graph = WeightedGraphReader.readGraph("src/test/resources/6.1.graph.txt");
        PrimAlgorithm algorithm = new PrimAlgorithm();
        ListWeightedGraph expected = new ListWeightedGraph(9);
        expected.addVertex(0, 1, 4);
        expected.addVertex(0, 2, 3);
        expected.addVertex(1, 3, 2);
        expected.addVertex(3, 4, 3);
        expected.addVertex(3, 8, 5);
        expected.addVertex(4, 6, 1);
        expected.addVertex(6, 5, 2);
        expected.addVertex(6, 7, 7);

        ListWeightedGraph actual = algorithm.find(graph, 0);

        assertEquals(expected, actual);
    }
}