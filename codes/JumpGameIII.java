import java.util.ArrayDeque;
import java.util.Queue;

public class JumpGameIII {
  private boolean bfs(int[] arr, int start) {
    boolean[] visited = new boolean[arr.length];
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(start);

    while(!queue.isEmpty()) {
      int node = queue.poll();
      if(arr[node] == 0) return true;

      if(node + arr[node] < arr.length && !visited[node + arr[node]]) {
        visited[node + arr[node]] = true;
        queue.add(node + arr[node]);
      }
      if(node - arr[node] >= 0 && !visited[node - arr[node]]) {
        visited[node - arr[node]] = true;
        queue.add(node - arr[node]);
      }
    }
    return false;
  }

  public boolean canReach(int[] arr, int start) {
    return bfs(arr, start);
  }
}
