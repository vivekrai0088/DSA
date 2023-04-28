import java.util.Arrays;

// https://leetcode.com/problems/range-sum-query-2d-immutable/description/
public class RangeSumQuery2D {
  int[][] cums;

  public RangeSumQuery2D(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    cums = new int[n + 1][m + 1];

    for(int i = 0; i <= n; i++) Arrays.fill(cums[i], 0);

    for(int i = 1; i <= n; i++) {
      for(int j = 1; j <= m; j++) {
        cums[i][j] = (cums[i - 1][j] + cums[i][j - 1] - cums[i - 1][j - 1]) + matrix[i - 1][j - 1];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    row1++; col1++; row2++; col2++;
    return (cums[row2][col2] - cums[row2][col1 - 1] - cums[row1 - 1][col2]) + cums[row1 - 1][col1 - 1];
  }
}
