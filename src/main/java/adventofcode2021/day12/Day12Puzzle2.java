package adventofcode2021.day12;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.apache.commons.lang3.StringUtils.*;

/**
 * @author Mike Schmid
 */
public class Day12Puzzle2 {

    public static long solve(final List<String> input) {
        final Map<String, Cave> caves = getCaves(input);

        List<String> resultPaths = new ArrayList<>();
        searchPaths(caves, "", "start", resultPaths);

        return resultPaths.size();
    }

    private static void searchPaths(Map<String, Cave> caves, String currentPath, String name, List<String> resultPaths) {
        if ("end".equals(name)) {
            resultPaths.add(currentPath + ",end");
            return;
        }

        if (isInvalidPath(currentPath, name)) {
            return;
        }

        Cave currentCave = caves.get(name);
        for (Cave cave : currentCave.getTunnels()) {
            searchPaths(caves, currentPath + "," + name, cave.getName(), resultPaths);
        }
    }

    private static boolean isInvalidPath(String currentPath, String name) {
        if (currentPath.contains("start") && "start".equals(name)) {
            return true;
        }

        String newPath = currentPath + "," + name;

        Map<String, Long> repetitions = stream(split(newPath, ","))
                .filter(StringUtils::isAllLowerCase)
                .collect(groupingBy(identity(), counting()));

        if (repetitions.values().stream().anyMatch(n -> n > 2)) { // triples are not allowed
            return true;
        }

        return repetitions.values().stream() // only one duplicate allowed
                .filter(n -> n > 1)
                .count() > 1;
    }

    private static Map<String, Cave> getCaves(List<String> input) {
        Map<String, Cave> caves = new HashMap<>();
        for (String line : input) {
            String from = substringBefore(line, "-");
            String to = substringAfterLast(line, "-");

            caves.putIfAbsent(from, new Cave(from));
            caves.putIfAbsent(to, new Cave(to));

            caves.get(from).addTunnelTo(caves.get(to));
            caves.get(to).addTunnelTo(caves.get(from));
        }

        return caves;
    }

}