package adventofcode2021.day10;

import java.util.*;

import static java.util.Arrays.stream;
import static java.util.Collections.sort;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.ArrayUtils.reverse;

/**
 * @author Mike Schmid
 */
public class Day10Puzzle2 {

    private static final Map<Character, Character> bracketPairs = Map.of(
            '(', ')',
            '[', ']',
            '{', '}',
            '<', '>'
    );

    private static final Map<Character, Integer> bracketValues = Map.of(
            ')', 1,
            ']', 2,
            '}', 3,
            '>', 4
    );

    public static long solve(final List<String> input) {

        List<Long> scores = new ArrayList<>();
        for (String line : input) {
            long autoCompleteScore = getAutoCompleteScore(line);
            if (autoCompleteScore > 0) {
                scores.add(autoCompleteScore);
            }
        }

        sort(scores);
        return scores.get((scores.size() - 1) / 2);
    }

    private static long getAutoCompleteScore(String line) {
        Stack<Character> stack = new Stack<>();
        for (char bracket : line.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{' || bracket == '<') {
                stack.push(bracket);
            } else {
                Character current = stack.pop();
                if (bracket != bracketPairs.get(current)) {
                    return 0; // corrupted lines have a score of 0
                }
            }
        }

        return getScoreFor(stack.toArray(new Character[0]));
    }

    private static long getScoreFor(Character[] array) {
        reverse(array);
        List<Integer> values = stream(array)
                .map(bracketPairs::get)
                .map(bracketValues::get)
                .collect(toList());

        long sum = 0;
        for (Integer value : values) {
            sum = sum * 5 + value;
        }

        return sum;
    }

}