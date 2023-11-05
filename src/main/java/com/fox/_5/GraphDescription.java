package com.fox._5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GraphDescription {

    private final Size size;
    private final List<VertexEdgePair> pairs;

    public GraphDescription(List<List<Integer>> graphData) {
        List<Integer> sizeData = graphData.get(0);
        this.size = new Size(sizeData.get(0), sizeData.get(1));
        this.pairs = new ArrayList<>();
        for (int i = 1; i < graphData.size(); i++) {
            VertexEdgePair pair;
            if(graphData.get(i).size() == 2) {
                pair = new VertexEdgePair(graphData.get(i).get(0), graphData.get(i).get(1));
            } else {
                pair = new VertexEdgePair(graphData.get(i).get(0));
            }
            this.pairs.add(pair);
        }
    }

    @Override
    public String toString() {
        return "GraphDescription{" +
                "size=" + size +
                ", pairs=" + pairs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GraphDescription)) return false;
        GraphDescription that = (GraphDescription) o;
        return size.equals(that.size) && pairs.equals(that.pairs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, pairs);
    }

    public Size getSize() {
        return size;
    }

    public List<VertexEdgePair> getPairs() {
        return pairs;
    }

    public static final class Size {

        private final int vertices;
        private final int edges;

        private Size(int vertices, int edges) {
            this.vertices = vertices;
            this.edges = edges;
        }

        @Override
        public String toString() {
            return "Size{" +
                    "vertices=" + vertices +
                    ", edges=" + edges +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Size)) return false;
            Size size = (Size) o;
            return getVertices() == size.getVertices() && getEdges() == size.getEdges();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getVertices(), getEdges());
        }

        public int getVertices() {
            return vertices;
        }

        public int getEdges() {
            return edges;
        }
    }

    public static final class VertexEdgePair {
        private final int node;
        private final Integer adjacent;

        private VertexEdgePair(int node, int adjacent) {
            this.node = node;
            this.adjacent = adjacent;
        }

        private VertexEdgePair(int node) {
            this.node = node;
            this.adjacent = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("VertexEdgePair{node=");
            sb.append(node);
            if(adjacent != null) {
                sb.append(", adjacent=").append(adjacent);
            }
            sb.append('}');
            return sb.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof VertexEdgePair)) return false;
            VertexEdgePair that = (VertexEdgePair) o;
            return getNode() == that.getNode() && getAdjacent() == that.getAdjacent();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getNode(), getAdjacent());
        }

        public int getNode() {
            return node;
        }

        public Integer getAdjacent() {
            return adjacent;
        }
    }
}
