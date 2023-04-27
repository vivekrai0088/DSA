// https://leetcode.com/problems/climbing-stairs/description/
public class ClimbingStairs {
  public int climbStairs(int n) {
    if(n == 1) return 1;
    if(n == 2) return 2;

    int lastElement = 2;
    int secondlastElement = 1;

    int result = 0;
    for(int i = 3; i <= n; i++) {
      result = lastElement + secondlastElement;
      secondlastElement = lastElement;
      lastElement = result;
    }
    return result;
  }
}
