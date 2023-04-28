import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// https://leetcode.com/problems/rotting-oranges/description/
public class RottenOranges {
  int[][] distance;
  int dx[] = {1, 0, -1, 0};
  int dy[] = {0, 1, 0, -1};

  private void printDistance() {
    for(int i = 0; i < distance.length; i++) {
      for(int j = 0; j < distance[0].length; j++) {
        System.out.print(distance[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private void bfs(int[][] grid, int n, int m) {
    Queue<int[]> queue = new ArrayDeque<>();

    // put all rotten tomatoes in queue
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(grid[i][j] == 2) {
          int[] node = {i, j};
          queue.add(node);
          distance[i][j] = 0;
        }
      }
    }

    while(queue.size() > 0) {
      // printDistance();
      int[] node = queue.poll();

      for(int i = 0; i < 4; i++) {
        int xx = node[0] + dx[i];
        int yy = node[1] + dy[i];

        if((xx >= 0 && yy >= 0 && xx < n && yy < m) && grid[xx][yy] == 1 && distance[xx][yy] > distance[node[0]][node[1]] + 1) {
          distance[xx][yy] = distance[node[0]][node[1]] + 1;
          int[] neighbour = {xx, yy};
          queue.add(neighbour);
        }
      }
    }
  }

  public int orangesRotting(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    distance = new int[n][m];
    for(int i = 0; i < n; i++) {
      Arrays.fill(distance[i], Integer.MAX_VALUE);
    }

    bfs(grid, n, m);

    int ans = 0;

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(grid[i][j] == 1) {
          ans = Math.max(ans, distance[i][j]);
        }
      }
    }
    if(ans == Integer.MAX_VALUE) return -1;
    return ans;
  }
}
