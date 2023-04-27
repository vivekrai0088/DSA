import java.util.Arrays;

// https://leetcode.com/problems/longest-palindromic-subsequence/description/
public class LongestPalindromicSubsequence {
  int dp[][];

  private int rec(String s, int i, int j) {
    if(i > j) return 0;
    if(i == j) return 1;
    if(dp[i][j] != -1) return dp[i][j];
    int ans = 0;
    if(s.charAt(i - 1) == s.charAt(j - 1)) {
      ans = 2 + rec(s, i + 1, j - 1);
    } else {
      ans = Math.max(rec(s, i + 1, j), rec(s, i, j - 1));
    }
    return dp[i][j] = ans;
  }

  public int longestPalindromeSubseq(String s) {
    int sz = s.length();
    dp = new int[sz + 1][sz + 1];
    for(int i = 0; i <= sz; i++) Arrays.fill(dp[i], -1);
    return rec(s, 1, sz);
  }
}
