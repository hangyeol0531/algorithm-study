import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 간단한_유니온_파인드_알고리즘 {

    private static int[] parent;

    public static Boolean[] solution(int k, int[][] operations) {
        List<Boolean> resultList = new ArrayList<>();

        parent = new int[k];
        for (int i = 0; i < k; i++) {
            parent[i] = i;
        }

        for (int[] operation : operations) {
            int command = operation[0];

            if (command == 0) {
                // union
                union(operation[1], operation[2]);
            } else {
                // find
                resultList.add(getRoot(operation[1]) == getRoot(operation[2]));
            }
        }
        return resultList.toArray(Boolean[]::new);
    }

    // x, y의 rank를 구해 rank가 낮은 트리를 높은 트리에 추가
    private static void union(int x, int y) {
        int xRoot = getRoot(x);
        int yRoot = getRoot(y);
        parent[yRoot] = xRoot;
    }

    private static int getRoot(int idx) {
        int parentIdx = parent[idx];
        while (true) {
            if (parentIdx == parent[parentIdx]) {
                break;
            }
            parentIdx = parent[parentIdx];
        }
        return parentIdx;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[][]{{0, 0, 1}, {0, 1, 2}, {1, 1, 2}})));
        System.out.println(Arrays.toString(solution(4, new int[][]{{0, 0, 1}, {1, 1, 2}, {0, 1, 2}, {1, 0, 2}})));
    }
}