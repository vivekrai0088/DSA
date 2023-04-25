// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

public class BinaryTreeMaximumPathSum {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }

  int ans = Integer.MIN_VALUE;

  private int maxPathSumHelper(TreeNode root) {
    if(root == null) return 0;

    int leftPathSum = maxPathSumHelper(root.left);
    int rightPathSum = maxPathSumHelper(root.right);

    int maxPath = root.val;
    maxPath = Math.max(maxPath, maxPath + leftPathSum);
    maxPath = Math.max(maxPath, maxPath + rightPathSum);

    ans = Math.max(ans, maxPath);
    return Math.max(root.val, root.val + Math.max(leftPathSum, rightPathSum));
  }

  public int maxPathSum(TreeNode root) {
    ans = root.val;
    maxPathSumHelper(root);
    return ans;
  }

}
