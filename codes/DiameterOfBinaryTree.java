// https://leetcode.com/problems/diameter-of-binary-tree/description/
public class DiameterOfBinaryTree {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }

  int diameter = 0;

  private int solve(TreeNode root) {
    if(root == null) return 0;

    int leftMaxHeight = solve(root.left);
    int rightMaxHeight = solve(root.right);

    diameter = Math.max(diameter, 1 + leftMaxHeight + rightMaxHeight);
    return 1 + Math.max(leftMaxHeight, rightMaxHeight);
  }

  public int diameterOfBinaryTree(TreeNode root) {
    solve(root);
    return diameter - 1;
  }
}
