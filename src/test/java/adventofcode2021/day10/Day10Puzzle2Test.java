package adventofcode2021.day10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static adventofcode2021.day10.Day10Puzzle2.solve;
import static helper.InputDataFetcher.fetchInputLines;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Puzzle2Test {

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
        assertEquals(288957, solve(input));
    }

    @Test
    void testReal() {
        final List<String> input = fetchInputLines(2021, 10);
        assertEquals(2870201088L, solve(input));
    }

}