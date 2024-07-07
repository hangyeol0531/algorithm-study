public class CountingSort {

    private static Integer SMALL_ALPHABET_COUNT = 26;
    public static String solution(String s) {
        int[] counts = new int[SMALL_ALPHABET_COUNT];

        for (char c : s.toCharArray()) {
            counts[c - 'a'] += 1;
        }

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < SMALL_ALPHABET_COUNT; i++){
            for(int j = 0; j < counts[i]; j++){
                builder.append((char) (i + 'a'));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("hello"));
        System.out.println(solution("algorithm"));
    }
}