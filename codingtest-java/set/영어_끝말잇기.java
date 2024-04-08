import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 영어_끝말잇기 {

    public static int[] solution(int n, String[] words) {
        List<String> usedWord = new ArrayList<>();

        int cnt = 0;
        String previousWord = words[0];

        while (cnt != words.length - 1) {
            usedWord.add(previousWord);
            String nowWord = words[++cnt];
            if (usedWord.contains(nowWord) || previousWord.charAt(previousWord.length() - 1) != nowWord.charAt(0)) {
                // 탈락하는 사람 번호, 몇 번째 차례에서 탈락하는지
                return new int[]{cnt % n + 1, (cnt + n) / n};
            }
            previousWord = nowWord;
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }
}