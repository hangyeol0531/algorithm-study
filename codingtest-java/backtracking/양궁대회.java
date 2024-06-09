import java.util.Arrays;
import java.util.Objects;

public class 양궁대회 {

    private static int[] result;
    private static int resultDiff;
    private static int hitCount;
    private static int[] apeachInfo;

    public static int[] solution(int n, int[] info) {
        resultDiff = 0;
        apeachInfo = info;
        hitCount = n;
        result = new int[11];
        find(result, 0);
        return getHitCount(result) == 0 ? new int[]{-1} : result;
    }

    public static void find(int[] ryanInfo, int score) {
        // 라이언이 모두 화살을 쏠때 구함
        int ryanHitCount = getHitCount(ryanInfo);

        if (ryanHitCount == hitCount) {
            int diff = getWinRyanDiff(apeachInfo, ryanInfo);
            if (diff > resultDiff) {
                resultDiff = diff;
                result = ryanInfo.clone();
            } else if (diff == resultDiff) {
                for (int i = apeachInfo.length - 1; i >= 0; i--) {
                    if (result[i] > ryanInfo[i]) {
                        return;
                    }
                    if (result[i] < ryanInfo[i]) {
                        result = ryanInfo.clone();
                        return;
                    }
                }
            }
            return;
        }

        if (ryanHitCount > hitCount || score == ryanInfo.length) {
            return;
        }

        for (int i = 0; i <= apeachInfo[score] + 1; i++) {
            ryanInfo[score] = i;
            find(ryanInfo, score + 1);
            ryanInfo[score] = 0;
        }
    }

    private static int getHitCount(int[] arr) {
        if (Objects.isNull(arr)) {
            return 0;
        }
        return Arrays.stream(arr).sum();
    }

    private static int getWinRyanDiff(
        int[] apeach,
        int[] ryan
    ) {
        int apeachScore = 0;
        int ryanScore = 0;

        for (int i = 0; i < apeach.length; i++) {
            int apeachHit = apeach[i];
            int ryanHit = ryan[i];

            if (apeachHit == 0 && ryanHit == 0) {
                continue;
            }

            if (ryanHit > apeachHit) {
                ryanScore += 10 - i;
            } else {
                apeachScore += 10 - i;
            }
        }
        return ryanScore > apeachScore ? ryanScore - apeachScore : 0;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})));
        System.out.println(Arrays.toString(solution(1, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})));
        System.out.println(Arrays.toString(solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3})));
    }
}