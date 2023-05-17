// https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
public class PeakIndexInMountainArray {
  public int peakIndexInMountainArray(int[] arr) {
    int low = 0, high = arr.length - 2;
    int ans = 0;
    while(low < high) {
      int mid = low + (high - low) / 2;
      if(arr[mid] < arr[mid + 1]) {
        ans = mid + 1;
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return ans;
  }
}
