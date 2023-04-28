// https://leetcode.com/problems/maximum-product-subarray/description/
public class MaximumProductSubarray {
  public int maxProduct(int[] nums) {
    int sz = nums.length;
    int maxi = nums[0];

    int currentMin = nums[0];
    int currentMax = nums[0];

    for(int i = 1; i < sz; i++) {
      int temp = currentMax;
      currentMax = Math.max(currentMax * nums[i], Math.max(currentMin * nums[i], nums[i]));
      currentMin = Math.min(currentMin * nums[i], Math.min(temp * nums[i], nums[i]));
      maxi = Math.max(maxi, Math.max(currentMin, currentMax));

      if(temp > maxi) {
        maxi = temp;
      }
    }
    return maxi;
  }
}
