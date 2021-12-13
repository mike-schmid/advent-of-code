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
public class Day13Puzzle {

    public static long solve(final List<String> input) {

        final List<Fold> folds = getFolds(input);
        final Set<Point> points = getPoints(input);

        return foldPoints(points, folds.get(0)).size();
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
            } else {
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

    private record Point(int x, int y) {
    }

    private record Fold(String axis, int amount) {
    }

}