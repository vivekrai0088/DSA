import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/description/
public class ShortestPathInAGridWithObstacleElimination {
  int[] dx = {1, 0, -1, 0};
  int[] dy = {0, 1, 0, -1};

  public int shortestPath(int[][] grid, int k) {
    int n = grid.length;
    int m = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0, 0});
    boolean[][][] visited = new boolean[n][m][k + 1];
    visited[0][0][0] = true;

    int result = 0;
    while(!queue.isEmpty()) {
      int sz = queue.size();
      for(int i = 0; i < sz; i++) {
        int[] top = queue.poll();
        int x = top[0];
        int y = top[1];
        int curK = top[2];
        if(x == n - 1 && y == m - 1) return result;

        for(int yo = 0; yo < 4; yo++) {
          int xx = x + dx[yo];
          int yy = y + dy[yo];
          int nextK = curK;
          if((xx >= 0 && xx < n && yy >= 0 && yy < m)) {
            if(grid[xx][yy] == 1) {
              nextK++;
            }
            if(nextK <= k && !visited[xx][yy][nextK]) {
              visited[xx][yy][nextK] = true;
              queue.add(new int[]{xx, yy, nextK});
            }
          }
        }
      }
      result++;
    }
    return -1;
  }
}
