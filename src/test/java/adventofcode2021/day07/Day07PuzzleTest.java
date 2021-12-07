package adventofcode2021.day07;

import org.junit.jupiter.api.Test;

import static adventofcode2021.day07.Day07Puzzle.solve;
import static helper.InputDataFetcher.fetchInput;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day07PuzzleTest {

    @Test
    void testExample() {
        assertEquals(37, solve("16,1,2,0,4,2,7,1,2,14"));
    }

    @Test
    void testReal() {
        final String input = fetchInput(2021, 7);
        assertEquals(326132, solve(input));
    }

}