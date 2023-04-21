// https://leetcode.com/problems/jump-game-ii/
public class JumpGameII {

  public int jump(int[] nums) {
    int sz = nums.length;
    int steps = 0;
    if(sz == 1) return 0;

    for(int i = 0; i < sz; i++) {
      int index = -1;
      int maxIndexReachable = i + nums[i];
      if(maxIndexReachable >= sz - 1) return steps + 1;

      for(int j = i + 1; j <= i + nums[i]; j++) {
        if(j + nums[j] > maxIndexReachable) {
          maxIndexReachable = j + nums[j];
          index = j;
        }
      }
      steps++;
      if(maxIndexReachable >= sz - 1) return steps + 1;
      if(index == -1) return -1;

      i = index - 1;
    }
    return steps;
  }
}
