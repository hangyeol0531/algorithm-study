import java.util.Arrays;

public class MergeSort {

    public static int[] solution(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < arr1.length && pointer2 < arr2.length) {
            result[pointer1 + pointer2] = arr1[pointer1] > arr2[pointer2] ? arr2[pointer2++] : arr1[pointer1++];
        }

        while (pointer1 < arr1.length) {
            result[pointer1 + pointer2] = arr1[pointer1++];
        }

        while (pointer2 < arr2.length) {
            result[pointer1 + pointer2] = arr2[pointer2++];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 5}, new int[]{2, 4, 6})));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3}, new int[]{4, 5, 6})));
    }
}