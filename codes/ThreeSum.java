import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    int sz = nums.length;
    List<List<Integer>> triplets = new ArrayList<List<Integer>>();

    for(int i = 0; i < sz; i++) {
      if(i > 0 && nums[i] == nums[i - 1]) continue;
      int first = nums[i];
      int target = -1 * first;
      int j = i + 1, k = sz - 1;
      while(j < k) {
        if(nums[j] + nums[k] == target) {
          List<Integer> triplet = new ArrayList<>();
          triplet.add(first);
          triplet.add(nums[j]);
          triplet.add(nums[k]);
          triplets.add(triplet);
          while(j < k && nums[j] == nums[j + 1]) j++;
          while(j < k && nums[k] == nums[k - 1]) k--;
          j++;
          k--;
        } else if(nums[j] + nums[k] < target) {
          j++;
        } else {
          k--;
        }
      }
    }
    return triplets;
  }
}
