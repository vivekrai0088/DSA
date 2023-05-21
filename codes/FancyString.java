// https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/
public class FancyString {
  private StringBuilder makeString(Character currentChar, int currentCount) {
    StringBuilder ans = new StringBuilder();
    for(int i = 0; i < currentCount; i++) {
      ans.append(currentChar);
    }
    return ans;
  }

  public String makeFancyString(String s) {
    int sz = s.length();
    if(sz == 1) return s;

    char[] sArray = s.toCharArray();
    Character prev = sArray[0];
    int freq = 1;
    StringBuilder ans = new StringBuilder();
    ans.append(sArray[0]);

    for(int i = 1; i < sz; i++) {
      if(sArray[i] == prev) {
        freq++;
      } else {
        prev = sArray[i];
        freq = 1;
      }
      if(freq < 3) {
        ans.append(sArray[i]);
      }
    }
    return ans.toString();
  }
}
