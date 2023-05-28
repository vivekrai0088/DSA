import java.util.Arrays;

// https://leetcode.com/problems/house-robber-ii/description/
public class HouseRobberII {
  int dp[][];
  private int rec(int[] nums, int i, int j, int canTake) {
    if(i > j) {
      return 0;
    }
    if(dp[j][canTake] != -1) return dp[j][canTake];
    int ans = 0;
    ans = Math.max(ans, rec(nums, i, j - 1, 1));
    if(canTake == 1) {
      ans = Math.max(ans, nums[j] + rec(nums, i, j - 1, 0));
    }
    return dp[j][canTake] = ans;
  }

  public int rob(int[] nums) {
    int sz = nums.length;
    if(sz == 1) return nums[0];
    dp = new int[sz][2];
    for(int i = 0; i < sz; i++) Arrays.fill(dp[i], -1);
    int ans1 = rec(nums, 0, sz - 2, 1);
    for(int i = 0; i < sz; i++) Arrays.fill(dp[i], -1);
    int ans2 = rec(nums, 1, sz - 1, 1);
    return Math.max(ans1, ans2);
  }
}
