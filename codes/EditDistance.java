import java.util.Arrays;

// https://leetcode.com/problems/edit-distance/description/
public class EditDistance {
  int[][] dp;

  private int rec(String word1, String word2, int n, int m) {
    if(n == 0 && m == 0) return 0;
    if(n == 0) return m;
    if(m == 0) return n;

    if(dp[n][m] != -1) return dp[n][m];

    if(word1.charAt(n - 1) == word2.charAt(m - 1)) {
      return dp[n][m] = rec(word1, word2, n - 1, m - 1);
    } else {
      int insertOp = 1 + rec(word1, word2, n, m - 1);
      int deleteOp = 1 + rec(word1, word2, n - 1, m);
      int replaceOp = 1 + rec(word1, word2, n - 1, m - 1);
      return dp[n][m] = Math.min(insertOp, Math.min(deleteOp, replaceOp));
    }
  }

  public int minDistance(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();
    dp = new int[n + 1][m + 1];
    for(int i = 0; i <= n; i++) {
      Arrays.fill(dp[i], -1);
    }
    return rec(word1, word2, n, m);
  }
}
