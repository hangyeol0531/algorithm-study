import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 경주로_건설 {

    private static final int[] xArr = {0, 0, 1, -1};
    private static final int[] yArr = {1, -1, 0, 0};

    public static class Node {
        int x, y, cost, latest;
        int[][] isVisited;

        public Node(int x, int y, int cost, int latest, int[][] isVisited) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.latest = latest;
            this.isVisited = isVisited;
        }
    }

    private static int[][] getArrayDeppCopy(int[][] arr) {
        return Arrays.stream(arr)
            .map(int[]::clone)
            .toArray(int[][]::new);
    }

    // 직선 100, 코너 500
    public static int solution(int[][] board) {
        int xLen = board[0].length;
        int yLen = board.length;
        int result = Integer.MAX_VALUE;

        Queue<Node> queue = new ArrayDeque<>();
        int[][] initIsVisited = new int[yLen][xLen];
        initIsVisited[0][0] = 1;
        queue.add(new Node(0, 0, 0, -1, initIsVisited));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nowX = poll.x + xArr[i];
                int nowY = poll.y + yArr[i];

                int nowCost = poll.cost + 100;
                if (poll.latest != -1 && poll.latest != i) {
                    nowCost += 500;
                }

                int[][] isVisited = poll.isVisited;
                if (nowX < 0 || nowY < 0 || nowX >= xLen || nowY >= yLen) {
                    continue;
                }

                if (board[nowY][nowX] == 1 || isVisited[nowY][nowX] == 1) {
                    continue;
                }

                if (nowX == xLen - 1 && nowY == yLen - 1) {
                    result = Math.min(result, nowCost);
                } else {
                    int[][] copyIsVisited = getArrayDeppCopy(isVisited);
                    copyIsVisited[nowY][nowX] = 1;
                    queue.add(new Node(nowX, nowY, nowCost, i, copyIsVisited));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //tc1
        System.out.println(
            solution(
                new int[][]{
                    {0, 0, 0},
                    {0, 0, 0},
                    {0, 0, 0}
                }
            )
        );

        //tc2
        System.out.println(
            solution(
                new int[][]{
                    {0, 0, 0, 0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 1, 0, 0, 0},
                    {0, 0, 0, 1, 0, 0, 0, 1},
                    {0, 0, 1, 0, 0, 0, 1, 0},
                    {0, 1, 0, 0, 0, 1, 0, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0}
                }
            )
        );

//        tc3
        System.out.println(
            solution(
                new int[][]{
                    {0, 0, 1, 0},
                    {0, 0, 0, 0},
                    {0, 1, 0, 1},
                    {1, 0, 0, 0}
                }
            )
        );
//
//        tc4
        System.out.println(
            solution(
                new int[][]{
                    {0, 0, 0, 0, 0, 0},
                    {0, 1, 1, 1, 1, 0},
                    {0, 0, 1, 0, 0, 0},
                    {1, 0, 0, 1, 0, 1},
                    {0, 1, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0}
                }
            )
        );
    }
}