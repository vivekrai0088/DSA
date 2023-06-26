import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/my-calendar-i/description/
public class MyCalender {
  PriorityQueue<Interval> pq;

  public MyCalender() {
    pq = new PriorityQueue<Interval>((a, b) -> b.start - a.start);
  }

  private boolean isOverlapping(int start1, int end1, int start2, int end2) {
    if(Math.max(start1, start2) < Math.min(end1, end2)) {
      return true;
    }
    return false;
  }

  public boolean book(int start, int end) {
    Interval interval = new Interval(start, end);
    List<Interval> intervals = new ArrayList<>(pq);
    for(int i = 0; i < intervals.size(); i++) {
      if(isOverlapping(interval.start, interval.end, intervals.get(i).start, intervals.get(i).end)) {
        return false;
      }
    }

    pq.add(interval);
    return true;
  }

  class Interval implements Comparable<Interval> {
    int start;
    int end;

    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public int compareTo(Interval interval) {
      return this.start - interval.start;
    }
  }
}
