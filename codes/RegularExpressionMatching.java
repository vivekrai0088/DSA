import java.util.Arrays;

// https://leetcode.com/problems/regular-expression-matching/description/
public class RegularExpressionMatching {
  boolean[][] dp;
  int[][] visited;

  private boolean rec(String s, String p, int n, int m) {
    if(m == 0) {
      return (n == 0);
    }

    if(visited[n][m] == 1) return dp[n][m];

    boolean ans = false;

    if((n - 1 >= 0) && (p.charAt(m - 1) == s.charAt(n - 1) || p.charAt(m - 1) == '.')) {
      ans = ans || rec(s, p, n - 1, m - 1);
    }
    if(p.charAt(m - 1) == '*') {
      if((n - 1 >= 0 && m - 2 >= 0) && (p.charAt(m - 2) == s.charAt(n - 1) || p.charAt(m - 2) == '.')) {
        ans = ans || rec(s, p, n - 1, m); // a* count as multiple
        ans = ans || rec(s, p, n - 1, m - 1); // a* count as single
        ans = ans || rec(s, p, n, m - 2); // a* count as empty
      } else {
        ans = ans || rec(s, p, n, m - 2); // a* count as empty
      }
    }
    visited[n][m] = 1;
    return dp[n][m] = ans;
  }

  public boolean isMatch(String s, String p) {
    int n = s.length();
    int m = p.length();
    dp = new boolean[n + 1][m + 1];
    visited = new int[n + 1][m + 1];
    for(int i = 0; i < n; i++) {
      Arrays.fill(dp[i], false);
    }
    for(int i = 0; i < n; i++) {
      Arrays.fill(visited[i], 0);
    }

    return rec(s, p, n, m);
  }
}
