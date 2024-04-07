import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class 폰켓몬 {

    public static int solution(int[] nums) {
        Set<Integer> set = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toSet());

        int getCount = nums.length / 2;
        return Math.min(set.size(), getCount);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2, 3}));
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 4}));
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 2}));
    }
}