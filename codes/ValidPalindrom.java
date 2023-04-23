// https://leetcode.com/problems/valid-palindrome/description/
public class ValidPalindrom {
  public boolean isPalindrome(String s) {
    int sz = s.length();
    int i = 0, j = sz - 1;

    while(i < j) {
      char left = s.charAt(i);
      char right = s.charAt(j);

      if(!Character.isLetterOrDigit(left)) {
        i++;
      } else if(!Character.isLetterOrDigit(right)) {
        j--;
      } else {
        if(Character.toLowerCase(left) != Character.toLowerCase(right)) return false;
        i++;
        j--;
      }
    }
    return true;
  }
}
