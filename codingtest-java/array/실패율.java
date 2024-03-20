import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 실패율 {

    public static int[] solution(int N, int[] stages) {
        Map<Integer, Float> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            int not_clear = 0;
            int clear = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] >= i) {
                    clear++;
                    if (stages[j] == i) {
                        not_clear++;
                    }
                }
            }
            float rate = clear == 0 ? 0 : (float) not_clear / (float) clear;
            map.put(i, rate);
        }

        return map.entrySet().stream().sorted((o1, o2) -> Float.compare(o2.getValue(), o1.getValue()))
            .mapToInt(Map.Entry::getKey)
            .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[]{4, 4, 4, 4})));
    }
}