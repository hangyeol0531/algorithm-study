import java.util.Arrays;
import java.util.Comparator;

public class 문자열_내_마음대로_정렬하기 {

    public static String[] solution(String[] strs, int n) {
        return Arrays.stream(strs)
            .sorted((Comparator.comparing((String o) -> o.charAt(n)))
                .thenComparing(o -> o))
            .toArray(String[]::new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
            new String[]{"sun", "bed", "car"},
            1
        )));

        System.out.println(Arrays.toString(solution(
            new String[]{"abce", "abcd", "cdx"},
            2
        )));
    }
}