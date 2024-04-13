import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bfs {

    public static boolean[] isVisited;
    public static List<Integer> result;
    public static List<Integer>[] graphs;

    public static int[] solution(int[][] graph, int start, int n) {
        result = new ArrayList<>();
        isVisited = new boolean[n + 1];
        graphs = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int[] gr : graph) {
            graphs[gr[0]].add(gr[1]);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        bfs(queue);

        return result.stream()
            .mapToInt(v -> v)
            .toArray();
    }

    public static void bfs(ArrayDeque<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }

        Integer element = queue.poll();
        if (!isVisited[element]) {
            result.add(element);
            isVisited[element] = true;
            graphs[element].stream()
                .filter(ele -> !isVisited[ele])
                .sorted()
                .forEach(queue::add);
        }
        bfs(queue);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {5, 8}, {6, 9}, {7, 9}}, 1, 9)));
        System.out.println(Arrays.toString(solution(new int[][]{{1, 3}, {3, 4}, {3, 5}, {5, 2}}, 1, 5)));
    }
}