package adventofcode2021.day05;

import org.junit.jupiter.api.Test;

import java.util.List;

import static adventofcode2021.day05.Day05Puzzle.solve;
import static helper.InputDataFetcher.fetchInputLines;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day05PuzzleTest {

    @Test
    void testExample() {
        final List<String> input = of(
                "0,9 -> 5,9",
                "8,0 -> 0,8",
                "9,4 -> 3,4",
                "2,2 -> 2,1",
                "7,0 -> 7,4",
                "6,4 -> 2,0",
                "0,9 -> 2,9",
                "3,4 -> 1,4",
                "0,0 -> 8,8",
                "5,5 -> 8,2");
        assertEquals(5, solve(input));
    }

    @Test
    void testReal() {
        final List<String> input = fetchInputLines(2021, 5);
        assertEquals(7297, solve(input));
    }

}