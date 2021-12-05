package adventofcode2021.day05;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.tuple.Pair.of;

/**
 * @author Mike Schmid
 */
public class Day05Puzzle {

    public static long solve(final List<String> input) {
        HashMap<Pair<Integer, Integer>, Integer> coveredCoordinates = new HashMap<>();

        for (String line : input) {

            int x1 = parseInt(substringBefore(line, ","));
            int y1 = parseInt(substringBetween(line, ",", " ->"));
            int x2 = parseInt(substringBetween(line, "-> ", ","));
            int y2 = parseInt(substringAfterLast(line, ","));

            if (x1 != x2 && y1 != y2) { // do not consider diagonals
                continue;
            }

            int minX = min(x1, x2);
            int maxX = max(x1, x2);
            int minY = min(y1, y2);
            int maxY = max(y1, y2);

            for (int x = minX; x <= maxX; x++) {
                for (int y = minY; y <= maxY; y++) {
                    Pair<Integer, Integer> coordinate = of(x, y);
                    if (coveredCoordinates.containsKey(coordinate)) {
                        coveredCoordinates.put(coordinate, coveredCoordinates.get(coordinate) + 1);
                    } else {
                        coveredCoordinates.put(coordinate, 1);
                    }
                }
            }

        }

        return coveredCoordinates.values()
                .stream()
                .filter(i -> i >= 2)
                .count();
    }

}