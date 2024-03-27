public class 예상_대진표 {

    public static int solution(int n, int a, int b) {
        int answer = 0;

        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
    }
}