import java.util.Stack;

public class _10진수를_2진수로_변환하기 {

    public static String solution(int decimal) {
        Stack<Integer> stack = new Stack<>();

        while (decimal != 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(27));
        System.out.println(solution(12345));
    }
}