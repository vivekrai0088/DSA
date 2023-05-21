public class MinimumSizeSubArraySum {
  public int minSubArrayLen(int target, int[] nums) {
    int sz = nums.length;

    int low = 0, high = 0;
    int minLength = Integer.MAX_VALUE;
    int currentSum = 0;
    while(high < sz) {
      currentSum += nums[high];
      while(low < sz && low <= high && currentSum >= target) {
        minLength = Math.min(minLength, high - low + 1);
        currentSum -= nums[low];
        low++;
      }
      high++;
    }

    if(minLength == Integer.MAX_VALUE) {
      return 0;
    }
    return minLength;
  }
}
