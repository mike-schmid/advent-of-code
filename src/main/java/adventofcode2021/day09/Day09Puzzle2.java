package adventofcode2021.day09;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Comparator.reverseOrder;
import static org.apache.commons.lang3.tuple.Pair.of;

/**
 * @author Mike Schmid
 */
public class Day09Puzzle2 {

    public static int solve(final List<String> input) {
        int[][] array = mapToIntMatrix(input);
        return findMinima(array).stream()
                .map(coordinate -> calculateBasinSize(array, coordinate))
                .sorted(reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .reduce(1, (a, b) -> a * b);
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

    private static List<Pair<Integer, Integer>> findMinima(int[][] array) {
        List<Pair<Integer, Integer>> coordinates = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (!hasSmallerNeighbour(array, i, j)) {
                    coordinates.add(of(i, j));
                }
            }
        }
        return coordinates;
    }

    private static boolean hasSmallerNeighbour(int[][] array, int i, int j) {
        int current = array[i][j];
        return (j > 0 && array[i][j - 1] <= current) ||                     // left neighbour is smaller
                (j < array[0].length - 1 && array[i][j + 1] <= current) ||  // right neighbour is smaller
                (i > 0 && array[i - 1][j] <= current) ||                    // above neighbour is smaller
                (i < array.length - 1 && array[i + 1][j] <= current);       // below neighbour is smaller
    }

    private static Integer calculateBasinSize(int[][] array, Pair<Integer, Integer> coordinate) {
        Set<Pair<Integer, Integer>> pointsInBasin = new HashSet<>();
        exploreNeighbours(pointsInBasin, array, coordinate);
        return pointsInBasin.size();
    }

    private static void exploreNeighbours(Set<Pair<Integer, Integer>> pointsInBasin, int[][] array, Pair<Integer, Integer> current) {
        pointsInBasin.add(current);

        if (current.getRight() > 0 && array[current.getLeft()][current.getRight() - 1] < 9) { // left neighbour is smaller than 9
            Pair<Integer, Integer> leftNeighbour = of(current.getLeft(), current.getRight() - 1);
            if (!pointsInBasin.contains(leftNeighbour)) { // check that we do not check a point twice
                exploreNeighbours(pointsInBasin, array, leftNeighbour);
            }
        }

        if (current.getRight() < array[0].length - 1 && array[current.getLeft()][current.getRight() + 1] < 9) { // right neighbour is smaller than 9
            Pair<Integer, Integer> rightNeighbour = of(current.getLeft(), current.getRight() + 1);
            if (!pointsInBasin.contains(rightNeighbour)) { // check that we do not check a point twice
                exploreNeighbours(pointsInBasin, array, rightNeighbour);
            }
        }

        if (current.getLeft() > 0 && array[current.getLeft() - 1][current.getRight()] < 9) { // above neighbour is smaller than 9
            Pair<Integer, Integer> aboveNeighbour = of(current.getLeft() - 1, current.getRight());
            if (!pointsInBasin.contains(aboveNeighbour)) { // check that we do not check a point twice
                exploreNeighbours(pointsInBasin, array, aboveNeighbour);
            }
        }

        if (current.getLeft() < array.length - 1 && array[current.getLeft() + 1][current.getRight()] < 9) { // right neighbour is smaller than 9
            Pair<Integer, Integer> belowNeighbour = of(current.getLeft() + 1, current.getRight());
            if (!pointsInBasin.contains(belowNeighbour)) { // check that we do not check a point twice
                exploreNeighbours(pointsInBasin, array, belowNeighbour);
            }
        }

    }

}