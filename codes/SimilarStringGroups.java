import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/similar-string-groups/description/
public class SimilarStringGroups {
  Set<String> set;

  public boolean helper(String s,String t){
    int res = 0, i = 0;
    while(res <= 2 && i < s.length()){
      if(s.charAt(i) != t.charAt(i)) res++;
      i++;
    }
    return res == 2;
  }

  private void dfs(String[] strs, String str) {
    set.remove(str);

    for(int i = 0; i < strs.length; i++) {
      if(helper(str, strs[i])) {
        if(set.contains(strs[i])) {
          dfs(strs, strs[i]);
        }
      }
    }
  }

  public int numSimilarGroups(String[] strs) {
    int sz = strs.length;
    set = new HashSet<>();
    for(int i = 0; i < sz; i++) {
      set.add(strs[i]);
    }

    int ans = 0;

    for(int i = 0; i < sz; i++) {
      if(set.contains(strs[i])) {
        ans++;
        dfs(strs, strs[i]);
      }
    }
    return ans;
  }
}
