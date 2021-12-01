package adventofcode2021.day01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static adventofcode2021.day01.Day01Puzzle.solve;
import static helper.InputDataFetcher.fetchInputLines;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01PuzzleTest {

    @Test
    void testExample() {
        final List<String> input = of(
                "199",
                "200",
                "208",
                "210",
                "200",
                "207",
                "240",
                "269",
                "260",
                "263");
        assertEquals(7, solve(input));
    }

    @Test
    void testReal() {
        final List<String> input = fetchInputLines(2021, 1);
        assertEquals(1502, solve(input));
    }

}