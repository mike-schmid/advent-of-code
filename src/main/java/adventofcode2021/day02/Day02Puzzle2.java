package adventofcode2021.day02;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.apache.commons.lang3.StringUtils.startsWith;
import static org.apache.commons.lang3.StringUtils.substringAfterLast;

/**
 * @author Mike Schmid
 */
public class Day02Puzzle2 {

    public static int solve(final List<String> input) {

        int horizontalDistance = 0;
        int depth = 0;
        int aim = 0;

        for (String command : input) {
            int value = getValue(command);
            if (startsWith(command, "forward")) {
                horizontalDistance += value;
                depth += aim * value;
            } else if (startsWith(command, "down")) {
                aim += value;
            } else if (startsWith(command, "up")) {
                aim -= value;
            }
        }

        return horizontalDistance * depth;
    }

    private static int getValue(String command) {
        return parseInt(substringAfterLast(command, " "));
    }

}