package adventofcode2021.day04;

import java.util.ArrayList;
import java.util.List;

public class BingoBoard {

    private final List<Integer> boardNumbers;
    private final List<Integer> markedNumbers = new ArrayList<>();

    public BingoBoard(List<Integer> boardNumbers) {
        this.boardNumbers = boardNumbers;
    }

    public void markNumber(Integer number) {
        if (boardNumbers.contains(number)) {
            markedNumbers.add(number);
        }
    }

    public boolean isBingo() {
        return isRowBingo() || isColumnBingo();
    }

    public int calculateScore(int currentNumber) {
        return boardNumbers.stream()
                .mapToInt(Integer::intValue)
                .filter(n -> !markedNumbers.contains(n))
                .sum() * currentNumber;
    }

    private boolean isRowBingo() {
        for (int i = 0; i < boardNumbers.size(); i += 5) {
            if (markedNumbers.contains(boardNumbers.get(i))
                    && markedNumbers.contains(boardNumbers.get(i + 1))
                    && markedNumbers.contains(boardNumbers.get(i + 2))
                    && markedNumbers.contains(boardNumbers.get(i + 3))
                    && markedNumbers.contains(boardNumbers.get(i + 4))) {
                return true;
            }
        }

        return false;
    }

    private boolean isColumnBingo() {
        for (int i = 0; i < boardNumbers.size() / 5; i++) {
            if (markedNumbers.contains(boardNumbers.get(i))
                    && markedNumbers.contains(boardNumbers.get(i + 5))
                    && markedNumbers.contains(boardNumbers.get(i + 10))
                    && markedNumbers.contains(boardNumbers.get(i + 15))
                    && markedNumbers.contains(boardNumbers.get(i + 20))) {
                return true;
            }
        }

        return false;
    }

}
