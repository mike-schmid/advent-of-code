package adventofcode2021.day09;

import org.junit.jupiter.api.Test;

import java.util.List;

import static adventofcode2021.day09.Day09Puzzle.solve;
import static helper.InputDataFetcher.fetchInputLines;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day09PuzzleTest {

    @Test
    void testExample() {
        List<String> input = of(
                "2199943210",
                "3987894921",
                "9856789892",
                "8767896789",
                "9899965678"
        );
        assertEquals(15, solve(input));
    }

    @Test
    void testReal() {
        final List<String> input = fetchInputLines(2021, 9);
        assertEquals(588, solve(input));
    }

}