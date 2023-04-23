import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/design-hashmap/description/
public class DesignHashMap {
  List<List<int[]>> lists = new ArrayList<List<int[]>>();
  int capacity = 1000006;

  public DesignHashMap() {
    lists = new ArrayList<>(capacity);
    for(int i = 0; i < capacity; i++) {
      lists.add(new ArrayList<int[]>());
    }
  }

  public void put(int key, int value) {
    int hashCode = getHashCode(key);
    int keyFound = 0;
    for(int i = 0; i < lists.get(hashCode).size(); i++) {
      if(lists.get(hashCode).get(i)[0] == key) {
        lists.get(hashCode).get(i)[1] = value;
        keyFound = 1;
        break;
      }
    }
    if(keyFound == 0) {
      int[] entry = new int[2];
      entry[0] = key;
      entry[1] = value;
      lists.get(hashCode).add(entry);
    }
  }

  public int get(int key) {
    int hashCode = getHashCode(key);
    for(int i = 0; i < lists.get(hashCode).size(); i++) {
      if(lists.get(hashCode).get(i)[0] == key) {
        return lists.get(hashCode).get(i)[1];
      }
    }
    return -1;
  }

  public void remove(int key) {
    int hashCode = getHashCode(key);
    for(int i = 0; i < lists.get(hashCode).size(); i++) {
      if(lists.get(hashCode).get(i)[0] == key) {
        lists.get(hashCode).remove(i);
        break;
      }
    }
  }

  private int getHashCode(int key) {
    return key % capacity;
  }
}
