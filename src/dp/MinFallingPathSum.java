package dp;

import java.util.Arrays;

/**
 * @ClassName MinFallingPathSum
 * @Author jackchen
 * @Date 2022/11/5 16:55
 * @Description Leetcode 931
 **/
public class MinFallingPathSum {

    int memo[][];

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 66666);
        }
        // 终点可能在 matrix[n-1] 的任意一列
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp(matrix, n - 1, j));
        }
        return res;
    }

    public int dp(int[][] matrix, int i, int j) {
        // 非法索引检查
        if (i < 0 || j < 0 ||
            i >= matrix.length ||
            j >= matrix[0].length) {
            // 返回一个特殊值
            return 99999;
        }
        // base case
        if (i == 0) {
            return matrix[i][j];
        }
        //查看值是否在备忘录里面
        if (memo[i][j] != 66666) {
            return memo[i][j];
        }

        memo[i][j] = matrix[i][j] + min(dp(matrix, i - 1, j - 1),
            dp(matrix, i - 1, j),
            dp(matrix, i - 1, j + 1));
        return memo[i][j];
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
