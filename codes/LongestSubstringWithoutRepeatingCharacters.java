import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> indexMap = new HashMap<>();

    int sz = s.length();

    int start = 0, end = 0;
    int ans = 0;
    while(end < sz) {
      if(indexMap.containsKey(s.charAt(end))) {
        start = Math.max(indexMap.get(s.charAt(end)) + 1, start);
        indexMap.put(s.charAt(end), end);
      } else {
        indexMap.put(s.charAt(end), end);
      }
      ans = Math.max(ans, end - start + 1);
      end++;
    }
    return ans;
  }
}
