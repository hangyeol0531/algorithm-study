import java.util.HashSet;

public class 방문_길이 {

    public static int solution(String dirs) {
        HashSet<Object> set = new HashSet<>();

        int x = 5;
        int y = 5;
        for (int i = 0; i < dirs.length(); i++) {
            String now = String.format("%d%d", x, y);
            switch (dirs.charAt(i)) {
                case 'U':
                    if (y + 1 != 11) {
                        y++;
                        break;
                    }
                    continue;
                case 'D':
                    if (y - 1 != -1) {
                        y--;
                        break;
                    }
                    continue;
                case 'R':
                    if (x + 1 != 11) {
                        x++;
                        break;
                    }
                    continue;
                case 'L':
                    if (x - 1 != -1) {
                        x--;
                        break;
                    }
                    continue;
            }
            String move = String.format("%d%d", x, y);
            set.add(now + move);
            set.add(move + now);
        }
        return set.size() / 2;
    }

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
    }
}