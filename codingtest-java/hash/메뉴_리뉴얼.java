import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 메뉴_리뉴얼 {

    private static HashMap<Integer, HashMap<String, Integer>> orderSet = new HashMap<>();

    public static String[] solution(String[] orders, int[] course) {
        orderSet.clear();

        for (String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            combination(0, chars, "");
        }

        List<String> result = new ArrayList<>();
        for (int _course : course) {
            HashMap<String, Integer> hashmap = orderSet.getOrDefault(_course, new HashMap<>());
            int max = hashmap.values().stream()
                .mapToInt(m -> m)
                .max()
                .orElse(2);

            if (max < 2) {
                continue;
            }

            hashmap.entrySet().stream()
                .filter(entry -> entry.getValue() == max)
                .map(Map.Entry::getKey)
                .forEach(result::add);
        }

        return result.stream().sorted().toArray(String[]::new);
    }

    public static void combination(int idx, char[] chars, String str) {
        if (str.length() > 0) {
            HashMap<String, Integer> hashMap = orderSet.getOrDefault(str.length(), new HashMap<>());
            hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);
            orderSet.put(str.length(), hashMap);
        }

        for (int i = idx; i < chars.length; i++) {
            combination(i + 1, chars, str + chars[i]);
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
            new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
            new int[]{2, 3, 4}
        )));

        System.out.println(Arrays.toString(solution(
            new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
            new int[]{2, 3, 5}
        )));

        System.out.println(Arrays.toString(solution(
            new String[]{"XYZ", "XWY", "WXA"},
            new int[]{2, 3, 4}
        )));
    }
}