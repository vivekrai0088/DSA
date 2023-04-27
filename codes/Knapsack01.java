import java.util.ArrayList;
import java.util.Arrays;

// https://www.interviewbit.com/problems/0-1-knapsack/
public class Knapsack01 {
  int dp[][];

  private int rec(ArrayList<Integer> values, ArrayList<Integer> weights, int capacity, int n) {
    if(n == 0 || capacity == 0) {
      return 0;
    }
    if(dp[capacity][n] != -1) return dp[capacity][n];
    if(weights.get(n - 1) > capacity) {
      return rec(values, weights, capacity, n - 1);
    }
    int include = values.get(n - 1) + rec(values, weights, capacity - weights.get(n - 1), n - 1);
    int exclude = rec(values, weights, capacity, n - 1);
    return dp[capacity][n] = Math.max(include, exclude);
  }

  public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
    int sz = B.size();
    dp = new int[C + 1][sz + 1];
    for(int i = 0; i <= C; i++) {
      Arrays.fill(dp[i], -1);
    }
    return rec(A, B, C, sz);
  }

}
