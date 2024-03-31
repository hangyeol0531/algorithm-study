import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class 양과_늑대 {

    private static List<Integer>[] tree;

    public static void setTree(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];

        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }

    }

    public static class Info {
        int idx, sheep, wolf;
        Set<Integer> visit;

        public Info(int idx, int sheep, int wolf, Set<Integer> visit) {
            this.idx = idx;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visit = visit;
        }
    }

    public static int solution(int[] info, int[][] edges) {
        setTree(info, edges);
        int answer = 0;

        Queue<Info> queue = new ArrayDeque<>();
        queue.add(new Info(0, 1, 0, new HashSet<>()));

        while (!queue.isEmpty()) {
            Info now = queue.poll();
            answer = Math.max(answer, now.sheep);

            now.visit.addAll(tree[now.idx]);

            for (int next : now.visit) {
                Set<Integer> set = new HashSet<>(now.visit);
                set.remove(next);

                if (info[next] == 1) { // 늑대인 경우
                    if (now.sheep > now.wolf + 1) {
                        queue.add(new Info(next, now.sheep, now.wolf + 1, set));
                    }
                } else { // 양인 경우
                    queue.add(new Info(next, now.sheep + 1, now.wolf, set));
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        System.out.println(solution(
            new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
            new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}}
        ));

        System.out.println(solution(
            new int[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0},
            new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}}
        ));
    }
}