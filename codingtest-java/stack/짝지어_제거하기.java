import java.util.Stack;

public class 짝지어_제거하기 {

    public static int solution(String s) {
        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char ch : chars) {
            if (stack.empty() || stack.peek() != ch) {
                stack.push(ch);
            }else {
                stack.pop();
            }
        }
        return stack.empty() ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }
}