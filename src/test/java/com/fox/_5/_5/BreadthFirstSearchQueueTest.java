package com.fox._5._5;

import com.fox._5.Graph;
import com.fox._5.GraphDescription;
import com.fox._5.GraphReader;
import com.fox._5.GraphSearch;
import com.fox._5._3.MatrixGraph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BreadthFirstSearchQueueTest {

    GraphSearch graphSearch = new BreadthFirstSearchQueue();

    @Test
    void traverse() {
        GraphDescription description = GraphReader.readGraph("src/test/resources/_5/5.4.graph.txt");
        Graph graph = new MatrixGraph(description);
        int[] expected = new int[]{0,1,2,3,6,4,5,8,7};

        int[] actual = graphSearch.traverse(graph);

        assertArrayEquals(expected, actual);
    }
}