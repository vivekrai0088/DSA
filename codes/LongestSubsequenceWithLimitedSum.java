import java.util.Arrays;
// https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/
public class LongestSubsequenceWithLimitedSum {
  private int findLength(int[] arr, int target) {
    int low = 0, high = arr.length - 1;
    int ans = 0;
    while(low <= high) {
      int mid = low + (high - low) / 2;
      if(arr[mid] <= target) {
        ans = mid + 1;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return ans;
  }

  public int[] answerQueries(int[] nums, int[] queries) {
    Arrays.sort(nums);
    int qsz = queries.length;
    int nsz = nums.length;
    int[] ans = new int[qsz];
    int[] cum = new int[nsz];

    cum[0] = nums[0];
    for(int i = 1; i < nsz; i++) {
      cum[i] = cum[i - 1] + nums[i];
    }

    for(int i = 0; i < qsz; i++) {
      ans[i] = findLength(cum, queries[i]);
    }
    return ans;
  }
}
