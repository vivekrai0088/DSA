public class MaxArea {
  public int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
    int maxArea = 0;
    while(left < right) {
      int width = right - left;
      int heightt = Math.min(height[left], height[right]);
      int area = heightt * width;

      maxArea = Math.max(maxArea, area);
      if(height[left] < height[right]) {
        left++;
      } else if(height[left] > height[right]) {
        right--;
      } else {
        left++;
        right--;
      }
    }
    return maxArea;
  }

  public static void main(String[] args) {
    int[] heights = {1,8,6,2,5,4,8,3,7};
    System.out.println(new MaxArea().maxArea(heights));
  }
}
