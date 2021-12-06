package adventofcode2021.day06;

import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.apache.commons.lang3.StringUtils.split;

/**
 * @author Mike Schmid
 */
public class Day06Puzzle2 {

    public static long solve(final String input) {

        final Map<Integer, Long> fishPerLifetime = getInitialNumberOfFish(input); // key = lifetime / value = number of fish with that lifetime

        for (int i = 0; i < 256; i++) {
            long oldGeneration = fishPerLifetime.get(0); // these will be reborn

            for (int j = 0; j < 8; j++) {
                fishPerLifetime.put(j, fishPerLifetime.get(j + 1)); // reduce the lifetime of all fish
            }

            fishPerLifetime.put(6, fishPerLifetime.get(6) + oldGeneration); // reborn old fish
            fishPerLifetime.put(8, oldGeneration); // freshly born fish
        }

        return fishPerLifetime.values().stream().reduce(0L, Long::sum);
    }

    private static Map<Integer, Long> getInitialNumberOfFish(String input) {
        Map<Integer, Long> numberOfFishPerLifeTime = stream(split(input, ","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(groupingBy(identity(), counting()));

        for (int i = 0; i < 9; i++) {
            numberOfFishPerLifeTime.putIfAbsent(i, 0L);
        }

        return numberOfFishPerLifeTime;
    }


}