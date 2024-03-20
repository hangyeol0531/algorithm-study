import java.util.Stack;

public class 올바른_괄호 {

    public static boolean solution(String str) {
        Stack<Character> stack = new Stack<>();

        char[] chars = str.toCharArray();

        for (char ch : chars) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.pop() == ')') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }
}