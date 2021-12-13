package adventofcode2021.day13;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.apache.commons.lang3.StringUtils.*;

/**
 * @author Mike Schmid
 */
public class Day13Puzzle2 {

    public static String solve(final List<String> input) {

        final List<Fold> folds = getFolds(input);

        Set<Point> points = getPoints(input);
        for (Fold fold : folds) {
            points = foldPoints(points, fold);
        }

        return decodePoints(points);
    }

    private static Set<Point> foldPoints(Set<Point> points, Fold fold) {
        Set<Point> foldedPoints = new HashSet<>();
        for (Point point : points) {
            if (fold.axis().equals("x")) {
                if (point.x() < fold.amount()) {
                    foldedPoints.add(point);
                } else {
                    int newX = fold.amount() - (point.x() - fold.amount());
                    foldedPoints.add(new Point(newX, point.y()));
                }
            }
            if (fold.axis().equals("y")) {
                if (point.y() < fold.amount()) {
                    foldedPoints.add(point);
                } else {
                    int newY = fold.amount() - (point.y() - fold.amount());
                    foldedPoints.add(new Point(point.x(), newY));
                }
            }
        }
        return foldedPoints;
    }


    private static Set<Point> getPoints(List<String> input) {
        return input.stream()
                .filter(s -> contains(s, ","))
                .map(s -> new Point(parseInt(substringBefore(s, ",")), parseInt(substringAfter(s, ","))))
                .collect(toSet());
    }

    private static List<Fold> getFolds(List<String> input) {
        return input.stream()
                .filter(s -> startsWith(s, "fold along "))
                .map(s -> new Fold(substringBetween(s, "fold along ", "="), parseInt(substringAfter(s, "="))))
                .collect(toList());
    }

    private static String decodePoints(Set<Point> points) {
        int width = 0;
        int height = 0;

        for (Point point : points) {
            if (point.x() > width) width = point.x();
            if (point.y() > height) height = point.y();
        }

        char[][] array = new char[height + 1][width + 1];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = '.';
            }
        }

        for (Point point : points) {
            array[point.y()][point.x()] = '#';
        }

        StringBuilder sb = new StringBuilder();
        for (char[] chars : array) {
            for (int j = 0; j < array[0].length; j++) {
                sb.append(chars[j]);
            }
            sb.append('\n');
        }

        return sb.toString();
    }

    private record Point(int x, int y) {
    }

    private record Fold(String axis, int amount) {
    }

}