// https://leetcode.com/problems/max-consecutive-ones-iii/description/
public class LongestConsecutiveOnes {
  public int longestOnes(int[] nums, int k) {
    int flippedCounter = 0;
    int left = 0, right = 0;
    int maxConsecutive = 0;
    int sz = nums.length;
    int currentConsecutiveCount = 0;

    while(right < sz) {
      if(nums[right] == 0) {
        flippedCounter++;
      }

      while(flippedCounter > k) {
        if(nums[left] == 0) {
          flippedCounter--;
        }
        left++;
      }
      maxConsecutive = Math.max(maxConsecutive, right - left + 1);
      right++;
    }
    return maxConsecutive;
  }

  public static void main(String[] args) {
    int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
    System.out.println(new LongestConsecutiveOnes().longestOnes(arr, 2));
  }
}
