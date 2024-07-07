import java.util.Arrays;

public class 가장_큰_수 {

    public static String solution(int[] numbers) {
        String[] strs = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((o1, o2) -> {
                Integer compare1 = Integer.parseInt(o1 + o2);
                Integer compare2 = Integer.parseInt(o2 + o1);
                return compare2 - compare1;
            })
            .toArray(String[]::new);

        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str);
        }

        String result = builder.toString();
        if (result.charAt(0) == '0') {
            return "0";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
    }
}