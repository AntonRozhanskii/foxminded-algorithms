package com.fox._6;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WeightedGraphReader {

    public static ListWeightedGraph readGraph(String fileName) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<List<Integer>> graphData = lines.stream()
                .map(WeightedGraphReader::separate)
                .map(l -> l.stream().map(Integer::valueOf).collect(Collectors.toList()))
                .collect(Collectors.toList());

        ListWeightedGraph result = new ListWeightedGraph(graphData.get(0).get(0));
        for (int i = 1; i < graphData.size(); i++) {
            List<Integer> vertex = graphData.get(i);
            result.addVertex(vertex.get(0), vertex.get(1), vertex.get(2));
        }

        return result;
    }

    private static List<String> separate(String string) {
        return Arrays.asList(string.split("\\s+"));
    }
}
