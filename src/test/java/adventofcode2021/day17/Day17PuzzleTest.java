package adventofcode2021.day17;

import org.junit.jupiter.api.Test;

import static adventofcode2021.day17.Day17Puzzle.solve;
import static helper.InputDataFetcher.fetchInput;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day17PuzzleTest {

    @Test
    void testExample01() {
        String input = "target area: x=20..30, y=-10..-5";
        assertEquals(45, solve(input));
    }

    @Test
    void testReal() {
        String input = fetchInput(2021, 17);
        assertEquals(11175, solve(input));
    }

}