import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// https://leetcode.com/problems/longest-string-chain/description/
public class LongestStrChain {
  public int longestStrChain(String[] words) {
    Arrays.sort(words, (a, b) -> a.length() - b.length());

    Map<String, Integer> map = new HashMap<>();

    int ans = 0;
    for(String word : words) {
      int best = 0;
      for(int i = 0; i < word.length(); i++) {
        String prev = word.substring(0, i) + word.substring(i + 1);
        best = Math.max(best, map.getOrDefault(prev, 0) + 1);
      }
      map.put(word, best);
      ans = Math.max(ans, best);
    }
    return ans;
  }
}
