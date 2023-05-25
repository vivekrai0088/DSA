public class AgodaQuestion2 {

//  Q2: Write a function that takes a sentence and reverse only alphanumeric word but other characters remain unchanged.
//  For Example -
//
//          **Input:**This is test!!!
//  Output: sihT si tset!!!
//
//  Input: Hello, Bangkok:)
//  Output: olleH, kokgnaB:)
//
//  Input: Hurray! Easy Questions
//  Output: yarruH! ysaE snoitseuQ
//
//  Input: Bangkok12:)Has
//  Output: 21kokgnaB:)saH
//
//  Input: Bangkok
//  Output: kokgnaB

  private void reverse(StringBuilder stringBuilder, int i, int j) {
    System.out.println("i = " + i + " j = " + j);
    while(i < j) {
      char temp = stringBuilder.charAt(i);
      stringBuilder.setCharAt(i, stringBuilder.charAt(j));
      stringBuilder.setCharAt(j, temp);
      i++;
      j--;
    }
  }

  private String run() {
    String str = "This is test!!!";

    StringBuilder stringBuilder = new StringBuilder(str);
    int sz = stringBuilder.length();
    int i = 0;
    while (i < sz && !Character.isLetterOrDigit(stringBuilder.charAt(i))) {
      i++;
    }

    if (i == sz) {
      return str;
    }

    int j = i;
    // "This is test!!!";
    while (j < sz && i <= j) {
      System.out.println("char = " + stringBuilder.charAt(j));
      if (Character.isLetterOrDigit(stringBuilder.charAt(j))) {
        j++;
      } else {
        reverse(stringBuilder, i, j - 1);

        i = j;
        while (i < sz && j < sz && !Character.isLetterOrDigit(stringBuilder.charAt(i))) {
          i++;
          j++;
        }
      }
    }
    if(Character.isLetterOrDigit(stringBuilder.charAt(stringBuilder.length() - 1))) {
      reverse(stringBuilder, i, j - 1);
    }
    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    System.out.println(new AgodaQuestion2().run());
  }
}
