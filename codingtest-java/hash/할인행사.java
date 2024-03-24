import java.util.HashMap;

public class 할인행사 {

    public static int solution(String[] want, int[] number, String[] discount) {
        int result = 0;
        HashMap<String, Integer> wantHashMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantHashMap.put(want[i], number[i]);
        }

        A:
        for (int i = 0; i < discount.length; i++) {
            HashMap<String, Integer> discountHashMap = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                if (j == discount.length) {
                    break;
                }
                String discountItem = discount[j];
                discountHashMap.put(discountItem, discountHashMap.getOrDefault(discountItem, 0) + 1);
            }

            // valid
            for (String wantItem : want) {
                Integer wantItemCount = wantHashMap.getOrDefault(wantItem, 0);
                Integer discountItemCount = discountHashMap.getOrDefault(wantItem, 0);
                if (wantItemCount > discountItemCount) {
                    continue A;
                }
            }
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(
            new String[]{"banana", "apple", "rice", "pork", "pot"},
            new int[]{3, 2, 2, 2, 1},
            new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}
        ));
        System.out.println(solution(
                new String[]{"apple"},
                new int[]{10},
                new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}
            )
        );
    }
}