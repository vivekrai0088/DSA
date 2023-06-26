import java.util.TreeMap;

// https://leetcode.com/problems/range-module/description/
public class RangeModule {
  TreeMap<Integer, Integer> treeMap;

  public RangeModule() {
    treeMap = new TreeMap<>();
  }

  public void addRange(int left, int right) {
    Integer floorKey = treeMap.floorKey(left);
    if(floorKey != null) {
      int prevLeft = floorKey, prevRight = treeMap.get(floorKey);
      if(left <= prevRight) {
        left = Math.min(left, prevLeft);
        right = Math.max(right, prevRight);
      }
    }
    treeMap.put(left, right);

    Integer higherKey = treeMap.higherKey(left);
    while(higherKey != null && higherKey <= right) {
      right = Math.max(right, treeMap.get(higherKey));
      treeMap.remove(higherKey);
      treeMap.put(left, right);
      higherKey = treeMap.higherKey(left);
    }
  }

  public boolean queryRange(int left, int right) {
    Integer floorKey = treeMap.floorKey(left);
    if(floorKey == null) return false;
    if(treeMap.get(floorKey) < right) return false;
    return true;
  }

  public void removeRange(int left, int right) {
    addRange(left, right);
    Integer floorKey = treeMap.floorKey(left);
    int left1 = floorKey, right1 = left;
    int left2 = right, right2 = treeMap.get(floorKey);
    treeMap.remove(floorKey);
    if(left1 < right1) {
      treeMap.put(left1, right1);
    }
    if(left2 < right2) {
      treeMap.put(left2, right2);
    }
  }
}
