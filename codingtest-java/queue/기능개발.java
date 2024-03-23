import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 기능개발 {

    public static int[] solution(int[] progresses, int[] speeds) {

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        Map<Integer, Integer> progressMap = new HashMap<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(i);
            progressMap.put(i, progresses[i]);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {

            for (int i = 0; i < speeds.length; i++) {
                Integer progress = progressMap.get(i);
                progressMap.put(i, progress + speeds[i]);
            }

            int completeCount = 0;

            while (!queue.isEmpty()) {
                int workNumber = queue.peek();
                if (progressMap.get(workNumber) >= 100) {
                    queue.poll();
                    completeCount++;
                    continue;
                }
                break;
            }
            if (completeCount > 0) {
                result.add(completeCount);
            }
        }
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        System.out.println(Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
    }
}