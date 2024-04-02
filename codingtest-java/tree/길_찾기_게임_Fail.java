import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class 길_찾기_게임_Fail {
    private static int[] tree;

    public static class Node {
        int x, y, idx;

        public Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }

    // [x, y]
    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo[0].length];

        int nodeCount = (int) Math.pow(2, nodeinfo.length) - 1;
        tree = new int[nodeCount];

        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i);
        }

        Arrays.fill(tree, -1);

        connect(0, nodes);

        // 전위
        List<Integer> preOrderList = new ArrayList<>();
        preOrder(0, nodeCount, preOrderList);
        answer[0] = preOrderList.stream()
            .mapToInt(v -> v)
            .toArray();

        // 후위
        List<Integer> postOrderList = new ArrayList<>();
        postorder(0, nodeCount, postOrderList);
        answer[1] = postOrderList.stream()
            .mapToInt(v -> v)
            .toArray();
        return answer;
    }

    public static void preOrder(int idx, int nodeCount, List<Integer> preOrderList) {
        if (idx >= nodeCount) {
            return;
        }

        if (tree[idx] >= 0) {
            preOrderList.add(tree[idx] + 1);
        }
        preOrder(idx * 2 + 1, nodeCount, preOrderList);
        preOrder(idx * 2 + 2, nodeCount, preOrderList);
    }

    public static void postorder(int idx, int nodeCount, List<Integer> postOrderList) {
        if (idx >= nodeCount) {
            return;
        }
        postorder(idx * 2 + 1, nodeCount, postOrderList);
        postorder(idx * 2 + 2, nodeCount, postOrderList);
        if (tree[idx] >= 0) {
            postOrderList.add(tree[idx] + 1);
        }
    }

    public static void connect(int idx, Node[] nodes) {
        Node parent = Arrays.stream(nodes).sorted(Comparator.comparing((Node node) -> node.y).reversed()
                .thenComparing((Node node) -> node.x))
            .findFirst()
            .orElse(null);

        tree[idx] = parent.idx;

        // 왼쪽
        Node[] leftNodes = Arrays.stream(nodes)
            .filter(node -> node.x < parent.x && node.y < parent.y)
            .toArray(Node[]::new);

        Node leftNode = Arrays.stream(leftNodes)
            .findFirst()
            .orElse(null);

        int leftIdx = idx * 2 + 1;
        if (Objects.nonNull(leftNode) && leftIdx < tree.length) {
            tree[leftIdx] = leftNode.idx;
            connect(leftIdx, leftNodes);
        }

        // 오른쪽
        Node[] rightNodes = Arrays.stream(nodes)
            .filter(node -> node.x > parent.x && node.y < parent.y)
            .toArray(Node[]::new);

        Node rightNode = Arrays.stream(rightNodes)
            .findFirst()
            .orElse(null);

        int rightIdx = idx * 2 + 2;
        if (Objects.nonNull(rightNode) && rightIdx < tree.length) {
            tree[rightIdx] = rightNode.idx;
            connect(rightIdx, rightNodes);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(
            solution(
                new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}}
            )
        ));
    }
}