package com.fox._5;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class GraphReader {

    private GraphReader(){}

    public static GraphDescription readGraph(String fileName) {

        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<List<Integer>> graphData = lines.stream()
                .map(GraphReader::separate)
                .map(l -> l.stream().map(Integer::valueOf).collect(Collectors.toList()))
                .collect(Collectors.toList());


        return new GraphDescription(graphData);
    }

    private static List<String> separate(String string) {
        List<String> result = Arrays.asList(string.split("\\s+"));
        return result;
    }
}
