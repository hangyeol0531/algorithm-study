import java.util.HashSet;

public class 두_개의_수로_특정값_만들기 {

    public static boolean solution(int[] arr, int target) {
        HashSet<Object> set = new HashSet<>();

        for (int ele : arr) {
            set.add(ele);
        }

        for (int ele : arr) {
            int findNumber = target - ele;
            if (ele == findNumber) {
                continue;
            }
            if (set.contains(findNumber)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 8}, 6));
        System.out.println(solution(new int[]{2, 3, 5, 9}, 10));
    }
}