package adventofcode2021.day06;

import org.junit.jupiter.api.Test;

import static adventofcode2021.day06.Day06Puzzle2.solve;
import static helper.InputDataFetcher.fetchInput;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day06Puzzle2Test {

    @Test
    void testExample() {
        assertEquals(26_984_457_539L, solve("3,4,3,1,2"));
    }

    @Test
    void testReal() {
        final String input = fetchInput(2021, 6);
        assertEquals(1_681_503_251_694L, solve(input));
    }

}