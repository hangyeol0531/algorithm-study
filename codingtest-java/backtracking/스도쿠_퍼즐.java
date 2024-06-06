import java.util.Arrays;
import java.util.Objects;

public class 스도쿠_퍼즐 {

    private static int[][] board;

    private static class Cell {
        int x, y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Cell findEmptyCell() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return new Cell(j, i);
                }
            }
        }
        return null;
    }

    private static boolean isValidCell(Cell cell, int num) {
        int x = cell.x;
        int y = cell.y;
        // 같은 x또는 y 축에 있는지
        for (int i = 0; i < 9; i++) {
            if (board[i][x] == num || board[y][i] == num) {
                return false;
            }
        }

        // 같은 3*3 면에 있는지
        int xGroup = (x / 3) * 3;
        int yGroup = (y / 3) * 3;
        for (int i = yGroup; i < yGroup + 3; i++) {
            for (int j = xGroup; j < xGroup + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }


    private static boolean findCell() {
        Cell emptyCell = findEmptyCell();
        if (Objects.isNull(emptyCell)) {
            return true;
        }

        for (int i = 1; i <= 9; i++) {
            if (isValidCell(emptyCell, i)) {
                board[emptyCell.y][emptyCell.x] = i;
                if (findCell()) {
                    return true;
                }
                board[emptyCell.y][emptyCell.x] = 0;
            }
        }
        return false;
    }

    private static int[][] solution(int[][] _board) {
        board = _board;
        findCell();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        return board;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][]{
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        })));

        System.out.println(Arrays.deepToString(solution(new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        })));
    }
}