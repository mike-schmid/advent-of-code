package adventofcode2021.day01;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Mike Schmid
 */
public class Day01Puzzle2 {

    public static int solve(final List<String> input) {

        List<Integer> numbers = input.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(toList());

        int increases = 0;
        for (int i = 0; i < numbers.size() - 3; i++) {
            int currentWindow = numbers.get(i) + numbers.get(i + 1) + numbers.get(i + 2);
            int nextWindow = numbers.get(i + 1) + numbers.get(i + 2) + numbers.get(i + 3);
            if (currentWindow < nextWindow) {
                increases++;
            }
        }

        return increases;
    }

}
