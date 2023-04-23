// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class TwoSumII {
  public int[] twoSum(int[] numbers, int target) {
    int sz = numbers.length;

    int i = 0, j = sz - 1;
    while(i < j) {
      if(numbers[i] + numbers[j] == target) {
        int[] entry = new int[2];
        entry[0] = i + 1;
        entry[1] = j + 1;
        return entry;
      } else if(numbers[i] + numbers[j] < target) {
        i++;
      } else {
        j--;
      }
    }
    return new int[2];
  }
}
