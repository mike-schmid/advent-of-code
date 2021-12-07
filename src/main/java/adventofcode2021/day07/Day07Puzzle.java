package adventofcode2021.day07;

import java.util.List;

import static java.lang.Integer.*;
import static java.lang.Math.abs;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.split;

/**
 * @author Mike Schmid
 */
public class Day07Puzzle {

    public static int solve(final String input) {

        List<Integer> numbers = stream(split(input, ','))
                .mapToInt(Integer::parseInt)
                .sorted()
                .boxed()
                .collect(toList());


        int minDistance = MAX_VALUE;
        for (int i = 0; i < numbers.size(); i++) {
            int distanceToI = 0;
            for (Integer number : numbers) {
                distanceToI += abs(number - i);
            }
            if (distanceToI <= minDistance) {
                minDistance = distanceToI;
            } else {
                return minDistance;
            }
        }

        return -1;
    }

}