import java.util.ArrayList;

// https://www.interviewbit.com/problems/woodcutting-made-easy/
public class WoodCuttingMadeEasy {
  public int solve(ArrayList<Integer> A, int B) {
    int low = 0, high = 0;

    for(int i = 0; i < A.size(); i++) {
      high = Math.max(high, A.get(i));
    }

    int res = 0;
    while(low <= high) {
      int mid = low + (high - low) / 2;
      if(isPossible(A, mid, B)) {
        res = mid;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return res;
  }

  private boolean isPossible(ArrayList<Integer> treeHeights, int sawBladeHeight, int woodRequired) {
    long woodCollected = 0L;
    for(int i = 0; i < treeHeights.size(); i++) {
      woodCollected += (long) Math.max(0L, treeHeights.get(i) - sawBladeHeight);
    }
    return (woodCollected >= (long) woodRequired);
  }
}
