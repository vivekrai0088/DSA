public class MultiplyStrings {
  private String multipleWithDigit(String num1, int digit, int zeroCount) {
    int carry = 0;
    StringBuilder ans = new StringBuilder();
    while(zeroCount-- > 0) {
      ans.append('0');
    }
    for(int i = num1.length() - 1; i >= 0; i--) {
      int temp = ((int)(num1.charAt(i) - '0') * digit) + carry;
      ans.append((char)(temp % 10 + '0'));
      carry = temp / 10;
    }
    if(carry != 0) {
      ans.append((char)(carry + '0'));
    }
    return ans.toString();
  }

  private String addStrings(String row1, String row2) {
    StringBuilder ans = new StringBuilder();
    int n = row1.length();
    int m = row2.length();

    int i = 0, j = 0;
    int carry = 0;
    while(i < n || j < m) {
      int temp = 0;
      if(i < n) {
        temp = (row1.charAt(i) - '0');
      }
      if(j < m) {
        temp += (row2.charAt(j) - '0');
      }
      temp += carry;
      ans.append((char)((temp % 10) + '0'));
      carry = temp / 10;
      i++;
      j++;
    }

    if(carry != 0) {
      ans.append((char)(carry + '0'));
    }
    return ans.toString();
  }

  public String multiply(String num1, String num2) {
    int n = num1.length();
    int m = num2.length();

    int zeroCount = 0;
    String prevRow = multipleWithDigit(num1, num2.charAt(m - 1) - '0', zeroCount);
    zeroCount = 1;
    for(int i = m - 2; i >= 0; i--) {
      int digit = num2.charAt(i) - '0';
      String currentRow = multipleWithDigit(num1, digit, zeroCount);
      String addResult = addStrings(prevRow, currentRow);
      prevRow = addResult;
      zeroCount++;
    }
    StringBuilder ans = new StringBuilder(prevRow);
    ans.reverse();

    int i = 0;
    while(i < ans.length() && ans.charAt(i) == '0') i++;
    if(i == ans.length()) return "0";
    return ans.substring(i, ans.length());
  }
}
