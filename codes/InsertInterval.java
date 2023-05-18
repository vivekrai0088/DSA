import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/insert-interval/description/
public class InsertInterval {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new LinkedList<>();

    int i = 0;
    while(i < intervals.length && intervals[i][1] < newInterval[0]) {
      result.add(intervals[i]);
      i++;
    }

    while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
      newInterval = new int[]{Math.min(newInterval[0], intervals[i][0]), Math.max(newInterval[1], intervals[i][1])};
      i++;
    }

    result.add(newInterval);

    while(i < intervals.length) {
      result.add(intervals[i]);
      i++;
    }

    int[][] ans = new int[result.size()][2];
    for(int k = 0; k < result.size(); k++) {
      ans[k][0] = result.get(k)[0];
      ans[k][1] = result.get(k)[1];
    }
    return ans;
  }
}
