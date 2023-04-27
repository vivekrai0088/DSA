import java.util.Arrays;

// https://leetcode.com/problems/coin-change/description/
public class CoinChange {
  public int coinChange(int[] coins, int amount) {
    int sz = coins.length;
    int max = amount + 1;
    int dp[] = new int[amount + 1];
    Arrays.fill(dp, max);

    if(amount == 0) return 0;
    dp[0] = 0;

    for(int i = 1; i <= amount; i++) {
      for(int j = 0; j < sz; j++) {
        if(coins[j] <= i) {
          dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
        }
      }
    }
    if(dp[amount] >= max) return -1;
    return dp[amount];
  }
}
