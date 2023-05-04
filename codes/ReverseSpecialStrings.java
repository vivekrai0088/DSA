// asked in interview
public class ReverseSpecialStrings {
  private String reverseSpecial(String str) {
    String[] words = str.split(" ");

    for(int i = 0; i < words.length; i++) {
      if(words[i].length() >= 5) {
        words[i] = new StringBuilder(words[i]).reverse().toString();
      }
    }
    return String.join(" ", words);
  }

  public static void main(String[] args) {
    String str = "Vivek   is a good hire.";
    System.out.println(new ReverseSpecialStrings().reverseSpecial(str));
  }
}
