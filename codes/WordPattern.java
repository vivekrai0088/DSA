import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/word-pattern/description/
public class WordPattern {
  public boolean wordPattern(String pattern, String s) {
    Map<Character, String> map = new HashMap<>();

    String[] words = s.split(" ");
    char[] alpha = pattern.toCharArray();
    if(words.length != alpha.length) return false;

    for(int i = 0; i < alpha.length; i++) {
      if(map.containsKey(alpha[i])) {
        if(!map.get(alpha[i]).equals(words[i])) return false;
      } else {
        if(map.containsValue(words[i])) return false;
        map.put(alpha[i], words[i]);
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new WordPattern().wordPattern("abba", "dog cat cat dog"));
  }
}
