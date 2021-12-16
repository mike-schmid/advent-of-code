package adventofcode2021.day14;

import org.junit.jupiter.api.Test;

import java.util.List;

import static adventofcode2021.day14.Day14Puzzle.solve;
import static helper.InputDataFetcher.fetchInputLines;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day14PuzzleTest {

    @Test
    void testExample01() {
        List<String> input = of(
                "NNCB",
                "",
                "CH -> B",
                "HH -> N",
                "CB -> H",
                "NH -> C",
                "HB -> C",
                "HC -> B",
                "HN -> C",
                "NN -> C",
                "BH -> H",
                "NC -> B",
                "NB -> B",
                "BN -> B",
                "BB -> N",
                "BC -> B",
                "CC -> N",
                "CN -> C"
        );
        assertEquals(1588, solve(input));
    }

    @Test
    void testReal() {
        final List<String> input = fetchInputLines(2021, 14);
        assertEquals(2509, solve(input));
    }

}