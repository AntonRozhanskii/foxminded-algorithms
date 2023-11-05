package com.fox._5._3;

import com.fox._5.Graph;
import com.fox._5.GraphDescription;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MatrixGraph implements Graph {

    private final boolean[][] matrix;

    public MatrixGraph(GraphDescription description) {
        this.matrix = new boolean
                [description.getSize().getVertices()]
                [description.getSize().getVertices()];
        description.getPairs().forEach(p -> {
            if (p.getAdjacent() != null) {
                matrix[p.getNode()][p.getAdjacent()] = true;
                matrix[p.getAdjacent()][p.getNode()] = true;
            }
        });
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MatrixGraph{");
        sb.append("matrix=[");
        for (boolean[] booleans : matrix) {
            sb.append(Arrays.toString(booleans));
        }
        sb.append("]}");

        return sb.toString();
    }

    public boolean[][] getMatrix() {
        return matrix;
    }

    @Override
    public int[] getVertices() {
        return IntStream.range(0, matrix.length).toArray();
    }

    @Override
    public int[] getEdges(int vertex) {
        boolean[] edges = matrix[vertex];

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            if (edges[i]) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
