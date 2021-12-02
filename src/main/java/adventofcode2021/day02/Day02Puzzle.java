package adventofcode2021.day02;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.apache.commons.lang3.StringUtils.*;

/**
 * @author Mike Schmid
 */
public class Day02Puzzle {

    public static int solve(final List<String> input) {

        int horizontalDistance = 0;
        int depth = 0;
        for (String command : input) {
            int value = getValue(command);
            if (startsWith(command, "forward")) {
                horizontalDistance += value;
            } else if (startsWith(command, "down")) {
                depth += value;
            } else if (startsWith(command, "up")) {
                depth -= value;
            }
        }

        return horizontalDistance * depth;
    }

    private static int getValue(String command) {
        return parseInt(substringAfterLast(command, " "));
    }

}