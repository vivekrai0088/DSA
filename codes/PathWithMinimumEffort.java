import java.util.Arrays;

public class PathWithMinimumEffort {
  boolean[][] visited;

  int dx[] = {1, 0, -1, 0};
  int dy[] = {0, 1, 0, -1};

  private boolean dfs(int[][] heights, int n, int m, int i, int j, int k) {
    if(i == n - 1 && j == m - 1) {
      return true;
    }
    visited[i][j] = true;
    for(int index = 0; index < 4; index++) {
      int ii = i + dx[index];
      int jj = j + dy[index];

      if((ii >= 0 && ii < n && jj >= 0 && jj < m) && !visited[ii][jj] && Math.abs(heights[i][j] - heights[ii][jj]) <= k) {
        if(dfs(heights, n, m, ii, jj, k)) {
          return true;
        }
      }
    }
    return false;
  }

  private void resetVisited(int n, int m) {
    visited = new boolean[n][m];
    for(int i = 0; i < n; i++) {
      Arrays.fill(visited[i], false);
    }
  }

  public int minimumEffortPath(int[][] heights) {
    int n = heights.length;
    int m = heights[0].length;
    int low = 0, high = 1000006;
    int ans = 0;

    while(low <= high) {
      int mid = low + (high - low) / 2;
      resetVisited(n, m);
      if(dfs(heights, n, m, 0, 0, mid)) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return ans;
  }
}
