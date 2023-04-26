// https://leetcode.com/problems/koko-eating-bananas/description/
public class KokoEatingBananas {
  public int minEatingSpeed(int[] piles, int h) {
    int sz = piles.length;

    int low = 1, high = Integer.MAX_VALUE;
    int res = 0;

    while(low <= high) {
      int mid = low + (high - low) / 2;
      if(isPossible(piles, mid, h)) {
        res = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return res;
  }

  private boolean isPossible(int[] piles, int rate, int hours) {
    int sz = piles.length;
    long hoursNeeded = 0;

    for(int i = 0; i < sz; i++) {
      hoursNeeded += (long)(piles[i] / rate);
      if(piles[i] % rate != 0) {
        hoursNeeded++;
      }
    }
    return (hoursNeeded <= hours);
  }
}
