import java.util.Stack;

public class RemoveKDigits {
  public String removeKdigits(String num, int k) {
    if(k == num.length()) return "0";
    char[] numArray = num.toCharArray();
    Stack<Character> stack = new Stack<>();

    for(int i = 0; i < numArray.length; i++) {
      while(!stack.isEmpty() && k > 0 && stack.peek() > numArray[i]) {
        stack.pop();
        k--;
      }
      if(numArray[i] != '0' || !stack.isEmpty()) {
        stack.push(numArray[i]);
      }
    }

    while(!stack.isEmpty() && k > 0) {
      stack.pop();
      k--;
    }

    if(stack.isEmpty())
      return "0";

    StringBuilder ans = new StringBuilder();
    while(!stack.isEmpty()) {
      ans.append(stack.peek());
      stack.pop();
    }
    ans.reverse();
    return ans.toString();
  }
}
