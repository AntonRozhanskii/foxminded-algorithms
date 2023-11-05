package com.fox._5._7;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PathDescription {

    private final int startingVertex;
    private final List<Integer> distances;
    private final List<Integer> parents;

    public PathDescription(int startingVertex, List<Integer> distances, List<Integer> parents) {
        this.startingVertex = startingVertex;
        this.distances = distances;
        this.parents = parents;
    }

    public PathDescription(int startingVertex, int[] distances, int[] parants) {
        this.startingVertex = startingVertex;
        this.distances = Arrays.stream(distances).boxed().collect(Collectors.toList());
        this.parents = Arrays.stream(parants).boxed().collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "PathDescription{" +
                "startingVertex=" + startingVertex +
                ", distances=" + distances +
                ", parents=" + parents +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PathDescription that = (PathDescription) o;
        return startingVertex == that.startingVertex && distances.equals(that.distances) && parents.equals(that.parents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startingVertex, distances, parents);
    }
}
