import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// interview question
// https://leetcode.com/problems/course-schedule-ii/description/
public class CourseScheduleII {
  List<List<Integer>> graph;
  int[] indegree;

  private List<Integer> bfs(int n) {
    Queue<Integer> queue = new ArrayDeque<>();

    for(int i = 0; i < n; i++) {
      if(indegree[i] == 0) {
        queue.add(i);
      }
    }

    int nodesFinished = 0;
    List<Integer> result = new ArrayList<>();
    while(!queue.isEmpty()) {
      Integer u = queue.poll();
      if(indegree[u] == 0) {
        result.add(u);
      }

      List<Integer> neighbours = graph.get(u);
      for(int i = 0; i < neighbours.size(); i++) {
        int v = neighbours.get(i);
        indegree[v]--;
        if(indegree[v] == 0) {
          queue.add(v);
        }
      }
    }
    return result;
  }

  private void initialize(int n, int[][] prerequisites) {
    graph = new ArrayList<List<Integer>>();
    for(int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    indegree = new int[n];
    Arrays.fill(indegree, 0);

    for(int i = 0; i < prerequisites.length; i++) {
      int u = prerequisites[i][1];
      int v = prerequisites[i][0];

      graph.get(u).add(v);
      indegree[v]++;
    }
  }

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    initialize(numCourses, prerequisites);

    List<Integer> result = bfs(numCourses);
    if(result.size() != numCourses) return new int[0];
    int[] ans = new int[result.size()];
    for(int i = 0; i < result.size(); i++) {
      ans[i] = result.get(i);
    }
    return ans;
  }
}
