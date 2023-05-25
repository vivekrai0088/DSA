import java.util.Stack;

// https://leetcode.com/problems/basic-calculator-ii/
public class BasicCalculatorII {
  public int calculate(String s) {
    int sz = s.length();
    if(s == null || sz == 0) return 0;
    Stack<Integer> stack = new Stack<Integer>();
    int num = 0;
    char sign = '+';
    for(int i = 0; i < sz; i++) {
      if(Character.isDigit(s.charAt(i))) {
        num = num * 10 + (s.charAt(i) - '0');
      }
      if((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == sz - 1) {
        if(sign == '-') {
          stack.push(-num);
        }
        if(sign == '+') {
          stack.push(num);
        }
        if(sign == '*') {
          stack.push(stack.pop() * num);
        }
        if(sign == '/') {
          stack.push(stack.pop() / num);
        }
        sign = s.charAt(i);
        num = 0;
      }
    }
    int res = 0;
    for(int i : stack) {
      res += i;
    }
    return res;
  }
}
