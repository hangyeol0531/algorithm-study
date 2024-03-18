import java.util.Arrays;
import java.util.HashSet;

public class Page113 {
    public static int[] solution(int[] numbers) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) {
                    continue;
                }
                hashSet.add(numbers[i] + numbers[j]);
            }
        }
        return hashSet.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 3, 4, 1})));
        System.out.println(Arrays.toString(solution(new int[]{5, 0, 2, 7})));
    }
}