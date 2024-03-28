import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class 다단계_칫솔_판매 {

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> parentMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
        }

        HashMap<String, Integer> enrollMap = new HashMap<>();
        for (int i = 0; i < seller.length; i++) {
            share(enrollMap, parentMap, seller[i], amount[i] * 100);
        }

        // result
        int[] result = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            result[i] = enrollMap.getOrDefault(enroll[i], 0);
        }
        return result;
    }

    public static void share(
        HashMap<String, Integer> enrollMap,
        HashMap<String, String> parentMap,
        String seller,
        int amount
    ) {
        String parent = parentMap.get(seller);
        int minusAmount = amount / 10;
        enrollMap.put(seller, enrollMap.getOrDefault(seller, 0) + (amount - minusAmount));
        if (Objects.equals(parent, "-") || minusAmount <= 0) {
            return;
        }
        share(enrollMap, parentMap, parent, minusAmount);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            solution(
                new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10}
            )
        ));

        System.out.println(Arrays.toString(
            solution(
                new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"sam", "emily", "jaimie", "edward"},
                new int[]{2, 3, 5, 4}
            )
        ));
    }
}