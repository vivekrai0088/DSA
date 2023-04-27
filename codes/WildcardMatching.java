import java.util.Arrays;

// https://leetcode.com/problems/wildcard-matching/description/
public class WildcardMatching {
  boolean[][] dp;
  int[][] visited;

  private boolean rec(String s, String p, int n, int m) {
    if(m == 0) return (n == 0);
    if(n <= 0) {
      int stars = 0;
      for(int i = 0; i < m; i++) {
        if(p.charAt(i) == '*') {
          stars++;
        }
      }
      return (stars == m);
    }

    if(visited[n][m] == 1) return dp[n][m];

    boolean ans = false;
    if(n - 1 >= 0 && (s.charAt(n - 1) == p.charAt(m - 1) || p.charAt(m - 1) == '?')) {
      ans = ans || rec(s, p, n - 1, m - 1);
    }
    if(p.charAt(m - 1) == '*') {
      ans = ans || rec(s, p, n - 1, m); // match multiple
      ans = ans || rec(s, p, n - 1, m - 1); // match single
      ans = ans || rec(s, p, n, m - 1); // match empty
    }
    visited[n][m] = 1;
    return dp[n][m] = ans;
  }

  public boolean isMatch(String s, String p) {
    int n = s.length();
    int m = p.length();
    dp = new boolean[n + 1][m + 1];
    visited = new int[n + 1][m + 1];

    for(int i = 0; i <= n; i++) Arrays.fill(dp[i], false);
    for(int i = 0; i <= n; i++) Arrays.fill(visited[i], 0);
    return rec(s, p, n, m);
  }
}
