package adventofcode2021.day03;

import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * @author Mike Schmid
 */
public class Day03Puzzle {

    public static int solve(final List<String> input) {

        StringBuilder mostCommon = new StringBuilder();
        StringBuilder leastCommon = new StringBuilder();

        int numberLength = input.get(0).length();
        for (int i = 0; i < numberLength; i++) {
            int count = 0;
            for (String number : input) {
                if (number.charAt(i) == '1'){
                    count++;
                } else {
                    count--;
                }
            }
            mostCommon.append(count > 0 ? '1' : '0');
            leastCommon.append(count < 0 ? '1' : '0');
        }

        return parseInt(mostCommon.toString(), 2) * parseInt(leastCommon.toString(), 2);
    }

}