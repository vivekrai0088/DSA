import java.util.Arrays;

// https://leetcode.com/problems/student-attendance-record-ii/description/
public class StudentAttendenceRecordII {
  private int dp[][][];
  private int mod = 1000000007;

  private int rec(int n, int isTaken, int currentConsecutiveL) {
    if(n == 0) return 1;

    if(dp[n][isTaken][currentConsecutiveL] != -1) return dp[n][isTaken][currentConsecutiveL];
    int ans = 0;

    // try to take A
    if(isTaken == 0) {
      ans += (rec(n - 1, 1, 0) % mod);
      ans = ans % mod;
    }
    // try to take L
    if(currentConsecutiveL < 2) {
      ans += (rec(n - 1, isTaken, currentConsecutiveL + 1) % mod);
      ans = ans % mod;
    }
    // take P
    ans += (rec(n - 1, isTaken, 0) % mod);
    ans = ans % mod;
    return dp[n][isTaken][currentConsecutiveL] = ans;
  }

  public int checkRecord(int n) {
    dp = new int[n + 1][3][4];
    for(int i = 0; i < n + 1; i++) {
      for(int j = 0; j < 3; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }
    return rec(n, 0, 0) % mod;
  }
}
