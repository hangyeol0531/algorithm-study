import java.util.HashSet;

public class 네트워크_tree_Fail {

    public static int[] tree;

    public static int solution(int n, int[][] computers) {
        tree = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                int find = computers[j - 1][i - 1];
                if (find == 1) {
                    tree[i] = j;
                    break;
                }
            }
        }

        HashSet<Integer> resultSet = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            resultSet.add(searchRoot(i));
        }
        return resultSet.size();
    }

    public static int searchRoot(int n) {
        if (tree[n] == n) {
            return n;
        } else {
            return searchRoot(tree[n]);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
        System.out.println(solution(3, new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(4, new int[][]{{1, 1, 0, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 1}}));
        System.out.println(solution(4, new int[][]{{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}}));
    }
}