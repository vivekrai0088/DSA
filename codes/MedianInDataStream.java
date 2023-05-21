import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/description/
public class MedianInDataStream {
  PriorityQueue<Integer> maxHeap;
  PriorityQueue<Integer> minHeap;
  boolean even = true;

  public MedianInDataStream() {
    maxHeap = new PriorityQueue<>((a, b) -> (b.compareTo(a)));
    minHeap = new PriorityQueue<>((a, b) -> (a.compareTo(b)));
  }

  public void addNum(int num) {
    if(even) {
      minHeap.offer(num);
      maxHeap.offer(minHeap.poll());
    } else {
      maxHeap.offer(num);
      minHeap.offer(maxHeap.poll());
    }
    even = !even;
  }

  public double findMedian() {
    if(even) {
      return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
    return maxHeap.peek();
  }
}
