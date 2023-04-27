import java.util.Arrays;

// https://leetcode.com/problems/longest-increasing-subsequence/description/
public class LongestIncreasingSubsequence {
  int dp[];

  private int rec(int[] nums, int n) {
    if(n == 0) return 0;

    if(dp[n] != -1) return dp[n];

    int ans = 1;
    for(int i = 0; i < n - 1; i++) {
      if(nums[i] < nums[n - 1]) {
        ans = Math.max(ans, 1 + rec(nums, i + 1));
      }
    }
    return dp[n] = ans;
  }

  public int lengthOfLIS(int[] nums) {
    int sz = nums.length;
    dp = new int[sz + 1];
    Arrays.fill(dp, -1);
    rec(nums, sz);
    int ans = 0;
    for(int i = 1; i <= sz; i++) {
      ans = Math.max(ans, rec(nums, i));
    }
    return ans;
  }
}
