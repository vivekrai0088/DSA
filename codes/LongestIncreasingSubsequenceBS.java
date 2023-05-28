import java.util.ArrayList;

public class LongestIncreasingSubsequenceBS {
  public int lengthOfLIS(int[] nums) {
    int sz = nums.length;
    if(sz == 0) return 0;
    ArrayList<Integer> result = new ArrayList<>();
    result.add(nums[0]);
    for(int i = 1; i < sz; i++) {
      if(result.get(result.size() - 1) < nums[i]) {
        result.add(nums[i]);
      } else {
        int index = binarySearch(result, nums[i]);
        result.set(index, nums[i]);
      }
    }
    return result.size();
  }

  private int binarySearch(ArrayList<Integer> arr, int target) {
    int low = 0, high = arr.size() - 1;
    int res = 0;

    while(low <= high) {
      int mid = low + (high - low) / 2;
      if(arr.get(mid) >= target) {
        res = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return res;
  }
}
