package adventofcode2021.day10;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * @author Mike Schmid
 */
public class Day10Puzzle {

    private static final Map<Character, Character> bracketPairs = Map.of(
            '(', ')',
            '[', ']',
            '{', '}',
            '<', '>'
    );

    private static final Map<Character, Integer> bracketValues = Map.of(
            ')', 3,
            ']', 57,
            '}', 1197,
            '>', 25137
    );

    public static long solve(final List<String> input) {
        return input.stream()
                .map(Day10Puzzle::findErrorScore)
                .filter(Objects::nonNull)
                .mapToLong(bracketValues::get)
                .sum();
    }

    private static Character findErrorScore(String line) {

        Stack<Character> stack = new Stack<>();
        for (char bracket : line.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{' || bracket == '<') {
                stack.push(bracket);
            } else {
                Character current = stack.pop();
                if (bracket != bracketPairs.get(current)) {
                    return bracket;
                }
            }
        }

        return null;
    }


}