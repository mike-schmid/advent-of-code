package adventofcode2021.day14;

import org.apache.commons.lang3.tuple.Triple;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.contains;
import static org.apache.commons.lang3.tuple.Triple.of;

/**
 * @author Mike Schmid
 */
public class Day14Puzzle {

    public static long solve(final List<String> input) {

        Set<Triple<Character, Character, Character>> mapping = input.stream()
                .filter(s -> contains(s, "->"))
                .map(s -> of(s.charAt(0), s.charAt(6), s.charAt(1)))
                .collect(toSet());

        String currentPolymer = input.get(0);
        for (int i = 0; i < 10; i++) {
            currentPolymer = buildPolymer(currentPolymer, mapping);
        }

        return getPolymerQuality(currentPolymer);
    }

    private static String buildPolymer(String currentPolymer, Set<Triple<Character, Character, Character>> mapping) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < currentPolymer.length() - 1; i++) {
            sb.append(currentPolymer.charAt(i));
            sb.append(getCharBetween(mapping, currentPolymer.charAt(i), currentPolymer.charAt(i + 1)));
        }
        sb.append(currentPolymer.charAt(currentPolymer.length() - 1));

        return sb.toString();
    }

    private static String getCharBetween(Set<Triple<Character, Character, Character>> mapping, char left, char right) {
        for (Triple<Character, Character, Character> triple : mapping) {
            if (triple.getLeft() == left && triple.getRight() == right) {
                return triple.getMiddle().toString();
            }
        }

        return EMPTY;
    }

    private static long getPolymerQuality(String currentPolymer) {
        Map<Character, Long> charFrequencies = currentPolymer.codePoints()
                .mapToObj(c -> (char) c)
                .collect(groupingBy(identity(), counting()));

        List<Long> sorted = charFrequencies.values().stream().sorted().toList();

        return sorted.get(sorted.size() - 1) - sorted.get(0);
    }

}