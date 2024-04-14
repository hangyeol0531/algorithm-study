import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class dijkstra {

    private static int[] result;
    private static List<Node>[] nodes;

    private static class Node {
        int destination;
        int weight;

        public Node(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static int[] solution(int[][] graph, int start, int n) {
        result = new int[n];
        nodes = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for (int[] gr : graph) {
            nodes[gr[0]].add(new Node(gr[1], gr[2]));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        queue.add(new Node(start, 0));
        search(queue);

        return result;
    }

    public static void search(PriorityQueue<Node> queue) {
        if (queue.isEmpty()) {
            return;
        }
        Node node = queue.poll();
        int destination = node.destination;
        int weight = node.weight;

        result[destination] = Math.min(result[destination], weight);

        nodes[destination].stream()
            .filter(_node -> result[_node.destination] > _node.weight + weight)
            .forEach(_node -> queue.add(new Node(_node.destination, _node.weight + weight)));
        search(queue);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{0, 1, 9}, {0, 2, 3}, {1, 0, 5}, {2, 1, 1}}, 0, 3)));
        System.out.println(Arrays.toString(solution(new int[][]{{0, 1, 1}, {1, 2, 5}, {2, 3, 1}}, 0, 4)));
    }
}