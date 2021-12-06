package adventofcode2021.day06;

import org.junit.jupiter.api.Test;

import static adventofcode2021.day06.Day06Puzzle.solve;
import static helper.InputDataFetcher.fetchInput;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day06PuzzleTest {

    @Test
    void testExample() {
        assertEquals(5934, solve("3,4,3,1,2"));
    }

    @Test
    void testReal() {
        final String input = fetchInput(2021, 6);
        assertEquals(372984, solve(input));
    }

}