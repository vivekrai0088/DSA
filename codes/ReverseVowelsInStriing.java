// https://leetcode.com/problems/reverse-vowels-of-a-string/description/
public class ReverseVowelsInStriing {
  private boolean isVowel(char ch) {
    if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
      return true;
    }
    return false;
  }

  public String reverseVowels(String s) {
    int sz = s.length();
    int i = 0, j = sz - 1;
    char[] charArray = s.toCharArray();

    while(i < j) {

      while(i < sz && !isVowel(Character.toLowerCase(charArray[i]))) {
        i++;
      }
      while(j >= 0 && !isVowel(Character.toLowerCase(charArray[j]))) {
        j--;
      }
      if(i < j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        i++;
        j--;
      }
    }
    return new String(charArray);
  }
}
