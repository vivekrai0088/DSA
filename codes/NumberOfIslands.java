import java.util.Arrays;

// https://leetcode.com/problems/number-of-islands/description/

public class NumberOfIslands {
  boolean[][] visited;

  int dx[] = {1, 0, -1, 0};
  int dy[] = {0, 1, 0, -1};

  private void dfs(char[][] grid, int n, int m, int i, int j) {
    visited[i][j] = true;

    for(int k = 0; k < 4; k++) {
      int ii = i + dx[k];
      int jj = j + dy[k];
      if((ii >= 0 && jj >= 0 && ii < n && jj < m) && grid[ii][jj] == '1' && !visited[ii][jj]) {
        dfs(grid, n, m, ii, jj);
      }
    }
  }

  public int numIslands(char[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    visited = new boolean[n][m];
    for(int i = 0; i < n; i++) {
      Arrays.fill(visited[i], false);
    }

    int islands = 0;
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(grid[i][j] == '1' && !visited[i][j]) {
          dfs(grid, n, m, i, j);
          islands++;
        }
      }
    }
    return islands;
  }
}
