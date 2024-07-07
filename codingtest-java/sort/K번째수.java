import java.util.ArrayList;
import java.util.Arrays;

public class K번째수 {

    public static int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];

            int[] sliceArr = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(sliceArr);
            result.add(sliceArr[k - 1]);
        }

        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
            new int[]{1, 5, 2, 6, 3, 7, 4},
            new int[][]{
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
            }
        )));
    }
}