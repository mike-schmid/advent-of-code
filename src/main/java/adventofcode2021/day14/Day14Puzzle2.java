package adventofcode2021.day14;

import java.util.*;

import static java.lang.String.valueOf;
import static org.apache.commons.lang3.StringUtils.substringAfter;
import static org.apache.commons.lang3.StringUtils.substringBefore;

/**
 * @author Mike Schmid
 */
public class Day14Puzzle2 {

    public static long solve(final List<String> input) {
        Map<String, Long> pairFrequencies = getPairFrequencies(input);
        Map<String, Long> charFrequencies = getCharFrequencies(input);
        Map<String, String> mapping = getMapping(input);

        for (int i = 0; i < 40; i++) {
            pairFrequencies = update(pairFrequencies, charFrequencies, mapping);
        }

        return getPolymerQuality(charFrequencies);
    }

    private static Map<String, Long> update(Map<String, Long> pairFrequencies, Map<String, Long> charFrequencies, Map<String, String> mappings) {
        Map<String, Long> newPairFrequencies = new HashMap<>(pairFrequencies);

        for (Map.Entry<String, String> mapping : mappings.entrySet()) {
            newPairFrequencies.put(mapping.getKey(), 0L);
        }

        for (Map.Entry<String, String> mapping : mappings.entrySet()) {
            String newMiddleChar = mapping.getValue();
            String key = mapping.getKey();

            String newLeft = key.charAt(0) + newMiddleChar;
            String newRight = newMiddleChar + key.charAt(1);
            newPairFrequencies.put(newLeft, newPairFrequencies.get(newLeft) + pairFrequencies.get(key));
            newPairFrequencies.put(newRight, newPairFrequencies.get(newRight) + pairFrequencies.get(key));
            charFrequencies.put(newMiddleChar, charFrequencies.get(newMiddleChar) + pairFrequencies.get(key));
        }

        return newPairFrequencies;
    }

    private static Map<String, String> getMapping(List<String> input) {
        Map<String, String> mapping = new HashMap<>();
        for (String line : input) {
            if (!line.contains("->")) {
                continue;
            }
            String key = substringBefore(line, " -> ");
            String value = substringAfter(line, " -> ");
            mapping.put(key, value);
        }
        return mapping;
    }

    private static Map<String, Long> getCharFrequencies(List<String> input) {
        Set<Character> possibleChars = getPossibleChars(input);

        Map<String, Long> charFrequencies = new HashMap<>();
        for (Character character : possibleChars) {
            charFrequencies.put(valueOf(character), 0L);
        }

        String template = input.get(0);
        for (char character : template.toCharArray()) {
            String s = valueOf(character);
            charFrequencies.put(s, charFrequencies.get(s) + 1);
        }

        return charFrequencies;
    }

    private static Map<String, Long> getPairFrequencies(List<String> input) {
        String template = input.get(0);
        Set<Character> possibleChars = getPossibleChars(input);

        Map<String, Long> pairFrequencies = new HashMap<>();
        for (Character char1 : possibleChars) {
            for (Character char2 : possibleChars) {
                pairFrequencies.put(valueOf(char1) + char2, 0L);
            }
        }

        for (int i = 0; i < template.length() - 1; i++) {
            String pair = valueOf(template.charAt(i)) + template.charAt(i + 1);
            pairFrequencies.put(pair, pairFrequencies.get(pair) + 1);
        }
        return pairFrequencies;
    }

    private static Set<Character> getPossibleChars(List<String> input) {
        Set<Character> possibleChars = new HashSet<>();
        for (String line : input) {
            for (int i = 0; i < line.length(); i++) {
                char currentChar = line.charAt(i);
                if (currentChar > 64 && currentChar < 91) { // only upper-case chars
                    possibleChars.add(currentChar);
                }
            }
        }
        return possibleChars;
    }

    private static long getPolymerQuality(Map<String, Long> charFrequencies) {
        List<Long> sorted = charFrequencies.values().stream().sorted().toList();

        return sorted.get(sorted.size() - 1) - sorted.get(0);
    }

}