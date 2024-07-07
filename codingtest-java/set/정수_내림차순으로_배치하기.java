import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class 정수_내림차순으로_배치하기 {

    public static Long solution(long n) {
        String[] chars = Long.toString(n).split("");
        String result = Arrays.stream(chars)
            .sorted(Comparator.comparingLong(o -> Long.parseLong(o.toString())).reversed())
            .collect(Collectors.joining());
        return Long.parseLong(result);
    }

    public static void main(String[] args) {
        System.out.println(solution(118372));
    }
}