package com.fox._5._3;

import com.fox._5.GraphReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MatrixGraphTest {

    @Test
    void matrixContent() {
        var graphDescription = GraphReader.readGraph("src/test/resources/_5/graph.txt");
        var matrix = new MatrixGraph(graphDescription);
        boolean[][] expected = new boolean[][]{
                {false, true, true},
                {true, false, false},
                {true, false, false}};

        assertArrayEquals(expected, matrix.getMatrix());
    }

    @Test
    void getVertices_shouldReturnIndices() {
        var graphDescription = GraphReader.readGraph("src/test/resources/_5/graph.txt");
        var graph = new MatrixGraph(graphDescription);
        int[] expected = new int[]{0, 1, 2};

        assertArrayEquals(expected, graph.getVertices());
    }
}