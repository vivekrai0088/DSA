import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-paths/description/

public class BinaryTreePaths {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }

  List<String> result;

  private void binaryTreePathsHelper(TreeNode root, String currentPath) {
    if(root == null) {
      return;
    }
    if(root.left == null && root.right == null) {
      currentPath += String.valueOf(root.val);
      result.add(currentPath);
      return;
    }
    binaryTreePathsHelper(root.left, currentPath + String.valueOf(root.val) + "->");
    binaryTreePathsHelper(root.right, currentPath + String.valueOf(root.val) + "->");
  }

  public List<String> binaryTreePaths(TreeNode root) {
    result = new ArrayList<>();
    binaryTreePathsHelper(root, "");
    return result;
  }
}
