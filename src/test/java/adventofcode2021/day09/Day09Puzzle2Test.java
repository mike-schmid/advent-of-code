package adventofcode2021.day09;

import org.junit.jupiter.api.Test;

import java.util.List;

import static adventofcode2021.day09.Day09Puzzle2.solve;
import static helper.InputDataFetcher.fetchInputLines;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day09Puzzle2Test {

    @Test
    void testExample() {
        List<String> input = of(
                "2199943210",
                "3987894921",
                "9856789892",
                "8767896789",
                "9899965678"
        );
        assertEquals(1134, solve(input));
    }

    @Test
    void testReal() {
        final List<String> input = fetchInputLines(2021, 9);
        assertEquals(964712, solve(input));
    }

}