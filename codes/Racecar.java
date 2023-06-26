import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/race-car/description/
public class Racecar {
  public int racecar(int target) {
    Queue<int[]> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();

    queue.add(new int[]{0, 1});
    visited.add(0 + " " + 1);

    int distance = 0;
    while(!queue.isEmpty()) {
      int sz = queue.size();
      for(int i = 0; i < sz; i++) {
        int[] state = queue.poll();
        int position = state[0];
        int speed = state[1];

        if(position == target) {
          return distance;
        }

        // instruction accelerate
        int newPosition = position + speed;
        int newSpeed = speed * 2;
        String key = (newPosition + " " + newSpeed);
        if(!visited.contains(key) && (newPosition >= 0 && newPosition < target * 2)) {
          queue.add(new int[]{newPosition, newSpeed});
          visited.add(key);
        }

        // instruction reverse
        newPosition = position;
        newSpeed = (speed > 0) ? -1 : 1;
        key = (newPosition + " " + newSpeed);
        if(!visited.contains(key) && (newPosition >= 0 && newPosition < target * 2)) {
          queue.add(new int[]{newPosition, newSpeed});
          visited.add(newPosition + " " + newSpeed);
        }
      }
      distance++;
    }
    return -1;
  }

  public static void main(String[] args) {
    new Racecar().racecar(6);
  }
}
