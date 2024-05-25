import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class 배달 {

    private static int[] weights;
    private static List<Node>[] nodes;

    private static class Node {
        int destination;
        int weight;

        public Node(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static int solution(int n, int[][] roads, int k) {
        weights = new int[n + 1];
        nodes = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
            weights[i] = Integer.MAX_VALUE;
        }

        for (int[] roda : roads) {
            nodes[roda[0]].add(new Node(roda[1], roda[2]));
            nodes[roda[1]].add(new Node(roda[0], roda[2]));
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(1, 0));
        search(queue);

        return (int) Arrays.stream(weights)
            .filter(des -> des <= k)
            .count();
    }

    public static void search(Queue<Node> queue) {
        if (queue.isEmpty()) {
            return;
        }
        Node pollNode = queue.poll();
        int destination = pollNode.destination;
        int weight = pollNode.weight;

        weights[destination] = Math.min(weights[destination], weight);

        nodes[destination].stream()
            .filter(node -> weights[node.destination] > node.weight + weight)
            .forEach(node -> queue.add(new Node(node.destination, node.weight + weight)));

        search(queue);
    }

    public static void main(String[] args) {
        System.out.println(solution(
            5,
            new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}},
            3
        ));

        System.out.println(solution(
            6,
            new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}},
            4
        ));
    }
}