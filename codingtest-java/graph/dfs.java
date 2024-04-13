import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class dfs {


    public static List<Integer> result;
    public static List<Integer>[] graphs;
    public static boolean[] isVisited;

    public static int[] solution(int[][] graph, int start, int n) {
        result = new ArrayList<>();
        graphs = new ArrayList[n + 1];
        isVisited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int[] gr : graph) {
            graphs[gr[0]].add(gr[1]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        dfs(stack);

        return result.stream()
            .mapToInt(v -> v)
            .toArray();
    }

    public static void dfs(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }

        Integer pop = stack.pop();
        result.add(pop);
        isVisited[pop] = true;

        graphs[pop].stream()
            .sorted(((o1, o2) -> o2 - o1))
            .filter(child -> !isVisited[child])
            .forEach(stack::push);

        dfs(stack);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}, 1, 5)));
        System.out.println(Arrays.toString(solution(new int[][]{{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {5, 6}}, 1, 6)));
    }
}