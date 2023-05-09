public class FindMinimumInSortedArray {
  public int findMin(int[] nums) {
    int sz = nums.length;

    int left = 0, right = sz - 1;
    while(left < right) {
      int mid = left + (right - left) / 2;
      if(nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return nums[left];
  }
}
