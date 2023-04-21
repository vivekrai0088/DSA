// https://leetcode.com/problems/jump-game/description/
public class JumpGame {
  public boolean canJump(int[] nums) {
    int sz = nums.length;

    int minIndexPossible = sz - 1;

    for(int i = sz - 2; i >= 0; i--) {
      boolean isPossible = false;
      if(i + nums[i] >= minIndexPossible) {
        minIndexPossible = i;
        isPossible = true;
      }
      if(i == 0) return isPossible;
    }
    return true;
  }
}
