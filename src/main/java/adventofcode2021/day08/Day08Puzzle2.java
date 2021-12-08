package adventofcode2021.day08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.List.of;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static org.apache.commons.lang3.StringUtils.*;

/**
 * @author Mike Schmid
 */
public class Day08Puzzle2 {

    public static int solve(final List<String> input) {
        return input.stream()
                .mapToInt(Day08Puzzle2::getOutputForLine)
                .sum();
    }

    private static int getOutputForLine(String s) {
        String input = substringBefore(s, " | ");
        String output = substringAfterLast(s, " | ");

        Map<Character, Character> characterMapping = getMapping(input);

        return getValue(output, characterMapping);
    }


    private static Map<Character, Character> getMapping(String input) {
        /*  Returns a map of which small letter is where (big letter):
             AAAA
            B    C
            B    C
             DDDD
            E    F
            E    F
             GGGG
         */
        Map<Character, Character> characterMapping = new HashMap<>();

        Map<Integer, List<String>> charsByLength = stream(split(input))
                .collect(groupingBy(String::length));

        List<Character> possibleChars = new ArrayList<>(asList('a', 'b', 'c', 'd', 'e', 'f', 'g'));
        characterMapping.put(getCharThatIsPresentInAllStringsWithLengths(charsByLength, of(3, 5, 6), possibleChars), 'A');
        characterMapping.put(getCharThatIsPresentInAllStringsWithLengths(charsByLength, of(2, 3, 4, 6), possibleChars), 'F');
        characterMapping.put(getCharThatIsPresentInAllStringsWithLengths(charsByLength, of(4, 6), possibleChars), 'B');
        characterMapping.put(getCharThatIsPresentInAllStringsWithLengths(charsByLength, of(2, 3, 4), possibleChars), 'C');
        characterMapping.put(getCharThatIsPresentInAllStringsWithLengths(charsByLength, of(4, 5), possibleChars), 'D');
        characterMapping.put(getCharThatIsPresentInAllStringsWithLengths(charsByLength, of(5, 6), possibleChars), 'G');
        characterMapping.put(possibleChars.get(0), 'E');

        return characterMapping;
    }

    private static char getCharThatIsPresentInAllStringsWithLengths(Map<Integer, List<String>> charsByLength, List<Integer> lengths, List<Character> possibleChars) {
        ArrayList<Character> possibleCharsCopy = new ArrayList<>(possibleChars);

        for (Integer length : lengths) {
            List<String> charsToCheck = charsByLength.get(length);
            for (String string : charsToCheck) {
                possibleCharsCopy.removeIf(c -> !contains(string, c));
            }
        }

        if (possibleCharsCopy.size() != 1) {
            throw new IllegalArgumentException("no unique mapping found");
        }

        Character foundCharacter = possibleCharsCopy.get(0);
        possibleChars.remove(foundCharacter);
        return foundCharacter;
    }

    private static int getValue(String output, Map<Character, Character> characterMapping) {
        Map<String, String> segmentsToValue = Map.of(
                "ABCEFG", "0",
                "CF", "1",
                "ACDEG", "2",
                "ACDFG", "3",
                "BCDF", "4",
                "ABDFG", "5",
                "ABDEFG", "6",
                "ACF", "7",
                "ABCDEFG", "8",
                "ABCDFG", "9"
        );

        StringBuilder sb = new StringBuilder();
        for (String encodedDigit : split(output)) {
            String decodedDigit = encodedDigit.chars()
                    .filter(a -> a != 0)
                    .mapToObj(i -> (char) i)
                    .map(characterMapping::get)
                    .sorted()
                    .map(Object::toString)
                    .collect(joining());
            sb.append(segmentsToValue.get(decodedDigit));
        }

        return parseInt(sb.toString());
    }

}
