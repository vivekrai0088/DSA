// https://leetcode.com/problems/unique-paths-ii/description/
public class UniquePathsII {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int rowSize = obstacleGrid.length;
    int colSize = obstacleGrid[0].length;

    int[][] dp = new int[rowSize][colSize];
    if(obstacleGrid[0][0] == 1) return 0;

    dp[0][0] = 1;
    for(int i = 1; i < colSize; i++) {
      if(obstacleGrid[0][i] == 1) {
        dp[0][i] = 0;
      } else {
        dp[0][i] = dp[0][i - 1];
      }
    }

    for(int i = 1; i < rowSize; i++) {
      if(obstacleGrid[i][0] == 1) {
        dp[i][0] = 0;
      } else {
        dp[i][0] = dp[i - 1][0];
      }
    }

    for(int i = 1; i < rowSize; i++) {
      for(int j = 1; j < colSize; j++) {
        if(obstacleGrid[i][j] == 1) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }
    return dp[rowSize - 1][colSize - 1];
  }
}
