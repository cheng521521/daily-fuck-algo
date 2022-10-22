package dp;

import java.util.Arrays;

/**
 * @ClassName LengthOfLIS
 * @Author jackchen
 * @Date 2022/10/22 15:01
 * @Description 最长子序列问题
 **/
public class LengthOfLIS {

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        return search(nums, dp);
    }

    private static int search(int[] nums, int[] dp) {
        for (int i = 1; i < nums.length; i++) {
            //从当前索引向前寻找，找见比当前值小的数
            int dpResult = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dpResult = Math.max(dpResult, dp[j]);
                }
                dp[i] = dpResult + 1;
            }
        }
        int res = dp[0];
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + ",");
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        lengthOfLIS(nums);
    }
}
