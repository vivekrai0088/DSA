import java.util.Stack;

public class LargestRectangleInHistogram {
  public int largestRectangleArea(int[] heights) {
    int sz = heights.length;
    int[] leftNearestSmallerIndex = new int[sz];
    int[] rightNearestSmallerIndex = new int[sz];

    leftNearestSmallerIndex[0] = -1;
    // compute left nearest smaller element index
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    for(int i = 1; i < sz; i++) {
      int element = heights[i];
      while(stack.size() > 0 && heights[stack.peek()] >= element) {
        stack.pop();
      }
      if(stack.size() == 0) {
        leftNearestSmallerIndex[i] = -1;
      } else {
        leftNearestSmallerIndex[i] = stack.peek();
      }
      stack.push(i);
    }

    // compute right nearest smaller element index
    stack.clear();
    stack.push(sz - 1);
    rightNearestSmallerIndex[sz - 1] = sz;
    for(int i = sz - 2; i >= 0; i--) {
      int element = heights[i];
      while(stack.size() > 0 && heights[stack.peek()] >= element) {
        stack.pop();
      }
      if(stack.size() == 0) {
        rightNearestSmallerIndex[i] = sz;
      } else {
        rightNearestSmallerIndex[i] = stack.peek();
      }
      stack.push(i);
    }

    int maxArea = 0;
    for(int i = 0; i < sz; i++) {
      maxArea = Math.max(maxArea, (rightNearestSmallerIndex[i]-leftNearestSmallerIndex[i]-1)*heights[i]);
    }
    return maxArea;
  }
}
