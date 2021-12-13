package adventofcode2021.day13;

import org.junit.jupiter.api.Test;

import java.util.List;

import static adventofcode2021.day13.Day13Puzzle.solve;
import static helper.InputDataFetcher.fetchInputLines;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day13PuzzleTest {

    @Test
    void testExample01() {
        List<String> input = of(
                "6,10",
                "0,14",
                "9,10",
                "0,3",
                "10,4",
                "4,11",
                "6,0",
                "6,12",
                "4,1",
                "0,13",
                "10,12",
                "3,4",
                "3,0",
                "8,4",
                "1,10",
                "2,14",
                "8,10",
                "9,0",
                "",
                "fold along y=7",
                "fold along x=5"
        );
        assertEquals(17, solve(input));
    }

    @Test
    void testReal() {
        final List<String> input = fetchInputLines(2021, 13);
        assertEquals(724, solve(input));
    }

}