import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// https://leetcode.com/problems/01-matrix/description/
public class Matrix01 {
  int[][] distance;
  int[] dx = {1, 0, -1, 0};
  int[] dy = {0, 1, 0, -1};

  private void bfs(int[][] mat, int n, int m) {
    Queue<int[]> queue = new ArrayDeque<>();

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(mat[i][j] == 0) {
          queue.add(new int[]{i, j});
          distance[i][j] = 0;
        }
      }
    }

    while(!queue.isEmpty()) {
      int[] node = queue.poll();
      int x = node[0];
      int y = node[1];

      for(int i = 0; i < 4; i++) {
        int xx = x + dx[i];
        int yy = y + dy[i];

        if((xx >= 0 && xx < n && yy >= 0 && yy < m) && mat[xx][yy] == 1 && distance[xx][yy] > distance[x][y] + 1) {
          distance[xx][yy] = distance[x][y] + 1;
          queue.add(new int[]{xx, yy});
        }
      }
    }
    return;
  }

  public int[][] updateMatrix(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;
    distance = new int[n][m];
    for(int i = 0; i < n; i++) {
      Arrays.fill(distance[i], Integer.MAX_VALUE);
    }

    bfs(mat, n, m);
    return distance;
  }
}
