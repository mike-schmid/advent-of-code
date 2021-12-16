package adventofcode2021.day14;

import org.junit.jupiter.api.Test;

import java.util.List;

import static adventofcode2021.day14.Day14Puzzle2.solve;
import static helper.InputDataFetcher.fetchInputLines;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day14Puzzle2Test {

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
        assertEquals(2188189693529L, solve(input));
    }

    @Test
    void testReal() {
        final List<String> input = fetchInputLines(2021, 14);
        assertEquals(2827627697643L, solve(input));
    }

}