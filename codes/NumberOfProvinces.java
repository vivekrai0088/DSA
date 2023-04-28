import java.util.Arrays;

// https://leetcode.com/problems/number-of-provinces/description/
public class NumberOfProvinces {
  boolean[] visited;

  private void dfs(int[][] isConnected, int n, int i) {
    visited[i] = true;

    for(int j = 0; j < n; j++) {
      if(isConnected[i][j] == 1 && !visited[j]) {
        dfs(isConnected, n, j);
      }
    }
  }

  public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
    visited = new boolean[n];
    Arrays.fill(visited, false);

    int provinces = 0;
    for(int i = 0; i < n; i++) {
      if(!visited[i]) {
        provinces++;
        dfs(isConnected, n, i);
      }
    }
    return provinces;
  }
}
