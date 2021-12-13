package adventofcode2021.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.*;

/**
 * @author Mike Schmid
 */
public class Day12Puzzle {

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
        return isAllLowerCase(name) && currentPath.contains("," + name);
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