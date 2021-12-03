package adventofcode2021.day03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static adventofcode2021.day03.Day03Puzzle.solve;
import static helper.InputDataFetcher.fetchInputLines;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03PuzzleTest {

    @Test
    void testExample() {
        final List<String> input = of(
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010");
        assertEquals(198, solve(input));
    }

    @Test
    void testReal() {
        final List<String> input = fetchInputLines(2021, 3);
        assertEquals(1540244, solve(input));
    }

}