package com.fox._5._4;

import com.fox._5.Graph;
import com.fox._5.GraphDescription;
import com.fox._5.GraphReader;
import com.fox._5._3.MatrixGraph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstSearchStackTest {

    DepthFirstSearch search = new DepthFirstSearchStack();

    @Test
    void traversal() {
        GraphDescription description = GraphReader.readGraph("src/test/resources/_5/5.4.graph.txt");
        Graph graph = new MatrixGraph(description);
        int[] expected = new int[]{0, 1, 3, 4, 6, 2, 5, 7, 8};

        int[] actual = search.traverse(graph);

        assertArrayEquals(expected, actual);
    }
}