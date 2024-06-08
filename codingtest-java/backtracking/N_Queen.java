public class N_Queen {

    private static int n;
    private static boolean[][] board;
    private static int answer = 0;
    private static boolean[] leftDiagonal;
    private static boolean[] rightDiagonal;

    public static int solution(int _n) {
        n = _n;
        board = new boolean[n][n];
        leftDiagonal = new boolean[n * 2];
        rightDiagonal = new boolean[n * 2];
        find(0, 0);
        return answer;
    }

    private static void find(int startY, int cnt) {
        if (cnt == board.length) {
            answer++;
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isValid(startY, j)) {
                board[startY][j] = true;
                leftDiagonal[n - startY + j] = true;
                rightDiagonal[startY + j] = true;

                find(startY + 1, cnt + 1);

                board[startY][j] = false;
                leftDiagonal[n - startY + j] = false;
                rightDiagonal[startY + j] = false;
            }
        }
    }

    private static boolean isValid(int queenY, int queenX) {
        // 현재 위치에 가능한지
        if (board[queenY][queenX]) {
            return false;
        }

        // x축 또는 y축에 있는지
        for (int i = 0; i < board.length; i++) {
            if (board[queenY][i] || board[i][queenX]) {
                return false;
            }
        }
        // 대각선에 있는지
        if (leftDiagonal[n - queenY + queenX] || rightDiagonal[queenY + queenX]) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}