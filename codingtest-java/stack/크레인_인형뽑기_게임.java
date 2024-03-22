import java.util.Stack;

public class 크레인_인형뽑기_게임 {

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int depth = board.length;

        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            move -= 1;

            int target = 0;
            for (int i = 0; i < depth; i++) {
                if (board[i][move] != 0) {
                    target = board[i][move];
                    board[i][move] = 0;
                    break;
                }
            }

            if (target != 0) {
                if (!stack.empty() && stack.peek() == target) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(target);
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(
            solution(
                new int[][]{
                    {0, 0, 0, 0, 0},
                    {0, 0, 1, 0, 3},
                    {0, 2, 5, 0, 1},
                    {4, 2, 4, 4, 2},
                    {3, 5, 1, 3, 1}
                },
                new int[]{1, 5, 3, 5, 1, 2, 1, 4}
            )
        );
    }
}