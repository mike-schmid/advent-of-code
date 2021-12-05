package adventofcode2021.day05;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Math.*;
import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.tuple.Pair.of;

/**
 * @author Mike Schmid
 */
public class Day05Puzzle2 {

    public static long solve(final List<String> input) {
        HashMap<Pair<Integer, Integer>, Integer> coveredCoordinates = new HashMap<>();

        for (String line : input) {

            int x1 = parseInt(substringBefore(line, ","));
            int y1 = parseInt(substringBetween(line, ",", " ->"));
            int x2 = parseInt(substringBetween(line, "-> ", ","));
            int y2 = parseInt(substringAfterLast(line, ","));

            int length = getLineLength(x1, y1, x2, y2);

            int x = x1;
            int y = y1;

            for (int i = 0; i <= length; i++) {
                Pair<Integer, Integer> coordinate = of(x, y);
                if (coveredCoordinates.containsKey(coordinate)) {
                    coveredCoordinates.put(coordinate, coveredCoordinates.get(coordinate) + 1);
                } else {
                    coveredCoordinates.put(coordinate, 1);
                }

                if (x1 < x2) {
                    x++;
                } else if (x1 > x2) {
                    x--;
                }

                if (y1 < y2) {
                    y++;
                } else if (y1 > y2) {
                    y--;
                }

            }

        }

        return coveredCoordinates.values()
                .stream()
                .filter(i -> i >= 2)
                .count();
    }

    private static int getLineLength(int x1, int y1, int x2, int y2) {
        int length;
        if (x1 == x2) { // it's a vertical line
            length = abs(y1 - y2);
        } else if (y1 == y2) { // it's a horizontal line
            length = abs(x1 - x2);
        } else { // it's a diagonal
            length = abs(x1 - x2);
        }
        return length;
    }

}