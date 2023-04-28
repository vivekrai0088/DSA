// https://leetcode.com/problems/maximum-subarray/description/
public class MaximumSubArray {
  public int maxSubArray(int[] nums) {
    int maxSum = Integer.MIN_VALUE;
    int sz = nums.length;

    int currentSum = 0;
    for(int i = 0; i < sz; i++) {
      if(currentSum + nums[i] < nums[i]) {
        currentSum = nums[i];
      } else {
        currentSum += nums[i];
      }
      maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
  }
}
