import java.util.Arrays;

// https://leetcode.com/problems/where-will-the-ball-fall/description/
public class WhereWillTheBallFall {
  int[][] dp;
  private boolean isValid(int x1, int y1, int n, int m) {
    return (x1 >= 0 && x1 < n && y1 >= 0 && y1 < m);
  }

  private int dfs(int[][] grid, int n, int m, int i, int j) {
    if(i == n) return j;
    if(dp[i][j] != -2) return dp[i][j];
    int ans = -1;
    if(isValid(i, j, n, m)) {
      if(grid[i][j] == 1 && isValid(i, j + 1, n, m) && grid[i][j + 1] == 1) {
        ans = dfs(grid, n, m, i + 1, j + 1);
      }
      if(grid[i][j] == -1 && isValid(i, j - 1, n, m) && grid[i][j - 1] == -1) {
        ans = dfs(grid, n, m, i + 1, j - 1);
      }
    }
    return dp[i][j] = ans;
  }

  public int[] findBall(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int[] ans = new int[m];
    dp = new int[n][m];
    for(int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -2);
    }

    for(int j = 0; j < m; j++) {
      ans[j] = dfs(grid, n, m, 0, j);
    }
    return ans;
  }
}
