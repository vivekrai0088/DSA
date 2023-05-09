import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContiguosArray {
  public int findMaxLength(int[] nums) {
    int sz = nums.length;
    int[] cum = new int[sz + 1];
    Arrays.fill(cum, 0);

    for(int i = 0; i < sz; i++) {
      if(nums[i] == 0) {
        nums[i] = -1;
      }
    }

    for(int i = 1; i <= sz; i++) {
      cum[i] = cum[i - 1] + nums[i - 1];
    }

    Map<Integer, Integer> indexMap = new HashMap<>();
    indexMap.put(0, 0);

    int maxLength = 0;
    for(int i = 1; i <= sz; i++) {
      if(indexMap.containsKey(cum[i])) {
        maxLength = Math.max(maxLength, i - indexMap.get(cum[i]));
      } else {
        indexMap.put(cum[i], i);
      }
    }
    return maxLength;
  }
}
