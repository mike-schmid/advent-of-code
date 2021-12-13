package adventofcode2021.day12;

import org.junit.jupiter.api.Test;

import java.util.List;

import static adventofcode2021.day12.Day12Puzzle.solve;
import static helper.InputDataFetcher.fetchInputLines;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day12PuzzleTest {

    @Test
    void testExample01() {
        List<String> input = of(
                "start-A",
                "start-b",
                "A-c",
                "A-b",
                "b-d",
                "A-end",
                "b-end"
        );
        assertEquals(10, solve(input));
    }

    @Test
    void testExample02() {
        List<String> input = of(
                "dc-end",
                "HN-start",
                "start-kj",
                "dc-start",
                "dc-HN",
                "LN-dc",
                "HN-end",
                "kj-sa",
                "kj-HN",
                "kj-dc"
        );
        assertEquals(19, solve(input));
    }

    @Test
    void testExample03() {
        List<String> input = of(
                "fs-end",
                "he-DX",
                "fs-he",
                "start-DX",
                "pj-DX",
                "end-zg",
                "zg-sl",
                "zg-pj",
                "pj-he",
                "RW-he",
                "fs-DX",
                "pj-RW",
                "zg-RW",
                "start-pj",
                "he-WI",
                "zg-he",
                "pj-fs",
                "start-RW"
        );
        assertEquals(226, solve(input));
    }

    @Test
    void testReal() {
        final List<String> input = fetchInputLines(2021, 12);
        assertEquals(4495, solve(input));
    }

}