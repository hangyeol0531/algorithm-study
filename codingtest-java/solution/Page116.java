import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Page116 {
    public static int[] solution(int[] answers) {

        int[][] studentAnswer = {
            new int[]{1, 2, 3, 4, 5},
            new int[]{2, 1, 2, 3, 2, 4, 2, 5},
            new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] student = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            student[0] = (studentAnswer[0][i % studentAnswer[0].length] == answers[i]) ? ++student[0] : student[0];
            student[1] = (studentAnswer[1][i % studentAnswer[1].length] == answers[i]) ? ++student[1] : student[1];
            student[2] = (studentAnswer[2][i % studentAnswer[2].length] == answers[i]) ? ++student[2] : student[2];
        }
        int max = Arrays.stream(student).max().getAsInt();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < student.length; i++) {
            if (student[i] == max) {
                result.add(i + 1);
            }
        }
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
    }
}