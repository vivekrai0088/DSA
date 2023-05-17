import java.util.Arrays;

// https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
public class MaximumLengthOfRepeatedSubstring {
  private int[][] dp;
  int ans = 0;

  private int rec(int[] nums1, int[] nums2, int n, int m) {
    if(n == 0 || m == 0) return 0;

    if(dp[n][m] != -1) return dp[n][m];
    int take = 0;
    if(nums1[n - 1] == nums2[m - 1]) {
      take = 1 + rec(nums1, nums2, n - 1, m - 1);
      ans = Math.max(ans, take);
    }
    rec(nums1, nums2, n - 1, m);
    rec(nums1, nums2, n, m - 1);
    return dp[n][m] = take;
  }

  public int findLength(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    dp = new int[n + 1][m + 1];
    for(int i = 1; i <= n; i++) {
      Arrays.fill(dp[i], -1);
    }
    rec(nums1, nums2, n, m);
    return ans;
  }
}
