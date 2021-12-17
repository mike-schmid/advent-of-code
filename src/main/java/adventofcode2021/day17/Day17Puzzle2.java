package adventofcode2021.day17;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;
import static org.apache.commons.lang3.StringUtils.substringAfterLast;
import static org.apache.commons.lang3.StringUtils.substringBetween;
import static org.apache.commons.lang3.tuple.Pair.of;

/**
 * @author Mike Schmid
 */
public class Day17Puzzle2 {

    public static int solve(final String input) {
        int minXTarget = parseInt(substringBetween(input, "x=", ".."));
        int maxXTarget = parseInt(substringBetween(input, "..", ","));
        int minYTarget = parseInt(substringBetween(input, "y=", ".."));
        int maxYTarget = parseInt(substringAfterLast(input, ".."));

        return numberOfValidLaunchParams(
                minXTarget,
                maxXTarget,
                minYTarget,
                maxYTarget
        );
    }

    private static int numberOfValidLaunchParams(int minXTarget, int maxXTarget, int minYTarget, int maxYTarget) {
        Set<Integer> possibleXLaunchSpeeds = possibleXLaunchSpeeds(minXTarget, maxXTarget);
        Set<Integer> possibleYLaunchSpeeds = possibleYLaunchSpeeds(minYTarget, maxYTarget);

        Set<Pair<Integer, Integer>> possibleLaunchSpeeds = new HashSet<>();
        for (int possibleYLaunchSpeed : possibleYLaunchSpeeds) {
            for (int possibleXLaunchSpeed : possibleXLaunchSpeeds) {
                if (hitsTarget(possibleXLaunchSpeed, possibleYLaunchSpeed, minXTarget, maxXTarget, minYTarget, maxYTarget)) {
                    possibleLaunchSpeeds.add(of(possibleXLaunchSpeed, possibleYLaunchSpeed));
                }
            }
        }

        return possibleLaunchSpeeds.size();
    }

    private static boolean hitsTarget(int xSpeed, int ySpeed, int minXTarget, int maxXTarget, int minYTarget, int maxYTarget) {
        int currentXPos = 0;
        int currentYPos = 0;
        int currentXSpeed = xSpeed;
        int currentYSpeed = ySpeed;

        while (currentXPos <= maxXTarget && currentYPos >= minYTarget) {
            currentXPos += currentXSpeed;
            currentYPos += currentYSpeed;

            if (currentXPos >= minXTarget && currentXPos <= maxXTarget && currentYPos <= maxYTarget && currentYPos >= minYTarget) {
                return true;
            }

            currentXSpeed = currentXSpeed > 0 ? currentXSpeed - 1 : 0;
            currentYSpeed--;
        }

        return false;
    }

    private static Set<Integer> possibleYLaunchSpeeds(int minYTarget, int maxYTarget) {
        Set<Integer> possibleYLaunchSpeeds = new TreeSet<>();

        for (int i = -minYTarget; i >= minYTarget; i--) {
            int currentYPos = 0;
            int currentYSpeed = i;
            while (currentYPos >= minYTarget) {
                if (currentYPos <= maxYTarget) {
                    possibleYLaunchSpeeds.add(i);
                    possibleYLaunchSpeeds.add(-i);
                }
                currentYSpeed--;
                currentYPos += currentYSpeed;
            }

        }

        return possibleYLaunchSpeeds;
    }

    private static Set<Integer> possibleXLaunchSpeeds(int minXTarget, int maxXTarget) {
        int minXLaunchSpeed;
        int n = 1;
        while (true) {
            int stopPos = n * (n + 1) / 2;
            if (stopPos >= minXTarget) {
                minXLaunchSpeed = n;
                break;
            }
            n++;
        }

        Set<Integer> possibleXLaunchSpeeds = new HashSet<>();
        for (int possibleXLaunchSpeed = minXLaunchSpeed; possibleXLaunchSpeed <= maxXTarget; possibleXLaunchSpeed++) {
            int currentXPos = 0;
            int currentXSpeed = possibleXLaunchSpeed;
            while (currentXSpeed > 0) {
                currentXPos += currentXSpeed;
                if (currentXPos > maxXTarget) {
                    break;
                }
                if (currentXPos >= minXTarget) {
                    possibleXLaunchSpeeds.add(possibleXLaunchSpeed);
                    break;
                }
                currentXSpeed--;
            }
        }

        return possibleXLaunchSpeeds;
    }

}