// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class LowerUpperBound {
  int LOWER = 0;
  int UPPER = 1;

  private int findBound(int[] nums, int target, int bound) {
    int low = 0, high = nums.length - 1;
    int ans = -1;
    while(low <= high) {
      int mid = low + (high - low) / 2;
      if(nums[mid] == target) {
        ans = mid;
        if(bound == LOWER) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else if(nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return ans;
  }

  public int[] searchRange(int[] nums, int target) {
    int sz = nums.length;
    int lower = findBound(nums, target, LOWER);
    int upper = findBound(nums, target, UPPER);

    int[] ans = new int[2];
    ans[0] = lower;
    ans[1] = upper;
    return ans;
  }
}
