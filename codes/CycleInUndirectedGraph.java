import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.interviewbit.com/problems/cycle-in-undirected-graph/
public class CycleInUndirectedGraph {
  boolean[] visited;
  private boolean hasCycle(List<List<Integer>> graph, int u, int parent) {
    visited[u] = true;
    List<Integer> children = graph.get(u);

    for (Integer c : children) {
      if (!visited[c]) {
        if (hasCycle(graph, c, u))
          return true;
      } else if (c != parent)
        return true;
    }
    return false;
  }

  public int solve(int A, ArrayList<ArrayList<Integer>> B) {
    visited = new boolean[A];
    Arrays.fill(visited, false);
    List<List<Integer>> graph = new ArrayList<List<Integer>>();
    for(int i = 0; i < A; i++) graph.add(new ArrayList<Integer>());

    for(int i = 0; i < B.size(); i++) {
      int u = B.get(i).get(0);
      int v = B.get(i).get(1);
      graph.get(u - 1).add(v - 1);
      graph.get(v - 1).add(u - 1);
    }

    for(int i = 0; i < A; i++) {
      if(!visited[i] && hasCycle(graph, i, -1)) {
        return 1;
      }
    }
    return 0;
  }
}
