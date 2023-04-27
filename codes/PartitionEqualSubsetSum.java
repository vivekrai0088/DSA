// https://leetcode.com/problems/partition-equal-subset-sum/description/
public class PartitionEqualSubsetSum {
  public boolean canPartition(int[] nums) {
    int sz = nums.length;

    int sum = 0;
    for(int i = 0; i < sz; i++) {
      sum += nums[i];
    }

    if(sum % 2 == 1) return false;

    sum = sum / 2;

    boolean[][] dp = new boolean[sz + 1][sum + 1];
    dp[0][0] = true;

    for(int i = 1; i <= sz; i++) {
      dp[i][0] = true;
    }

    for(int j = 1; j <= sum; j++) {
      dp[0][j] = false;
    }

    for(int i = 1; i <= sz; i++) {
      for(int j = 1; j <= sum; j++) {
        dp[i][j] = dp[i - 1][j];
        if(j - nums[i - 1] >= 0) {
          dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
        }
      }
    }
    return dp[sz][sum];
  }
}
