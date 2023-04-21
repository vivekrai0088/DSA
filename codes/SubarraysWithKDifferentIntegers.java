import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarrays-with-k-different-integers/
public class SubarraysWithKDifferentIntegers {
  public int subarraysWithKDistinct(int[] nums, int k) {
    return subarraysWithAtmostK(nums, k) - subarraysWithAtmostK(nums, k - 1);
  }

  private int subarraysWithAtmostK(int[] nums, int k) {
    int sz = nums.length;
    int i = 0, j = 0;
    Map<Integer, Integer> countMap = new HashMap<>();
    int count = 0;
    while(j < sz) {
      countMap.put(nums[j], countMap.getOrDefault(nums[j], 0) + 1);

      while(countMap.size() == k + 1) {
        countMap.put(nums[i], countMap.get(nums[i]) - 1);
        if(countMap.get(nums[i]) == 0) {
          countMap.remove(nums[i]);
        }
        i++;
      }
      count += (j - i + 1);
      j++;
    }
    return count;
  }
}
