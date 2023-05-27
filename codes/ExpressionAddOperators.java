import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionAddOperators {
  public List<String> addOperators(String num, int target) {
    List<String> possibilities = new ArrayList<>();
    if(num == null || num.length() == 0) return possibilities;
    dfs(num, target, 0, new StringBuilder(), false, possibilities);
    return possibilities;
  }

  private void dfs(String num, long target, int pos, StringBuilder curPath, boolean canAddOperator, List<String> possibilities) {
    if(pos >= num.length()) {
      String possibility = curPath.toString();
      if(check(possibility, target)) {
        possibilities.add(possibility);
      }
      return;
    }

    curPath.append(num.charAt(pos));
    dfs(num, target, pos + 1, curPath, true, possibilities);
    curPath.deleteCharAt(curPath.length() - 1);
    if(canAddOperator) {
      for(char c : "+-*".toCharArray()) {
        curPath.append(c);
        dfs(num, target, pos, curPath, false, possibilities);
        curPath.deleteCharAt(curPath.length() - 1);
      }
    }
  }

  private boolean check(String expression, long target) {
    Stack<Long> stack = new Stack<>();
    int sz = expression.length();
    char sign = '+';
    StringBuilder num = new StringBuilder();

    for(int i = 0; i < sz; i++) {
      char ch = expression.charAt(i);
      if(Character.isDigit(ch)) {
        num.append(ch);
      }
      if(!Character.isDigit(ch) || i == sz - 1) {
        if(!valid(num)) return false;
        long value = Long.parseLong(num.toString());
        if(sign == '+') {
          stack.push(value);
        } else if(sign == '-') {
          stack.push(-value);
        } else if(sign == '*') {
          stack.push(stack.pop() * value);
        }
        sign = ch;
        num.setLength(0);
      }
    }
    long res = 0;
    while(!stack.isEmpty()) {
      res += stack.pop();
    }
    return (res == target);
  }

  private boolean valid(StringBuilder num) {
    if(num.length() == 0 || num == null) return false;
    if(num.length() == 1 && num.charAt(0) == '0') return true;
    if(num.charAt(0) == '0') return false;
    return true;
  }

}
