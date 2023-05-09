public class RotateArray {
  private void reverse(int[] nums, int i, int j) {
    while(i < j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
      i++;
      j--;
    }
  }

  public void rotate(int[] nums, int k) {
    int sz = nums.length;
    if(sz == 0 || sz == 1) return;
    k = k % sz;
    reverse(nums, 0, sz - k - 1);
    reverse(nums, sz - k, sz - 1);
    reverse(nums, 0, sz - 1);
  }
}
