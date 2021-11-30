package adventofcode2020.day01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static adventofcode2020.day01.Day01Puzzle2.solve;
import static helper.InputDataFetcher.fetchInputLines;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01Puzzle2Test {

    @Test
    void testExample() {
        final List<String> input = of(
                "1721",
                "979",
                "366",
                "299",
                "675",
                "1456");
        assertEquals(241861950, solve(input));
    }

    @Test
    void testReal() {
        final List<String> input = fetchInputLines(2020, 1);
        assertEquals(116115990, solve(input));
    }

}