import java.util.ArrayDeque;

public class 요세푸스_문제 {

    public static int solution(int n, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 2));
    }
}