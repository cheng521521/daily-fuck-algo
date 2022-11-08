package dp;

import java.util.Arrays;

/**
 * @ClassName MinDistance
 * @Author jackchen
 * @Date 2022/11/8 14:15
 * @Description leetcode 72 编辑距离
 **/
public class MinDistance {

    int[][] memo;

    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(word1, word1.length() - 1, word2, word2.length() - 1);
    }

    public int dp(String m, int i, String n, int j) {
        //base case
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (m.charAt(i) == n.charAt(j)) {
            memo[i][j] = dp(m, i - 1, n, j - 1);
        } else {
            memo[i][j] = min(dp(m, i, n, j - 1) + 1,
                dp(m, i - 1, n, j) + 1,
                dp(m, i - 1, n, j - 1) + 1);
        }
        return memo[i][j];
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
