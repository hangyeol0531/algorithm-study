import java.util.Arrays;
import java.util.Stack;

public class 표_편집 {

    public static String solution(int n, int k, String[] cmd) {

        int up[] = new int[n + 2];
        int down[] = new int[n + 2];

        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        int select = k + 1;

        Stack<Integer> deleteStack = new Stack<>();
        for (String c : cmd) {
            char command = c.charAt(0);
            if (command == 'C') {
                deleteStack.push(select);
                up[down[select]] = up[select];
                down[up[select]] = down[select];
                select = down[select] > n ? up[select] : down[select];
            } else if (command == 'Z') {
                int restore = deleteStack.pop();
                up[down[restore]] = restore;
                down[up[restore]] = restore;
            } else {
                int num = Integer.parseInt(c.substring(2));
                for (int i = 0; i < num; i++) {
                    select = command == 'U' ? up[select] : down[select];
                }
            }
        }

        char answer[] = new char[n];
        Arrays.fill(answer, 'O');

        for (int s : deleteStack) {
            answer[s - 1] = 'X';
        }

        return new String(answer);
    }

    public static void main(String[] args) {
        System.out.println(
            solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"})
        );
        System.out.println(
            solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"})
        );
    }
}