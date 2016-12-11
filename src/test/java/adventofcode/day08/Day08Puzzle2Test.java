package adventofcode.day08;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Mike Schmid
 */
public class Day08Puzzle2Test {

    @Test
    public void solve() throws Exception {
        final String input =
                "rect 3x2\n" +
                        "rotate column x=1 by 1\n" +
                        "rotate row y=0 by 4\n" +
                        "rotate column x=1 by 1\n";

        final String expected =
                ".#..#.#\n" +
                "#.#....\n" +
                ".#.....";

        Assert.assertEquals(expected, Day08Puzzle2.solve(input, 7, 3));
    }

    @Test
    public void solveReal() throws Exception {

        final String input =
                "rect 1x1\n" +
                        "rotate row y=0 by 5\n" +
                        "rect 1x1\n" +
                        "rotate row y=0 by 6\n" +
                        "rect 1x1\n" +
                        "rotate row y=0 by 5\n" +
                        "rect 1x1\n" +
                        "rotate row y=0 by 2\n" +
                        "rect 1x1\n" +
                        "rotate row y=0 by 5\n" +
                        "rect 2x1\n" +
                        "rotate row y=0 by 2\n" +
                        "rect 1x1\n" +
                        "rotate row y=0 by 4\n" +
                        "rect 1x1\n" +
                        "rotate row y=0 by 3\n" +
                        "rect 2x1\n" +
                        "rotate row y=0 by 7\n" +
                        "rect 3x1\n" +
                        "rotate row y=0 by 3\n" +
                        "rect 1x1\n" +
                        "rotate row y=0 by 3\n" +
                        "rect 1x2\n" +
                        "rotate row y=1 by 13\n" +
                        "rotate column x=0 by 1\n" +
                        "rect 2x1\n" +
                        "rotate row y=0 by 5\n" +
                        "rotate column x=0 by 1\n" +
                        "rect 3x1\n" +
                        "rotate row y=0 by 18\n" +
                        "rotate column x=13 by 1\n" +
                        "rotate column x=7 by 2\n" +
                        "rotate column x=2 by 3\n" +
                        "rotate column x=0 by 1\n" +
                        "rect 17x1\n" +
                        "rotate row y=3 by 13\n" +
                        "rotate row y=1 by 37\n" +
                        "rotate row y=0 by 11\n" +
                        "rotate column x=7 by 1\n" +
                        "rotate column x=6 by 1\n" +
                        "rotate column x=4 by 1\n" +
                        "rotate column x=0 by 1\n" +
                        "rect 10x1\n" +
                        "rotate row y=2 by 37\n" +
                        "rotate column x=19 by 2\n" +
                        "rotate column x=9 by 2\n" +
                        "rotate row y=3 by 5\n" +
                        "rotate row y=2 by 1\n" +
                        "rotate row y=1 by 4\n" +
                        "rotate row y=0 by 4\n" +
                        "rect 1x4\n" +
                        "rotate column x=25 by 3\n" +
                        "rotate row y=3 by 5\n" +
                        "rotate row y=2 by 2\n" +
                        "rotate row y=1 by 1\n" +
                        "rotate row y=0 by 1\n" +
                        "rect 1x5\n" +
                        "rotate row y=2 by 10\n" +
                        "rotate column x=39 by 1\n" +
                        "rotate column x=35 by 1\n" +
                        "rotate column x=29 by 1\n" +
                        "rotate column x=19 by 1\n" +
                        "rotate column x=7 by 2\n" +
                        "rotate row y=4 by 22\n" +
                        "rotate row y=3 by 5\n" +
                        "rotate row y=1 by 21\n" +
                        "rotate row y=0 by 10\n" +
                        "rotate column x=2 by 2\n" +
                        "rotate column x=0 by 2\n" +
                        "rect 4x2\n" +
                        "rotate column x=46 by 2\n" +
                        "rotate column x=44 by 2\n" +
                        "rotate column x=42 by 1\n" +
                        "rotate column x=41 by 1\n" +
                        "rotate column x=40 by 2\n" +
                        "rotate column x=38 by 2\n" +
                        "rotate column x=37 by 3\n" +
                        "rotate column x=35 by 1\n" +
                        "rotate column x=33 by 2\n" +
                        "rotate column x=32 by 1\n" +
                        "rotate column x=31 by 2\n" +
                        "rotate column x=30 by 1\n" +
                        "rotate column x=28 by 1\n" +
                        "rotate column x=27 by 3\n" +
                        "rotate column x=26 by 1\n" +
                        "rotate column x=23 by 2\n" +
                        "rotate column x=22 by 1\n" +
                        "rotate column x=21 by 1\n" +
                        "rotate column x=20 by 1\n" +
                        "rotate column x=19 by 1\n" +
                        "rotate column x=18 by 2\n" +
                        "rotate column x=16 by 2\n" +
                        "rotate column x=15 by 1\n" +
                        "rotate column x=13 by 1\n" +
                        "rotate column x=12 by 1\n" +
                        "rotate column x=11 by 1\n" +
                        "rotate column x=10 by 1\n" +
                        "rotate column x=7 by 1\n" +
                        "rotate column x=6 by 1\n" +
                        "rotate column x=5 by 1\n" +
                        "rotate column x=3 by 2\n" +
                        "rotate column x=2 by 1\n" +
                        "rotate column x=1 by 1\n" +
                        "rotate column x=0 by 1\n" +
                        "rect 49x1\n" +
                        "rotate row y=2 by 34\n" +
                        "rotate column x=44 by 1\n" +
                        "rotate column x=40 by 2\n" +
                        "rotate column x=39 by 1\n" +
                        "rotate column x=35 by 4\n" +
                        "rotate column x=34 by 1\n" +
                        "rotate column x=30 by 4\n" +
                        "rotate column x=29 by 1\n" +
                        "rotate column x=24 by 1\n" +
                        "rotate column x=15 by 4\n" +
                        "rotate column x=14 by 1\n" +
                        "rotate column x=13 by 3\n" +
                        "rotate column x=10 by 4\n" +
                        "rotate column x=9 by 1\n" +
                        "rotate column x=5 by 4\n" +
                        "rotate column x=4 by 3\n" +
                        "rotate row y=5 by 20\n" +
                        "rotate row y=4 by 20\n" +
                        "rotate row y=3 by 48\n" +
                        "rotate row y=2 by 20\n" +
                        "rotate row y=1 by 41\n" +
                        "rotate column x=47 by 5\n" +
                        "rotate column x=46 by 5\n" +
                        "rotate column x=45 by 4\n" +
                        "rotate column x=43 by 5\n" +
                        "rotate column x=41 by 5\n" +
                        "rotate column x=33 by 1\n" +
                        "rotate column x=32 by 3\n" +
                        "rotate column x=23 by 5\n" +
                        "rotate column x=22 by 1\n" +
                        "rotate column x=21 by 2\n" +
                        "rotate column x=18 by 2\n" +
                        "rotate column x=17 by 3\n" +
                        "rotate column x=16 by 2\n" +
                        "rotate column x=13 by 5\n" +
                        "rotate column x=12 by 5\n" +
                        "rotate column x=11 by 5\n" +
                        "rotate column x=3 by 5\n" +
                        "rotate column x=2 by 5\n" +
                        "rotate column x=1 by 5";

        final String expected =
                "####.####.####.#...##..#.####.###..####..###...##.\n" +
                "#....#....#....#...##.#..#....#..#.#......#.....#.\n" +
                "###..###..###...#.#.##...###..#..#.###....#.....#.\n" +
                "#....#....#......#..#.#..#....###..#......#.....#.\n" +
                "#....#....#......#..#.#..#....#.#..#......#..#..#.\n" +
                "####.#....####...#..#..#.#....#..#.#.....###..##..";

        Assert.assertEquals(expected, Day08Puzzle2.solve(input, 50, 6));
    }

}