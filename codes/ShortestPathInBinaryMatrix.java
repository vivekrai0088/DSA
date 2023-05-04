import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// asked in interview
public class ShortestPathInBinaryMatrix {
  boolean[][] visited;
  int[] dx = {1, 0, -1, 0, -1, 1, -1, 1};
  int[] dy = {0, -1, 0, 1, -1, 1, 1, -1};

  public class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private int bfs(int[][] grid, int n, int m) {

    Queue<Pair> queue = new ArrayDeque<>();
    if(grid[0][0] == 1) return -1;
    queue.add(new Pair(0, 0));
    visited[0][0] = true;
    int distance = 0;

    while(!queue.isEmpty()) {
      int sz = queue.size();

      for(int i = 0; i < sz; i++) {
        Pair node = queue.poll();
        int x = node.x;
        int y = node.y;
        if(x == n - 1 && y == m - 1) {
          return distance + 1;
        }

        for(int k = 0; k < 8; k++) {
          int xx = x + dx[k];
          int yy = y + dy[k];

          if((xx >= 0 && xx < n && yy >= 0 && yy < m) && grid[xx][yy] == 0 && !visited[xx][yy]) {
            queue.add(new Pair(xx, yy));
            visited[xx][yy] = true;
          }
        }
      }
      distance++;
    }
    return -1;
  }

  public int shortestPathBinaryMatrix(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    visited = new boolean[n][m];
    for(int i = 0; i < n; i++) {
      Arrays.fill(visited[i], false);
    }
    int shortestPath = bfs(grid, n, m);
    return shortestPath;
  }
}
