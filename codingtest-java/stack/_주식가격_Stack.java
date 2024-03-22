import java.util.Arrays;
import java.util.Stack;

public class _주식가격_Stack {

    public static int[] solution(int[] prices) {
        int[] answers = new int[prices.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.empty() && prices[stack.peek()] > prices[i]) {
                int num = stack.pop();
                answers[num] = i - num;
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            int num = stack.pop();
            answers[num] = prices.length - num - 1;
        }
        return answers;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
    }
}