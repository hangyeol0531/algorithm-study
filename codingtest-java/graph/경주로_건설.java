import java.util.ArrayDeque;
import java.util.Queue;

public class 경주로_건설 {

    private static final int[] xArr = {0, 0, 1, -1};
    private static final int[] yArr = {1, -1, 0, 0};
    private static int[][][] isVisited;

    public static class Node {
        int x, y, cost, latest;

        public Node(int x, int y, int cost, int latest) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.latest = latest;
        }
    }

    // 직선 100, 코너 500
    public static int solution(int[][] board) {
        int xLen = board[0].length;
        int yLen = board.length;

        /*
        현재 위치로 값을 판단하면안되고,
        코너, 직선에 따라 다음 값의 차이가 크기때문에, 방향에 따라 각각 값을 비교해야한다.
        */
        isVisited = new int[yLen][xLen][4];
        for (int i = 0; i < yLen; i++) {
            for (int j = 0; j < xLen; j++) {
                for (int k = 0; k < 4; k++) {
                    isVisited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        int result = Integer.MAX_VALUE;

        Queue<Node> queue = new ArrayDeque<>();

        queue.add(new Node(0, 0, 0, -1));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nowX = poll.x + xArr[i];
                int nowY = poll.y + yArr[i];

                int nowCost = poll.cost + 100;
                if (poll.latest != -1 && poll.latest != i) {
                    nowCost += 500;
                }

                if (nowX < 0 || nowY < 0 || nowX >= xLen || nowY >= yLen) {
                    continue;
                }

                if (board[nowY][nowX] == 1 || isVisited[nowY][nowX][i] < nowCost) {
                    continue;
                }

                if (nowX == xLen - 1 && nowY == yLen - 1) {
                    result = Math.min(result, nowCost);
                } else {
                    isVisited[nowY][nowX][i] = nowCost;
                    queue.add(new Node(nowX, nowY, nowCost, i));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //tc1
//        System.out.println(
//            solution(
//                new int[][]{
//                    {0, 0, 0},
//                    {0, 0, 0},
//                    {0, 0, 0}
//                }
//            )
//        );

        //tc2
//        System.out.println(
//            solution(
//                new int[][]{
//                    {0, 0, 0, 0, 0, 0, 0, 1},
//                    {0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 1, 0, 0},
//                    {0, 0, 0, 0, 1, 0, 0, 0},
//                    {0, 0, 0, 1, 0, 0, 0, 1},
//                    {0, 0, 1, 0, 0, 0, 1, 0},
//                    {0, 1, 0, 0, 0, 1, 0, 0},
//                    {1, 0, 0, 0, 0, 0, 0, 0}
//                }
//            )
//        );

//        tc3
//        System.out.println(
//            solution(
//                new int[][]{
//                    {0, 0, 1, 0},
//                    {0, 0, 0, 0},
//                    {0, 1, 0, 1},
//                    {1, 0, 0, 0}
//                }
//            )
//        );
//
//        tc4
//        System.out.println(
//            solution(
//                new int[][]{
//                    {0, 0, 0, 0, 0, 0},
//                    {0, 1, 1, 1, 1, 0},
//                    {0, 0, 1, 0, 0, 0},
//                    {1, 0, 0, 1, 0, 1},
//                    {0, 1, 0, 0, 0, 1},
//                    {0, 0, 0, 0, 0, 0}
//                }
//            )
//        );
//        tc5
        System.out.println(
            solution(
                new int[][]{
                    {0, 0, 0, 0, 0},
                    {0, 1, 1, 1, 0},
                    {0, 0, 1, 0, 0},
                    {1, 0, 0, 0, 1},
                    {1, 1, 1, 0, 0}
                }
            )
        );
    }
}
