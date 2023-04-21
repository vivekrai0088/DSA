// https://leetcode.com/problems/permutation-in-string/description/
public class PermutationInString {
  int[] s1Hash = new int[26];
  int[] s2SubHash = new int[26];

  private boolean isEqual() {
    for(int i = 0; i < 26; i++) {
      if(s1Hash[i] != s2SubHash[i]) return false;
    }
    return true;
  }

  public boolean checkInclusion(String s1, String s2) {

    if(s1.length() > s2.length()) {
      return false;
    }

    for(int i = 0; i < s1.length(); i++) {
      s1Hash[s1.charAt(i) - 'a']++;
    }

    for(int i = 0; i < s1.length(); i++) {
      s2SubHash[s2.charAt(i) - 'a']++;
    }

    for(int i = 0, j = s1.length() - 1; i < s2.length() - s1.length() + 1; i++, j++) {
      if(isEqual()) return true;
      s2SubHash[s2.charAt(i) - 'a']--;
      if(j + 1 < s2.length()) {
        s2SubHash[s2.charAt(j + 1) - 'a']++;
      }
    }

    return false;
  }
}
