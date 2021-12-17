package adventofcode2021.day17;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.util.Collections.sort;
import static java.util.Comparator.reverseOrder;
import static org.apache.commons.lang3.StringUtils.substringAfterLast;
import static org.apache.commons.lang3.StringUtils.substringBetween;

/**
 * @author Mike Schmid
 */
public class Day17Puzzle {

    public static int solve(final String input) {
        int minXTarget = parseInt(substringBetween(input, "x=", ".."));
        int maxXTarget = parseInt(substringBetween(input, "..", ","));
        int minYTarget = parseInt(substringBetween(input, "y=", ".."));
        int maxYTarget = parseInt(substringAfterLast(input, ".."));

        int maxYLaunchSpeed = findMaxYLaunchSpeed(
                minXTarget,
                maxXTarget,
                minYTarget,
                maxYTarget
        );

        return maxYLaunchSpeed * (maxYLaunchSpeed + 1) / 2;
    }

    private static int findMaxYLaunchSpeed(int minXTarget, int maxXTarget, int minYTarget, int maxYTarget) {
        List<Integer> possibleXLaunchSpeeds = getPossibleXLaunchSpeeds(minXTarget, maxXTarget);
        List<Integer> possibleYLaunchSpeeds = possibleYLaunchSpeeds(minYTarget, maxYTarget);

        for (int possibleYLaunchSpeed : possibleYLaunchSpeeds) {
            for (int possibleXLaunchSpeed : possibleXLaunchSpeeds) {
                if (hitsTarget(possibleXLaunchSpeed, possibleYLaunchSpeed, minXTarget, maxXTarget, minYTarget, maxYTarget)) {
                    return possibleYLaunchSpeed;
                }
            }
        }

        throw new IllegalStateException("should not happen");
    }

    private static boolean hitsTarget(int xSpeed, int ySpeed, int minXTarget, int maxXTarget, int minYTarget, int maxYTarget) {
        int currentXPos = 0;
        int currentYPos = 0;
        int currentXSpeed = xSpeed;
        int currentYSpeed = ySpeed;

        while (currentXPos < maxXTarget && currentYPos > minYTarget) {
            currentXPos += currentXSpeed;
            currentYPos += currentYSpeed;

            if (currentXPos > minXTarget && currentYPos < maxYTarget) {
                return true;
            }

            currentXSpeed = currentXSpeed > 0 ? currentXSpeed - 1 : 0;
            currentYSpeed--;
        }

        return false;
    }

    private static List<Integer> possibleYLaunchSpeeds(int minYTarget, int maxYTarget) {
        List<Integer> possibleYLaunchSpeeds = new ArrayList<>();
        for (int i = 0; i > minYTarget; i--) {
            int currentYPos = 0;
            int currentYSpeed = i;
            while (true) {
                if (currentYPos < minYTarget) {
                    break;
                }
                if (currentYPos < maxYTarget) {
                    possibleYLaunchSpeeds.add(-i);
                }
                currentYSpeed--;
                currentYPos += currentYSpeed;
            }
        }

        possibleYLaunchSpeeds.sort(reverseOrder());// hightest speeds first
        return possibleYLaunchSpeeds;
    }

    private static List<Integer> getPossibleXLaunchSpeeds(int minXTarget, int maxXTarget) {
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

        List<Integer> possibleXLaunchSpeeds = new ArrayList<>();
        for (int possibleXLaunchSpeed = minXLaunchSpeed; possibleXLaunchSpeed < maxXTarget; possibleXLaunchSpeed++) {
            int currentXPos = 0;
            int currentXSpeed = possibleXLaunchSpeed;
            while (currentXSpeed > 0) {
                currentXPos += currentXSpeed;
                if (currentXPos > maxXTarget) {
                    break;
                }
                if (currentXPos > minXTarget) {
                    possibleXLaunchSpeeds.add(possibleXLaunchSpeed);
                    break;
                }
                currentXSpeed--;
            }
        }

        sort(possibleXLaunchSpeeds);
        return possibleXLaunchSpeeds;
    }

}