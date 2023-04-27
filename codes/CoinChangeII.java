import java.util.Arrays;

// https://leetcode.com/problems/coin-change-ii/description/
public class CoinChangeII {
  public int change(int amount, int[] coins) {
    int sz = coins.length;

    int[] dp = new int[amount + 1];
    Arrays.fill(dp, 0);
    dp[0] = 1;

    for(int i = 0; i < sz; i++) {
      for(int sum = 1; sum <= amount; sum++) {
        if(coins[i] <= sum) {
          dp[sum] += dp[sum - coins[i]];
        }
      }
    }
    return dp[amount];
  }
}
