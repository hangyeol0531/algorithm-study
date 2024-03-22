import java.util.Stack;

public class 크레인_인형뽑기_게임_Stack {

    public static int solution(int[][] board, int[] moves) {

        Stack<Integer>[] stacks = new Stack[board.length];
        for (int i = 0; i < board.length; i++) {
            stacks[i] = new Stack<>();
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = board[0].length - 1; j >= 0; j--) {
                int target = board[j][i];
                if (target != 0) {
                    stacks[i].push(target);
                }
            }
        }

        int answer = 0;
        Stack<Integer> targetStack = new Stack<>();
        for (int move : moves) {
            Stack<Integer> stack = stacks[move - 1];
            if (stack.empty()) {
                continue;
            }
            Integer target = stack.pop();
            if (!targetStack.empty() && targetStack.peek() == target) {
                targetStack.pop();
                answer += 2;
            } else {
                targetStack.push(target);
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