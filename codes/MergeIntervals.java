import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/merge-intervals/description/
public class MergeIntervals {
  private boolean checkOverLapping(int x1, int y1, int x2, int y2) {
    if(Math.max(x1, x2) <= Math.min(y1, y2)) return true;
    return false;
  }

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

    int start = intervals[0][0];
    int end = intervals[0][1];

    ArrayList<int[]> ans = new ArrayList<int[]>();
    for(int i = 1; i < intervals.length; i++) {
      if(!checkOverLapping(start, end, intervals[i][0], intervals[i][1])) {
        ans.add(new int[]{start, end});
        start = intervals[i][0];
        end = intervals[i][1];
      } else {
        end = Math.max(end, intervals[i][1]);
      }
    }
    ans.add(new int[]{start, end});
    int[][] result = new int[ans.size()][2];
    for(int i = 0; i < ans.size(); i++) {
      result[i][0] = ans.get(i)[0];
      result[i][1] = ans.get(i)[1];
    }
    return result;
  }
}
