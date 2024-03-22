import java.util.Arrays;

public class _주식가격 {

    public static int[] solution(int[] prices) {

        int[] result = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                count++;
                if (i == prices.length - 1) {
                    count = 0;
                    break;
                }

                if (prices[i] > prices[j]) {
                    break;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
    }
}