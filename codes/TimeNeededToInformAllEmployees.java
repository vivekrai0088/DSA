import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TimeNeededToInformAllEmployees {
  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    List<Integer>[] graph = new ArrayList[n];
    for(int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    int head = 0;
    for(int i = 0; i < n; i++) {
      if(manager[i] == -1) {
        head = i;
        continue;
      }
      int u = i;
      int v = manager[i];
      graph[v].add(u);
    }

    return bfs(graph, head, informTime);
  }

  private int bfs(List<Integer>[] graph, int node, int[] informTime) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{node, 0});
    int ans = 0;
    while(!queue.isEmpty()) {
      int[] top = queue.poll();
      int u = top[0], w = top[1];
      ans = Math.max(ans, w);
      for(int v : graph[u]) {
        queue.offer(new int[]{v, w + informTime[u]});
      }
    }
    return ans;
  }
}
