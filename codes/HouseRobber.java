// https://leetcode.com/problems/house-robber/description/
public class HouseRobber {
  public int rob(int[] nums) {
    int sz = nums.length;
    int[][] dp = new int[sz][2];

    dp[0][0] = 0;
    dp[0][1] = nums[0];
    for(int i = 1; i < sz; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
      dp[i][1] = dp[i - 1][0] + nums[i];
    }
    return Math.max(dp[sz - 1][0], dp[sz - 1][1]);
  }
}
