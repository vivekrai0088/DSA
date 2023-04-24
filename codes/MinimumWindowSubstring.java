import java.util.HashMap;
import java.util.Map;
// https://leetcode.com/problems/minimum-window-substring/description/
public class MinimumWindowSubstring {
  public String minWindow(String s, String t) {
    int tsize = t.length();
    int ssize = s.length();

    Map<Character, Integer> freqMap = new HashMap<>();

    for(int i = 0; i < tsize; i++) {
      freqMap.put(t.charAt(i), freqMap.getOrDefault(t.charAt(i), 0) + 1);
    }
    int counter = freqMap.size();
    int start = 0;
    int end = 0;

    int i = 0, j = 0;
    int minimumWindow = Integer.MAX_VALUE;

    while(end < ssize) {
      if(freqMap.containsKey(s.charAt(end))) {
        freqMap.put(s.charAt(end), freqMap.getOrDefault(s.charAt(end), 0) - 1);
        if(freqMap.get(s.charAt(end)) == 0){
          counter--;
        }
      }
      while(counter == 0) {
        int currentWindowSize = end - start + 1;
        if(minimumWindow > currentWindowSize) {
          minimumWindow = currentWindowSize;
          i = start;
          j = end;
        }
        if(freqMap.containsKey(s.charAt(start))) {
          freqMap.put(s.charAt(start), freqMap.getOrDefault(s.charAt(start), 0) + 1);
          if(freqMap.get(s.charAt(start)) == 1){
            counter++;
          }
        }
        start++;
      }
      end++;
    }
    if(minimumWindow == Integer.MAX_VALUE) return "";
    return s.substring(i, j + 1);
  }
}
