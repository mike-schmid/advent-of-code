package adventofcode2021.day06;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.split;

/**
 * @author Mike Schmid
 */
public class Day06Puzzle {

    public static long solve(final String input) {

        List<Integer> fishes = stream(split(input, ","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(toList());

        for (int i = 0; i < 80; i++) {
            int fishesToAdd = 0;
            for (int j = 0; j < fishes.size(); j++) {
                Integer lifetime = fishes.get(j);
                if (lifetime == 0) {
                    fishes.set(j, 6);
                    fishesToAdd++;
                } else {
                    fishes.set(j, lifetime - 1);
                }
            }

            for (int k = 0; k < fishesToAdd; k++) {
                fishes.add(8);
            }

        }

        return fishes.size();
    }

}