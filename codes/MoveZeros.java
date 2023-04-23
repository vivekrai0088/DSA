// https://leetcode.com/problems/move-zeroes/description/
public class MoveZeros {
  public void moveZeroes(int[] nums) {
    int sz = nums.length;
    int i = 0, j = 0;

    while(j < sz) {
      if(nums[j] != 0) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        i++;
      }
      j++;
    }
  }
}
