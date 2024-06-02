import java.util.ArrayList;
import java.util.Arrays;

public class OneToNSum10 {

    private static ArrayList<ArrayList<Integer>> result;
    private static int input;

    public static int[][] solution(int n) {
        result = new ArrayList<>();
        input = n;

        backTracking(0, new ArrayList<>(), 1);

        return result.stream()
            .map(arr -> arr.stream().mapToInt(Integer::intValue).toArray())
            .toArray(int[][]::new);
    }

    public static void backTracking(int sum, ArrayList<Integer> selected, int start) {
        if (sum == 10) {
            result.add(selected);
            return;
        }

        for (int i = start; i <= input; i++) {
            if (sum + i <= 10) {
                ArrayList<Integer> cloneSelected = new ArrayList<>(selected);
                cloneSelected.add(i);
                backTracking(sum + i, cloneSelected, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(5)));
        System.out.println(Arrays.deepToString(solution(2)));
        System.out.println(Arrays.deepToString(solution(7)));
    }
}