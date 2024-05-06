import java.util.ArrayDeque;
import java.util.Deque;

public class 미로_탈출 {

    public static int[] xArr = {0, 0, 1, -1};
    public static int[] yArr = {1, -1, 0, 0};

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int bfs(Point startPoint, Point endPoint, String[] maps) {
        int lenY = maps.length;
        int lenX = maps[0].length();

        int[][] distance = new int[lenY][lenX];
        Deque<Point> queue = new ArrayDeque<>();

        queue.push(startPoint);
        distance[startPoint.y][startPoint.x] = 1;

        while (!queue.isEmpty()) {
            Point nowPoint = queue.poll();
            for (int i = 0; i < 4; i++) {
                int moveX = nowPoint.x + xArr[i];
                int moveY = nowPoint.y + yArr[i];

                // 맵을 나간 경우
                if (moveX < 0 || moveY < 0 || moveX >= lenX || moveY >= lenY) {
                    continue;
                }

                // 이미 왔던길인 경우
                if (distance[moveY][moveX] > 0) {
                    continue;
                }

                // 벽인 경우
                if (maps[moveY].charAt(moveX) == 'X') {
                    continue;
                }

                // 도착
                if (moveX == endPoint.x && moveY == endPoint.y) {
                    return distance[nowPoint.y][nowPoint.x];
                }

                distance[moveY][moveX] = distance[nowPoint.y][nowPoint.x] + 1;
                queue.add(new Point(moveX, moveY));
            }
        }
        return -1;
    }

    public static int solution(String[] maps) {
        Point startPoint = null, leverPoint = null, exitPoint = null;

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    startPoint = new Point(j, i);
                } else if (maps[i].charAt(j) == 'L') {
                    leverPoint = new Point(j, i);
                } else if (maps[i].charAt(j) == 'E') {
                    exitPoint = new Point(j, i);
                }
            }
        }

        int leverNum = bfs(startPoint, leverPoint, maps);
        int exitNum = bfs(leverPoint, exitPoint, maps);

        if (leverNum == -1 || exitNum == -1) {
            return -1;
        }

        return leverNum + exitNum;
    }


    public static void main(String[] args) {
        System.out.println(
            solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"})
        );
        System.out.println(
            solution(new String[]{"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"})
        );
        System.out.println(
            solution(new String[]{"LXXXS", "XXXXX", "XXXXX", "XXXXX", "EXXXX"})
        );
        System.out.println(
            solution(new String[]{"SOOOO", "OOOOO", "OOOOO", "OOOOO", "OOOLE"})
        );
    }
}