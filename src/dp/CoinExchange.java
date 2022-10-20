package dp;

/**
 * @ClassName CoinExchange
 * @Author jackchen
 * @Date 2022/10/20 11:35
 * @Description 动态规划解决零钱兑换问题 Leetcode 322
 **/
public class CoinExchange {

    public static int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }

    public static int dp(int[] coins, int sum) {
        //base case:
        if (sum == 0) {
            return 0;
        }
        if (sum < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            //子问题是由上一个子问题求解得出的。而子问题之间的相关性是通过硬币面值进行关联的。也就是状态变化的变量
            int subProblem = dp(coins, sum - coin);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amout = 11;
        System.out.println(coinChange(coins, amout));
    }
}
