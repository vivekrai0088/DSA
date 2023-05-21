import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/task-scheduler/description/
public class TaskScheduler {
  public int leastInterval(char[] tasks, int n) {
    Map<Character, Integer> map = new HashMap<>();
    for(int i = 0; i < tasks.length; i++) {
      map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
    }
    PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(
            (a, b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey()
    );
    queue.addAll(map.entrySet());

    int count = 0;
    while(!queue.isEmpty()) {
      int interval = n + 1;
      List<Map.Entry<Character, Integer>> tempList = new ArrayList<>();
      while(interval > 0 && !queue.isEmpty()) {
        Map.Entry<Character, Integer> top = queue.poll();
        top.setValue(top.getValue() - 1);
        tempList.add(top);
        interval--;
        // on slot is taken
        count++;
      }

      for(Map.Entry<Character, Integer> entry : tempList) {
        if(entry.getValue() > 0) {
          queue.offer(entry);
        }
      }
      // job done
      if(queue.isEmpty()) {
        break;
      }
      count += interval;
    }
    return count;
  }
}
