package adventofcode2021.day08;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.substringAfterLast;

/**
 * @author Mike Schmid
 */
public class Day08Puzzle {

    public static long solve(final List<String> input) {
        return input.stream()
                .map(line -> substringAfterLast(line, "| "))
                .map(StringUtils::split)
                .flatMap(Arrays::stream)
                .map(String::length)
                .filter(l  -> l == 2 || l == 3  || l == 4 || l == 7)
                .count();
    }

}