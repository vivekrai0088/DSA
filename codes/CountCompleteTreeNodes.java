import java.util.ArrayList;
import java.util.Collections;

// https://leetcode.com/problems/count-complete-tree-nodes/description/
public class CountCompleteTreeNodes {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }
  private int getHeight(TreeNode root) {
    if(root == null) return 0;
    int height = 0;
    while(root != null) {
      height++;
      root = root.left;
    }
    return height;
  }

  private ArrayList<Integer> findBinary(int number) {
    ArrayList<Integer> binary = new ArrayList<Integer>();
    while(number != 0) {
      int rem = number % 2;
      number = number / 2;
      binary.add(rem);
    }
    Collections.reverse(binary);
    return binary;
  }

  private boolean existsNode(TreeNode root, ArrayList<Integer> binary, int index) {
    for(int i = 1; i < binary.size(); i++) {
      if(binary.get(i) == 1) {
        root = root.right;
      } else {
        root = root.left;
      }
      if(root == null) return false;
    }
    return true;
  }

  public int countNodes(TreeNode root) {
    if(root == null) return 0;
    int low = 1, high = (int) Math.pow(2, getHeight(root));
    int res = 0;
    while(low <= high) {
      int mid = low + (high - low) / 2;
      ArrayList<Integer> binary = findBinary(mid);
      if(existsNode(root, binary, 0)) {
        res = mid;
        System.out.println("res = " + res);
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return res;
  }
}
