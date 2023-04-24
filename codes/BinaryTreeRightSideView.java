import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/binary-tree-right-side-view/description/

public class BinaryTreeRightSideView {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }
  List<Integer> rightSide;
  int maxlevel;

  private void rightSideViewHelper(TreeNode root, int level) {
    if(root == null) return;
    if(maxlevel < level) {
      maxlevel = level;
      rightSide.add(root.val);
    }
    rightSideViewHelper(root.right, level + 1);
    rightSideViewHelper(root.left, level + 1);
  }

  public List<Integer> rightSideView(TreeNode root) {
    rightSide = new ArrayList<>();
    maxlevel = -1;
    rightSideViewHelper(root, 0);
    return rightSide;
  }
}
