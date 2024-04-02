import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 길_찾기_게임 {

    public static class Node {
        int x, y, idx;
        Node left, right;

        public Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }

    // [x, y]
    public static int[][] solution(int[][] nodeinfo) {
        Node[] nodse = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodse[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }

        Node[] sortedNodes = Arrays.stream(nodse)
            .sorted(Comparator.comparing((Node node) -> node.y).reversed()
                .thenComparing((Node node) -> node.x))
            .toArray(Node[]::new);

        Node root = sortedNodes[0];
        for (int i = 1; i < sortedNodes.length; i++) {
            Node parent = root;
            while (true) {
                if (sortedNodes[i].x < parent.x) {
                    if (parent.left == null) {
                        parent.left = sortedNodes[i];
                        break;
                    } else {
                        parent = parent.left;
                    }
                } else {
                    if (parent.right == null) {
                        parent.right = sortedNodes[i];
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }

        int[][] answer = new int[2][nodeinfo[0].length];

        List<Integer> preOrderList = new ArrayList<>();
        preOrder(root, preOrderList);
        answer[0] = preOrderList.stream().mapToInt(v -> v).toArray();

        List<Integer> postOrderList = new ArrayList<>();
        postOrder(root, postOrderList);
        answer[1] = postOrderList.stream().mapToInt(v -> v).toArray();

        return answer;
    }

    public static void preOrder(Node node, List<Integer> preOrderList) {
        if (node == null) {
            return;
        }
        preOrderList.add(node.idx);
        preOrder(node.left, preOrderList);
        preOrder(node.right, preOrderList);
    }

    public static void postOrder(Node node, List<Integer> postOrderList) {
        if (node == null) {
            return;
        }
        postOrder(node.left, postOrderList);
        postOrder(node.right, postOrderList);
        postOrderList.add(node.idx);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(
            solution(
                new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}}
            )
        ));
    }
}