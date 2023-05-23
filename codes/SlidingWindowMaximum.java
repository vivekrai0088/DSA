import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SlidingWindowMaximum {
  public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> deque = new ArrayDeque<>();
    ArrayList<Integer> result = new ArrayList<>();
    for(int i = 0; i < nums.length; i++) {
      if(!deque.isEmpty() && deque.peek() < i - k + 1) {
        deque.poll();
      }
      while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.pollLast();
      }
      deque.addLast(i);
      if(i >= k - 1) {
        result.add(nums[deque.peekFirst()]);
      }
    }
    int[] ans = new int[result.size()];
    for(int i = 0; i < result.size(); i++) {
      ans[i] = result.get(i);
    }
    return ans;
  }
}
