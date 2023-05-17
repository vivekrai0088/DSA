import java.util.Arrays;

public class RecursiveCoinChange {
  private int[][] dp;

  private int rec(int[] coins, int n, int amount) {
    if(n == 1) {
      if(amount % coins[n - 1] == 0) return amount / coins[n - 1];
      return (int)1e9;
    }
    if(dp[n][amount] != -1) return dp[n][amount];
    int notTake = 0 + rec(coins, n - 1, amount);
    int take = (int)1e9;
    if(coins[n - 1] <= amount) {
      take = 1 + rec(coins, n, amount - coins[n - 1]);
    }
    return dp[n][amount] = Math.min(take, notTake);
  }

  public int coinChange(int[] coins, int amount) {
    dp = new int[coins.length + 1][amount + 1];
    for(int i = 0; i < coins.length + 1; i++) {
      Arrays.fill(dp[i], -1);
    }
    int ans = rec(coins, coins.length, amount);
    if(ans >= (int)1e9) {
      return -1;
    }
    return ans;
  }
}
