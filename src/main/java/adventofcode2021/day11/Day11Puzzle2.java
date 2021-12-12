package adventofcode2021.day11;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.*;

/**
 * @author Mike Schmid
 */
public class Day11Puzzle2 {

    public static long solve(final List<String> input) {
        List<Octopus> octopi = createOctopi(input);

        for (int i = 0; i < MAX_VALUE; i++) {
            octopi.forEach(Octopus::updateFlashes);
            if(octopi.stream().allMatch(Octopus::hasFlashed)){
                return i+1;
            }
            octopi.forEach(Octopus::resetFlash);
        }

        return -1;
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