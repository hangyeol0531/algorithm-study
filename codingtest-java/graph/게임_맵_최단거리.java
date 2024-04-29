import java.util.ArrayDeque;

public class 게임_맵_최단거리 {

    private static final int[] xArr = {0, 0, 1, -1};
    private static final int[] yArr = {1, -1, 0, 0};

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(int[][] maps) {
        int yLen = maps.length;
        int xLen = maps[0].length;

        int[][] visitedArr = new int[yLen][xLen];
        visitedArr[0][0] = 1;

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int moveX = now.x + xArr[i];
                int moveY = now.y + yArr[i];

                // 맵을 넘어갈때
                if (moveX < 0 || moveY < 0 || moveX >= xLen || moveY >= yLen) {
                    continue;
                }

                // 벽일 때
                if (maps[moveY][moveX] == 0) {
                    continue;
                }

                if (visitedArr[moveY][moveX] == 0) {
                    visitedArr[moveY][moveX] = visitedArr[now.y][now.x] + 1;
                    queue.addLast(new Node(moveX, moveY));
                }
            }
        }

        int result = visitedArr[yLen - 1][xLen - 1];
        return result == 0 ? -1 : result;
    }

    public static void main(String[] args) {
        System.out.println(solution(
            new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}
        ));

//        System.out.println(solution(
//            new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}
//        ));
    }
}