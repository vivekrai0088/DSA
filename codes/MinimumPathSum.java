// https://leetcode.com/problems/minimum-path-sum/description/
public class MinimumPathSum {
  public int minPathSum(int[][] grid) {
    int rowSize = grid.length;
    int colSize = grid[0].length;

    int[][] dp = new int[rowSize][colSize];

    for(int i = 0; i < rowSize; i++) {
      for(int j = 0; j < colSize; j++) {
        if(i == 0 && j == 0) {
          dp[i][j] = grid[i][j];
        } else if(i == 0) {
          dp[i][j] = dp[i][j - 1] + grid[i][j];
        } else if(j == 0) {
          dp[i][j] = dp[i - 1][j] + grid[i][j];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
        }
      }
    }
    return dp[rowSize - 1][colSize - 1];
  }
}
