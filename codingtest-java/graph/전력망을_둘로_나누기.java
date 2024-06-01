import java.util.ArrayList;

public class 전력망을_둘로_나누기 {

    public static ArrayList<Integer>[] tree;
    public static boolean[] isVisited;
    public static int total, result;

    public static int solution(int n, int[][] wires) {

        result = Integer.MAX_VALUE;
        tree = new ArrayList[n + 1];
        isVisited = new boolean[n + 1];
        total = n;

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            tree[wire[0]].add(wire[1]);
            tree[wire[1]].add(wire[0]);
        }

        search(1);

        return result;
    }

    public static int search(int num) {
        isVisited[num] = true;
        int sum = 0;
        for (int node : tree[num]) {
            if (!isVisited[node]) {
                int cnt = search(node);
                // group1(total - cnt) - group2(cnt)
                result = Math.min(result, Math.abs(total - cnt * 2));
                sum += cnt;
            }
        }
        return sum + 1;
    }


    public static void main(String[] args) {
        System.out.println(solution(
            9,
            new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}
        ));
        System.out.println(solution(
            4,
            new int[][]{{1, 2}, {2, 3}, {3, 4}}
        ));
        System.out.println(solution(
            7,
            new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}
        ));
    }
}