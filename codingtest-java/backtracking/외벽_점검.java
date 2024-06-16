import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 외벽_점검 {

    private static boolean[] isVisited;
    private static int wallLength;
    private static int answer;

    public static int solution(int n, int[] weak, int[] dist) {
        isVisited = new boolean[n];
        wallLength = n;
        answer = -1;

        List<Integer> distances = Arrays.stream(dist)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        List<Integer> weakList = Arrays.stream(weak)
            .boxed()
            .collect(Collectors.toList());

        for (int i = 0; i < n; i++) {
            isVisited[i] = !weakList.contains(i);
        }

        ArrayList<Integer> sortedDist = new ArrayList<>();
        for (int i = 0; i < distances.size(); i++) {
            if (i == weak.length) {
                answer = i;
                break;
            }
            sortedDist.add(distances.get(i));
            if (find(sortedDist, weakList, 0)) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }

    public static boolean find(List<Integer> sortedDist, List<Integer> weakList, int idx) {
        if (weakList.isEmpty()) {
            return true;
        }

        if (sortedDist.size() == idx) {
            return false;
        }

        for (int i = 0; i < weakList.size(); i++) {
            int distance = sortedDist.get(idx);
            int diff = (weakList.get((i + 1) % weakList.size()) - weakList.get(i));

            if (diff > 0 && diff > distance) {
                continue;
            } else if (diff < 0 && (wallLength + diff) > distance) {
                continue;
            }

            List<Integer> findWeaks = wallSearch(weakList.get(i), distance);
            List<Integer> remainWeakList = weakList.stream()
                .filter(_weak -> !isVisited[_weak])
                .collect(Collectors.toList());

            if (find(sortedDist, remainWeakList, idx + 1)) {
                return true;
            }
            for (int findWeak : findWeaks) {
                isVisited[findWeak] = false;
            }
        }
        return false;
    }

    public static List<Integer> wallSearch(int start, int distance) {
        List<Integer> findWeaks = new ArrayList<>();
        for (int i = 0; i <= distance; i++) {
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
        System.out.println(solution(200, new int[]{0, 10, 50, 80, 120, 160}, new int[]{10, 11, 12, 13}));
    }
}