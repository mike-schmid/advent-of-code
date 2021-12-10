package adventofcode2021.day10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static adventofcode2021.day10.Day10Puzzle.solve;
import static helper.InputDataFetcher.fetchInputLines;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10PuzzleTest {

    @Test
    void testExample() {
        List<String> input = of(
                "[({(<(())[]>[[{[]{<()<>>",
                "[(()[<>])]({[<{<<[]>>(",
                "{([(<{}[<>[]}>{[]{[(<()>",
                "(((({<>}<{<{<>}{[]{[]{}",
                "[[<[([]))<([[{}[[()]]]",
                "[{[{({}]{}}([{[{{{}}([]",
                "{<[[]]>}<{[{[{[]{()[[[]",
                "[<(<(<(<{}))><([]([]()",
                "<{([([[(<>()){}]>(<<{{",
                "<{([{{}}[<[[[<>{}]]]>[]]"
        );
        assertEquals(26397, solve(input));
    }

    @Test
    void testReal() {
        final List<String> input = fetchInputLines(2021, 10);
        assertEquals(364389, solve(input));
    }

}