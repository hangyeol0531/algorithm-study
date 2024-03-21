import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 괄호_회전하기 {

    public static int solution(String s) {

        int result = 0;
        int len = s.length();
        s += s;

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        A:
        for (int i = 0; i < len; i++) {
            Stack<Character> stack = new Stack<>();
            for (int j = i; j < len + i; j++) {
                char ch = s.charAt(j);

                if (!map.containsKey(ch)) {
                    stack.push(ch);
                } else {
                    if (stack.empty() || map.get(ch) != stack.pop()) {
                        continue A;
                    }
                }
            }
            if (stack.isEmpty()) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
        System.out.println(solution("}}}"));
        System.out.println(solution("}}}"));
    }
}
