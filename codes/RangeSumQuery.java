import java.util.Arrays;

// https://leetcode.com/problems/range-sum-query-immutable/description/
public class RangeSumQuery {
  int[] nums;
  int[] cums;

  public RangeSumQuery(int[] nums) {
    this.nums = nums;
    cums = new int[nums.length + 1];
    Arrays.fill(cums, 0);

    for(int i = 1; i <= nums.length; i++) {
      cums[i] = cums[i - 1] + nums[i - 1];
    }
  }

  public int sumRange(int left, int right) {
    left++;
    right++;
    return cums[right] - cums[left - 1];
  }
}
