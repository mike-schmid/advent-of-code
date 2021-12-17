package adventofcode2021.day17;

import org.junit.jupiter.api.Test;

import static adventofcode2021.day17.Day17Puzzle2.solve;
import static helper.InputDataFetcher.fetchInput;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day17Puzzle2Test {

    @Test
    void testExample01() {
        String input = "target area: x=20..30, y=-10..-5";
        assertEquals(112, solve(input));
    }

    @Test
    void testReal() {
        String input = fetchInput(2021, 17);
        assertEquals(3540, solve(input));
    }

}