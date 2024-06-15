import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 외벽_점검 {

    private static boolean[] isVisited;
    private static int wallLength;
    private static int answer;
    private static List<Integer> weakList;

    public static int solution(int n, int[] weak, int[] dist) {
        isVisited = new boolean[n];
        wallLength = n;

        answer = -1;
        weakList = Arrays.stream(weak).boxed().collect(Collectors.toList());

        for (int i = 0; i < n; i++) {
            isVisited[i] = !weakList.contains(i);
        }

        List<Integer> distances = Arrays.stream(dist)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        for (int i = 0; i < distances.size(); i++) {
            ArrayList<Integer> sortedDist = new ArrayList<>();
            if (i == weak.length) {
                answer = i;
                break;
            }
            for (int j = 0; j <= i; j++) {
                sortedDist.add(distances.get(j));
            }
            if (find(sortedDist, 0)) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }

    public static boolean find(List<Integer> sortedDist, int idx) {
        if (weakList.stream().allMatch(weak -> isVisited[weak])) {
            return true;
        }

        if (sortedDist.size() == idx) {
            return false;
        }

        Integer distance = sortedDist.get(idx);
        for (int i = 0; i < wallLength; i++) {
            List<Integer> findWeaks = wallSearch(i, distance);
            if (findWeaks.isEmpty()) {
                continue;
            }
            if (find(sortedDist, idx + 1)) {
                return true;
            }
            for (int weak : findWeaks) {
                isVisited[weak] = false;
            }
        }
        return false;
    }

    public static List<Integer> wallSearch(int start, int num) {
        List<Integer> findWeaks = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            int idx = (start + i) % wallLength;
            if (!isVisited[idx]) {
                isVisited[idx] = true;
                findWeaks.add(idx);
            }
        }
        return findWeaks;
    }

    public static void main(String[] args) {
        System.out.println(solution(12, new int[]{1, 5, 6, 10}, new int[]{1, 2, 3, 4}));
        System.out.println(solution(12, new int[]{1, 3, 4, 9, 10}, new int[]{3, 5, 7}));
        System.out.println(solution(200, new int[]{0, 10, 50, 80, 120, 160}, new int[]{1, 10, 5, 40, 30}));
    }
}