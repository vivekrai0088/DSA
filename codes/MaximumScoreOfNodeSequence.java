import java.util.PriorityQueue;

public class MaximumScoreOfNodeSequence {
  public int maximumScore(int[] scores, int[][] edges) {
    int n = scores.length;

    PriorityQueue<Integer>[] pq = new PriorityQueue[n];

    for(int i = 0; i < n; i++) {
      pq[i] = new PriorityQueue<>((a, b) -> scores[a] - scores[b]);
    }

    for(int[] edge : edges) {
      pq[edge[0]].offer(edge[1]);
      pq[edge[1]].offer(edge[0]);
      if(pq[edge[0]].size() > 3) pq[edge[0]].poll();
      if(pq[edge[1]].size() > 3) pq[edge[1]].poll();
    }
    int res = -1;
    for(int[] edge : edges) {
      for(int i : pq[edge[0]]) {
        for(int j : pq[edge[1]]) {
          if(i != j && i != edge[1] && j != edge[0]) {
            res = Math.max(res, scores[i] + scores[j] + scores[edge[0]] + scores[edge[1]]);
          }
        }
      }
    }
    return res;
  }
}
