import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/keys-and-rooms/description/
public class KeysAndRooms {
  boolean[] visited;

  private void bfs(List<List<Integer>> rooms, int n) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    visited[0] = true;

    while(queue.size() > 0 ) {
      int node = queue.poll();

      List<Integer> neighbours = rooms.get(node);
      for(int i = 0; i < neighbours.size(); i++) {
        if(!visited[neighbours.get(i)]) {
          queue.add(neighbours.get(i));
          visited[neighbours.get(i)] = true;
        }
      }
    }
  }

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    int n = rooms.size();
    visited = new boolean[n];
    Arrays.fill(visited, false);

    bfs(rooms, n);
    for(int i = 0; i < n; i++) {
      if(!visited[i]) return false;
    }
    return true;
  }
}

