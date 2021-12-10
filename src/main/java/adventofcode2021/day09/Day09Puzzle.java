package adventofcode2021.day09;

import java.util.List;

/**
 * @author Mike Schmid
 */
public class Day09Puzzle {

    public static int solve(final List<String> input) {
        int[][] array = mapToIntMatrix(input);

        int sumOfMinimums = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (!hasSmallerNeighbour(array, i, j)) {
                    sumOfMinimums += (array[i][j] + 1);
                }
            }
        }

        return sumOfMinimums;
    }

    private static int[][] mapToIntMatrix(List<String> input) {
        int[][] array = new int[input.size()][input.get(0).length()];

        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);
            for (int j = 0; j < line.length(); j++) {
                array[i][j] = line.charAt(j) - '0';
            }
        }

        return array;
    }

    private static boolean hasSmallerNeighbour(int[][] array, int i, int j) {
        int current = array[i][j];
        return (j > 0 && array[i][j - 1] <= current) ||                     // left neighbour is smaller
                (j < array[0].length - 1 && array[i][j + 1] <= current) ||  // right neighbour is smaller
                (i > 0 && array[i - 1][j] <= current) ||                    // above neighbour is smaller
                (i < array.length - 1 && array[i + 1][j] <= current);       // below neighbour is smaller
    }

}