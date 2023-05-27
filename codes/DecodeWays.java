import java.util.Arrays;

public class DecodeWays {
  private int rec(String s, int pos, int n, int[] dp) {
    System.out.println("pos = " + pos);
    if(pos == n) {
      return 1;
    }
    if(dp[pos] != -1) return dp[pos];
    int ans = 0;
    if(s.charAt(pos) != '0') {
      ans += rec(s, pos + 1, n, dp);
    }
    if(pos + 1 < n && (s.charAt(pos) == '1' && s.charAt(pos + 1) - '0' >= 0   && s.charAt(pos + 1) - '0' <= 9)) {
      ans += rec(s, pos + 2, n, dp);
    }
    if(pos + 1 < n && (s.charAt(pos) == '2' && s.charAt(pos + 1) - '0' >= 0   && s.charAt(pos + 1) - '0' <= 6)) {
      ans += rec(s, pos + 2, n, dp);
    }
    return dp[pos] = ans;
  }

  public int numDecodings(String s) {
    int[] dp = new int[s.length()];
    Arrays.fill(dp, -1);
    return rec(s, 0, s.length(), dp);
  }

  public static void main(String[] args) {
    String s = "2611055971756562";
    System.out.println(new DecodeWays().numDecodings(s));
  }
}
