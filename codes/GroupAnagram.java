import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
  public List<List<String>> groupAnagrams(String[] strs) {
    int sz = strs.length;

    Map<String, ArrayList<String>> anagramGroups = new HashMap<>();
    for(int i = 0; i < sz; i++) {
      String str = strs[i];
      char[] strCharArray = str.toCharArray();
      Arrays.sort(strCharArray);
      String sortedStr = new String(strCharArray);

      ArrayList<String> anagrams;
      if(anagramGroups.containsKey(sortedStr)) {
        anagrams = anagramGroups.get(sortedStr);
      } else {
        anagrams = new ArrayList<>();
      }
      anagrams.add(str);
      anagramGroups.put(sortedStr, anagrams);
    }

    return new ArrayList<>(anagramGroups.values());
  }
}
