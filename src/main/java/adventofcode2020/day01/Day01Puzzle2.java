package adventofcode2020.day01;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Mike Schmid
 */
public class Day01Puzzle2 {

    public static int solve(final List<String> input) {
        List<Integer> numbers = input.stream()
                .mapToInt(Integer::parseInt)
                .sorted()
                .boxed()
                .collect(toList());

        for (int i = 0; i < numbers.size(); i++) {
            int a = numbers.get(i);

            for (int j = numbers.size() - 1; j > i; j--) {
                int b = numbers.get(j);

                for (int k = j - 1; k > i - 1; k--) {
                    int c = numbers.get(k);

                    int sum = a + b + c;

                    if (sum < 2020) {
                        break;
                    }

                    if (sum == 2020) {
                        return a * b * c;
                    }
                }
            }
        }

        return -1;
    }

}
