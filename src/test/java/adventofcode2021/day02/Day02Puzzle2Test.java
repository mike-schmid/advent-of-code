package adventofcode2021.day02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static adventofcode2021.day02.Day02Puzzle2.solve;
import static helper.InputDataFetcher.fetchInputLines;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02Puzzle2Test {

    @Test
    void testExample() {
        final List<String> input = of(
                "forward 5",
                "down 5",
                "forward 8",
                "up 3",
                "down 8",
                "forward 2");
        assertEquals(900, solve(input));
    }

    @Test
    void testReal() {
        final List<String> input = fetchInputLines(2021, 2);
        assertEquals(1727785422, solve(input));
    }

}