public class 피로도 {

    private static boolean[] isVisited;
    private static int[][] dungeons;
    private static int answer = 0;

    public static int solution(int k, int[][] _dungeons) {
        dungeons = _dungeons;
        isVisited = new boolean[dungeons.length];
        find(0, k);
        return answer;
    }

    public static void find(int cnt, int k) {
        answer = Math.max(answer, cnt);
        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0] && !isVisited[i]) {
                isVisited[i] = true;
                find(cnt + 1, k - dungeons[i][1]);
                isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }
}