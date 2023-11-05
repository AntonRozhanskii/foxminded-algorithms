package com.fox._6;

import java.util.List;
import java.util.Map;

public interface WeightedGraph {

    Map<Integer, Integer> getAdjacent(int vertex);

    int[] getVertices();
}
