import java.util.Arrays;
import java.util.Comparator;

public class 섬_연결하기 {

    private static int[] parent;

    public static int solution(int n, int[][] costs) {
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

        int answer = 0;

        for (int cost[] : costs) {
            if (find(cost[0]) != find(cost[1])) {
                union(cost[0], cost[1]);
                answer += cost[2];
            }
        }
        return answer;
    }

    public static void union(int x, int y) {
        int xFind = find(x);
        int yFind = find(y);
        parent[yFind] = xFind;
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return find(parent[x]);
    }


    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }
}