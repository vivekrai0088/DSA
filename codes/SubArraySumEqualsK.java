import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarray-sum-equals-k/description/
public class SubArraySumEqualsK {
  public int subarraySum(int[] nums, int k) {
    int sz = nums.length;

    int cum[] = new int[sz + 1];
    cum[0] = 0;
    for(int i = 1; i < sz + 1; i++) {
      cum[i] = cum[i - 1] + nums[i - 1];
    }

    int result = 0;
    Map<Integer, Integer> freqMap = new HashMap<>();
    freqMap.put(0, 1);

    for(int i = 1; i <= sz; i++) {
      int toFind = cum[i] - k;
      if(freqMap.containsKey(toFind)) {
        result += freqMap.get(toFind);
      }
      freqMap.put(cum[i], freqMap.getOrDefault(cum[i], 0) + 1);
    }

    return result;
  }
}
