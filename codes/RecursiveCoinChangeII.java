import java.util.Arrays;

public class RecursiveCoinChangeII {
  private int[][] dp;
  private int rec(int[] coins, int n, int amount) {
    if(n == 0) {
      if(amount == 0) return 1;
      return 0;
    }
    if(dp[n][amount] != -1) return dp[n][amount];
    int ans = 0;
    // notTake
    ans += rec(coins, n - 1, amount);
    // take
    if(coins[n - 1] <= amount) {
      ans += rec(coins, n, amount - coins[n - 1]);
    }
    return dp[n][amount] = ans;
  }

  public int change(int amount, int[] coins) {
    dp = new int[coins.length + 1][amount + 1];
    for(int i = 0; i < coins.length + 1; i++) {
      Arrays.fill(dp[i], -1);
    }
    return rec(coins, coins.length, amount);
  }
}
