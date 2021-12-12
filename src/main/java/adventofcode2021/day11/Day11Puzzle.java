package adventofcode2021.day11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mike Schmid
 */
public class Day11Puzzle {

    public static long solve(final List<String> input) {
        List<Octopus> octopi = createOctopi(input);
        int numberOfFlashes = 0;

        for (int i = 0; i < 100; i++) {
            octopi.forEach(Octopus::updateFlashes);
            numberOfFlashes += octopi.stream()
                    .filter(Octopus::hasFlashed)
                    .count();
            octopi.forEach(Octopus::resetFlash);
        }

        return numberOfFlashes;
    }

    private static List<Octopus> createOctopi(List<String> input) {
        List<Octopus> octopusList = new ArrayList<>();

        Octopus[][] octopi = new Octopus[input.size()][input.get(0).length()];
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(0).length(); j++) {
                Octopus octopus = new Octopus(input.get(i).charAt(j) - '0');
                octopi[i][j] = octopus;
                octopusList.add(octopus);
            }
        }
        addNeighbours(octopi);

        return octopusList;
    }

    private static void addNeighbours(Octopus[][] octopi) {
        for (int i = 0; i < octopi.length; i++) {
            for (int j = 0; j < octopi[0].length; j++) {
                if (isValid(i - 1, j)) octopi[i - 1][j].addNeighbour(octopi[i][j]);
                if (isValid(i, j - 1)) octopi[i][j - 1].addNeighbour(octopi[i][j]);
                if (isValid(i + 1, j)) octopi[i + 1][j].addNeighbour(octopi[i][j]);
                if (isValid(i, j + 1)) octopi[i][j + 1].addNeighbour(octopi[i][j]);

                if (isValid(i - 1, j - 1)) octopi[i - 1][j - 1].addNeighbour(octopi[i][j]);
                if (isValid(i + 1, j + 1)) octopi[i + 1][j + 1].addNeighbour(octopi[i][j]);
                if (isValid(i - 1, j + 1)) octopi[i - 1][j + 1].addNeighbour(octopi[i][j]);
                if (isValid(i + 1, j - 1)) octopi[i + 1][j - 1].addNeighbour(octopi[i][j]);
            }
        }
    }

    private static boolean isValid(int i, int j) {
        return j >= 0 && j < 10 && i >= 0 && i < 10;
    }

}