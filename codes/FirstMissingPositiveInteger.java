public class FirstMissingPositiveInteger {
  public int firstMissingPositive(int[] nums) {
    int sz = nums.length;

    // sanitize
    for(int i = 0; i < sz; i++) {
      if(nums[i] < 0 || nums[i] >= sz + 1) {
        nums[i] = 0;
      } else {
        nums[i] = nums[i] * 2;
      }
    }

    // use existing array as hashmap
    for(int i = 0; i < sz; i++) {
      int oldValue = nums[i] / 2;
      if(oldValue < 1 || oldValue >= sz + 1) continue;


      // check for duplicacy, if not present, mark it as present
      if(nums[oldValue - 1] % 2 != 1) {
        nums[oldValue - 1]++;
      }
    }

    for(int i = 0; i < sz; i++) {
      if(nums[i] % 2 == 0) return i + 1;
    }
    return sz + 1;
  }
}
