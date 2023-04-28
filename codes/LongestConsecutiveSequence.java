import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/description/
public class LongestConsecutiveSequence {
  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int sz = nums.length;

    for(int i = 0; i < sz; i++) {
      set.add(nums[i]);
    }

    int maxi = 0;
    for(int i = 0; i < sz; i++) {
      int start = nums[i];
      if(!set.contains(start - 1)) {
        int ans = 1;
        start++;
        while(set.contains(start)) {
          start++;
          ans++;
        }
        maxi = Math.max(maxi, ans);
      }
    }
    return maxi;
  }
}
