package adventofcode2021.day04;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.split;

/**
 * @author Mike Schmid
 */
public class Day04Puzzle2 {

    public static int solve(final List<String> input) {

        final List<Integer> numbers = getBingoNumbers(input);
        final List<BingoBoard> boards = getBingoBoards(input);

        BingoBoard lastCompleteBingoBoard = boards.get(0);
        for (Integer number : numbers) {
            for (BingoBoard board : boards) {
                board.markNumber(number);
            }

            boards.removeIf(BingoBoard::isBingo);

            if (boards.size() == 1) {
                lastCompleteBingoBoard = boards.get(0); //remember the board but continue playing
            }

            if (boards.isEmpty()) {
                return lastCompleteBingoBoard.calculateScore(number);
            }
        }

        return -1;
    }

    private static List<Integer> getBingoNumbers(List<String> input) {
        return stream(split(input.get(0), ","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(toList());
    }

    private static List<BingoBoard> getBingoBoards(List<String> input) {
        List<BingoBoard> boards = new ArrayList<>();

        for (int i = 2; i < input.size(); i += 6) {
            List<Integer> boardNumbers = new ArrayList<>();
            boardNumbers.addAll(getBoardNumberLine(input, i));
            boardNumbers.addAll(getBoardNumberLine(input, i + 1));
            boardNumbers.addAll(getBoardNumberLine(input, i + 2));
            boardNumbers.addAll(getBoardNumberLine(input, i + 3));
            boardNumbers.addAll(getBoardNumberLine(input, i + 4));
            boards.add(new BingoBoard(boardNumbers));
        }

        return boards;
    }

    private static List<Integer> getBoardNumberLine(List<String> input, int i) {
        return stream(split(input.get(i)))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(toList());
    }

}