import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    int sz = nums.length;
    Map<Integer, Integer> presenceMap = new HashMap<>();
    for(int i = 0; i < sz; i++) {
      if(presenceMap.containsKey(nums[i])) {
        return true;
      }
      presenceMap.put(nums[i], presenceMap.getOrDefault(nums[i], 0) + 1);
    }
    return false;
  }
}
