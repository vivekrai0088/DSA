// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
public class CapacityToShipPackageWithinDDays {
  private int computeDays(int[] weights, int capacity) {
    int days = 1;
    int current = 0;
    for(int i = 0; i < weights.length; i++) {
      if(current + weights[i] > capacity) {
        days++;
        current = 0;
      }
      current += weights[i];
    }
    return days;
  }

  public int shipWithinDays(int[] weights, int days) {
    int sz = weights.length;
    int low = 0, high = 0;
    for(int i = 0; i < sz; i++) {
      low = Math.max(low, weights[i]);
      high += weights[i];
    }
    int ans = 0;

    while(low <= high) {
      int mid = low + (high - low) / 2;
      if(computeDays(weights, mid) <= days) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return ans;
  }
}
