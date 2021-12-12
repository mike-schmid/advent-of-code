package adventofcode2021.day11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static adventofcode2021.day11.Day11Puzzle2.solve;
import static helper.InputDataFetcher.fetchInputLines;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11Puzzle2Test {

    @Test
    void testExample() {
        List<String> input = of(
                "5483143223",
                "2745854711",
                "5264556173",
                "6141336146",
                "6357385478",
                "4167524645",
                "2176841721",
                "6882881134",
                "4846848554",
                "5283751526"
        );
        assertEquals(195, solve(input));
    }

    @Test
    void testReal() {
        final List<String> input = fetchInputLines(2021, 11);
        assertEquals(505, solve(input));
    }

}