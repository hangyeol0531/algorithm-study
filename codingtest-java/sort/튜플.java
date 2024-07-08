import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 튜플 {

    public static int[] solution(String s) {
        ArrayList<Integer> result = new ArrayList<>();
        String replacedStr = s.substring(0, s.length() - 2).replace("{", "");
        String[] strs = replacedStr.split("},");

        Arrays.sort(strs, (Comparator.comparingInt(String::length)));

        for (String str : strs) {
            String[] numbers = str.split(",");
            for (String number : numbers) {
                Integer i = Integer.valueOf(number);
                if (!result.contains(i)) {
                    result.add(i);
                }
            }
        }
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(solution("{{20,111},{111}}")));
        System.out.println(Arrays.toString(solution("{{123}}")));
        System.out.println(Arrays.toString(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }
}