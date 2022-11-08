package dp;

/**
 * @ClassName MaxSubArray
 * @Author jackchen
 * @Date 2022/11/8 19:58
 * @Description 子数组最大和
 **/
public class MaxSubArray {

    /**
     * 先想dp状态转移方程，如何定义dp？dp[i]有两种结果，一种是dp[i-1] + nums[i], 一种是 dp[i]就是本身就是最大值 int max =
     * Math.max(dpp[i], dp[i-1] + nums[i]
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        for (int i = 0; i < n - 1; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
