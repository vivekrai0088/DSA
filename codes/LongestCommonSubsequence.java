import java.util.Arrays;

// https://leetcode.com/problems/longest-common-subsequence/description/
public class LongestCommonSubsequence {

  int[][] dp;

  private int rec(String text1, String text2, int n, int m) {
    if(n == 0 || m == 0) return 0;

    if(dp[n][m] != -1) {
      return dp[n][m];
    }

    int ans = 0;
    if(text1.charAt(n - 1) == text2.charAt(m - 1)) {
      ans = 1 + rec(text1, text2, n - 1, m - 1);
    } else {
      ans = Math.max(rec(text1, text2, n - 1, m), rec(text1, text2, n, m - 1));
    }
    return dp[n][m] = ans;
  }

  public int longestCommonSubsequence(String text1, String text2) {
    int n = text1.length();
    int m = text2.length();
    dp = new int[n + 1][m + 1];
    for(int i = 0; i <= n; i++) {
      Arrays.fill(dp[i], -1);
    }

    return rec(text1, text2, n, m);
  }
}
