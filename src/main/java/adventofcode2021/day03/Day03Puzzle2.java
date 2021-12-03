package adventofcode2021.day03;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * @author Mike Schmid
 */
public class Day03Puzzle2 {

    public static int solve(final List<String> input) {
        String oxygenGeneratorRating = "";
        String co2ScrubberRating = "";

        List<String> oxygenGeneratorCandidates = new ArrayList<>(input);
        List<String> co2ScrubberCandidates = new ArrayList<>(input);

        for (int i = 0; i < input.get(0).length(); i++) {
            if ("".equals(oxygenGeneratorRating)) {
                oxygenGeneratorRating = filterAndGetRating(oxygenGeneratorCandidates, i, getMostCommonDigitAt(oxygenGeneratorCandidates, i));
            }

            if ("".equals(co2ScrubberRating)) {
                co2ScrubberRating = filterAndGetRating(co2ScrubberCandidates, i, getLeastCommonDigitAt(co2ScrubberCandidates, i));
            }
        }

        return parseInt(oxygenGeneratorRating, 2) * parseInt(co2ScrubberRating, 2);
    }

    private static String filterAndGetRating(List<String> candidates, int currentPosition, char digitToFilter) {
        candidates.removeIf(number -> number.charAt(currentPosition) != digitToFilter);
        return candidates.size() == 1 ? candidates.get(0) : "";
    }

    private static char getMostCommonDigitAt(List<String> numbers, int position) {
        int count = 0;
        for (String number : numbers) {
            if (number.charAt(position) == '1') {
                count++;
            } else {
                count--;
            }
        }

        return count >= 0 ? '1' : '0';
    }

    private static char getLeastCommonDigitAt(List<String> numbers, int position) {
        return getMostCommonDigitAt(numbers, position) == '1' ? '0' : '1';
    }

}