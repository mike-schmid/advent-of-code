package adventofcode2021.day01;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Mike Schmid
 */
public class Day01Puzzle {

    public static int solve(final List<String> input) {

        List<Integer> numbers = input.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(toList());

        int increases = 0;
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) < numbers.get(i + 1)){
                increases++;
            }
        }

        return increases;
    }

}
