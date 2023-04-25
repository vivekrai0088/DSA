import java.util.ArrayList;

// https://www.interviewbit.com/problems/painters-partition-problem/

public class PainterPartitionProblem {
  private int MOD = 10000003;
  private Long getMax(ArrayList<Integer> arr) {
    Long maxi = 0L;
    for(int i = 0; i < arr.size(); i++) {
      maxi = Math.max(maxi, Long.valueOf(arr.get(i)));
    }
    return maxi;
  }

  private Long getSum(ArrayList<Integer> arr) {
    Long ans = 0L;
    for(int i = 0; i < arr.size(); i++) {
      ans += Long.valueOf(arr.get(i));
    }
    return ans;
  }

  private int isPossible(ArrayList<Integer> boards, int painters, Long time) {

    Long currentPaint = 0L;
    int paintersRequired = 1;
    for(int i = 0; i < boards.size(); i++) {
      if(boards.get(i) > time) return 0;
      if(currentPaint + Long.valueOf(boards.get(i)) <= time) {
        currentPaint += Long.valueOf(boards.get(i));
      } else {
        currentPaint = Long.valueOf(boards.get(i));
        paintersRequired++;
      }
    }
    if(paintersRequired <= painters) return 1;
    return 0;
  }

  public int paint(int A, int B, ArrayList<Integer> C) {
    Long low = getMax(C), high = getSum(C);

    Long ans = -1L;
    while(low <= high) {
      Long mid = low + (high - low) / 2L;
      if(isPossible(C, A, mid) == 1) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return (int)((ans % MOD) * (B % MOD)) % MOD;
  }
}
