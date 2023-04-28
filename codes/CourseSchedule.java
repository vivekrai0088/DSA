import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/course-schedule/description/
public class CourseSchedule {
  boolean[] visited;
  boolean[] recStack; // for finding back edge
  int[] indegree;

  private boolean hasCycle(List<List<Integer>> courseGraph, int u) {
    if(recStack[u]) return true;
    if(visited[u]) return false;

    visited[u] = true;
    recStack[u] = true;
    List<Integer> neighbours = courseGraph.get(u);
    for(int i = 0; i < neighbours.size(); i++) {
      int v = neighbours.get(i);
      if(hasCycle(courseGraph, v)) {
        return true;
      }
    }
    recStack[u] = false;
    return false;
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    visited = new boolean[numCourses];
    recStack = new boolean[numCourses];
    indegree = new int[numCourses];
    Arrays.fill(indegree, 0);
    Arrays.fill(visited, false);
    Arrays.fill(recStack, false);
    List<List<Integer>> courseGraph = new ArrayList<List<Integer>>();
    for(int i = 0; i < numCourses; i++) {
      courseGraph.add(new ArrayList<Integer>());
    }


    for(int i = 0; i < prerequisites.length; i++) {
      int u = prerequisites[i][1];
      int v = prerequisites[i][0];
      if(u == v) return false;
      indegree[v]++;
      courseGraph.get(u).add(v);
    }

    boolean hasAtleastOneRoot = false;
    for(int i = 0; i < numCourses; i++) {
      if(indegree[i] == 0) {
        hasAtleastOneRoot = true;
        break;
      }
    }

    if(!hasAtleastOneRoot) return false;


    for(int i = 0; i < numCourses; i++) {
      if(hasCycle(courseGraph, i)) {
        return false;
      }
    }
    return true;
  }
}
