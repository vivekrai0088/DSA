import java.util.Random;

// https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class KthLargestElementInArray {
  private int partition(int[] nums, int left, int right, int pIndex) {
    int pivot = nums[pIndex];
    int temp = nums[right];
    nums[right] = nums[pIndex];
    nums[pIndex] = temp;

    pIndex = left;
    for(int i = left; i <= right; i++) {
      if(nums[i] <= pivot) {
        int tmp = nums[i];
        nums[i] = nums[pIndex];
        nums[pIndex] = tmp;
        pIndex++;
      }
    }
    return pIndex - 1;
  }

  private int quickselect(int[] nums, int left, int right, int k) {
    if(left == right) return nums[left];

    int pIndex = new Random().nextInt(right - left + 1) + left;
    pIndex = partition(nums, left, right, pIndex);

    if(pIndex == k) return nums[k];
    else if(pIndex < k ) return quickselect(nums, pIndex + 1, right, k);
    return quickselect(nums, left, pIndex - 1, k);
  }

  public int findKthLargest(int[] nums, int k) {
    int sz = nums.length;

    return quickselect(nums, 0, nums.length - 1, nums.length - k);
  }

  public static void main(String[] args) {

    System.out.println(new KthLargestElementInArray().findKthLargest(new int[]{10, 7, 4, 9, 3}, 4));
  }
}
