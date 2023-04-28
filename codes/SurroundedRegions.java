import java.util.Arrays;

// https://leetcode.com/problems/surrounded-regions/description/
public class SurroundedRegions {
  // dfs from boundry nodes
  boolean[][] visited;
  int dx[] = {1, 0, -1, 0};
  int dy[] = {0, 1, 0, -1};

  private void dfs(char[][] board, int n, int m, int i, int j) {
    visited[i][j] = true;
    for(int k = 0; k < 4; k++) {
      int ii = i + dx[k];
      int jj = j + dy[k];
      if((ii >= 0 && jj >= 0 && ii < n && jj < m) && board[ii][jj] == 'O' && !visited[ii][jj]) {
        dfs(board, n, m, ii, jj);
      }
    }
  }

  public void solve(char[][] board) {
    int n = board.length;
    int m = board[0].length;
    visited = new boolean[n][m];
    for(int i = 0; i < n; i++) {
      Arrays.fill(visited[i], false);
    }

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(i == 0 || j == 0 || i == n - 1 || j == m - 1) {
          if(board[i][j] == 'O') {
            dfs(board, n, m, i, j);
          }
        }
      }
    }

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(visited[i][j]) {
          board[i][j] = 'O';
        } else {
          board[i][j] = 'X';
        }
      }
    }
  }
}
