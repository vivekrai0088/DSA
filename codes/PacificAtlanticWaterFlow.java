import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/pacific-atlantic-water-flow/description/
public class PacificAtlanticWaterFlow {
  int PACIFIC = 0;
  int ATLANTIC = 1;

  boolean[][] pacificVisited;
  boolean[][] atlanticVisited;

  int dx[] = {1, 0, -1, 0};
  int dy[] = {0, 1, 0, -1};

  private void bfs(int[][] heights, int n, int m, int oceanType) {
    Queue<int[]> queue = new ArrayDeque<>();
    if(oceanType == PACIFIC) {
      for(int i = 0; i < n; i++) {
        queue.add(new int[]{i, 0});
        pacificVisited[i][0] = true;
      }
      for(int j = 0; j < m; j++) {
        queue.add(new int[]{0, j});
        pacificVisited[0][j] = true;
      }
    } else if(oceanType == ATLANTIC) {
      for(int i = 0; i < n; i++) {
        queue.add(new int[]{i, m - 1});
        atlanticVisited[i][m - 1] = true;
      }
      for(int j = 0; j < m; j++) {
        queue.add(new int[]{n - 1, j});
        atlanticVisited[n - 1][j] = true;
      }
    }

    while(!queue.isEmpty()) {
      int[] node = queue.poll();

      for(int i = 0; i < 4; i++) {
        int xx = node[0] + dx[i];
        int yy = node[1] + dy[i];

        if((xx >= 0 && xx < n && yy >= 0 && yy < m) && heights[node[0]][node[1]] <= heights[xx][yy]) {
          if(oceanType == PACIFIC && !pacificVisited[xx][yy]) {
            pacificVisited[xx][yy] = true;
            queue.add(new int[]{xx, yy});
          } else if(oceanType == ATLANTIC && !atlanticVisited[xx][yy]) {
            atlanticVisited[xx][yy] = true;
            queue.add(new int[]{xx, yy});
          }
        }
      }
    }
  }

  private void initialize() {
    for(int i = 0; i < pacificVisited.length; i++) Arrays.fill(pacificVisited[i], false);
    for(int i = 0; i < atlanticVisited.length; i++) Arrays.fill(atlanticVisited[i], false);
  }

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int n = heights.length;
    int m = heights[0].length;

    pacificVisited = new boolean[n][m];
    atlanticVisited = new boolean[n][m];

    initialize();

    bfs(heights, n, m, PACIFIC);
    bfs(heights, n, m, ATLANTIC);

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(pacificVisited[i][j] && atlanticVisited[i][j]) {
          result.add(new ArrayList<>(Arrays.asList(i, j)));
        }
      }
    }
    return result;
  }
}
