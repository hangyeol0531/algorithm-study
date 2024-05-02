import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class 네트워크 {

    public static List<Integer>[] graph;
    public static boolean[] isVisited;

    public static int solution(int n, int[][] computers) {
        graph = new ArrayList[n + 1];
        isVisited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            isVisited[i] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                int find = computers[j - 1][i - 1];
                if (find == 1) {
                    graph[i].add(j);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                ArrayDeque<Integer> queue = new ArrayDeque<>();
                queue.addFirst(i);
                dfs(queue);
                result++;
            }
        }
        return result;
    }

    public static void dfs(ArrayDeque<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }

        Integer poll = queue.poll();

        if (!isVisited[poll]) {
            queue.addAll(graph[poll]);
            isVisited[poll] = true;
        }
        dfs(queue);
    }

    public static void main(String[] args) {
//        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
//        System.out.println(solution(3, new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
//        System.out.println(solution(4, new int[][]{{1, 1, 0, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 1}}));
//        System.out.println(solution(4, new int[][]{{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}}));
    }
}