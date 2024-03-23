import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;

public class 카드_뭉치 {

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque cards1Queue = new ArrayDeque(Arrays.asList(cards1));
        ArrayDeque<String> cards2Queue = new ArrayDeque(Arrays.asList(cards2));
        ArrayDeque<String> goalQueue = new ArrayDeque(Arrays.asList(goal));

        while (!goalQueue.isEmpty()) {
            String goalPeek = goalQueue.peek();

            if (Objects.equals(goalPeek, cards1Queue.peek())) {
                goalQueue.poll();
                cards1Queue.poll();
                continue;
            }

            if (Objects.equals(goalPeek, cards2Queue.peek())) {
                goalQueue.poll();
                cards2Queue.poll();
                continue;
            }
            return "No";
        }

        return "Yes";
    }

    public static void main(String[] args) {
        System.out.println(solution(
            new String[]{"i", "drink", "water"},
            new String[]{"want", "to"},
            new String[]{"i", "want", "to", "drink", "water"}
        ));
        System.out.println(solution(
            new String[]{"i", "water", "drink"},
            new String[]{"want", "to"},
            new String[]{"i", "want", "to", "drink", "water"}
        ));
    }
}