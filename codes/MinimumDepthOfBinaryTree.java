public class MinimumDepthOfBinaryTree {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }
  private int minDepth;

  private void minDepthHelper(TreeNode root, int depth) {
    if(root == null) return;
    if(root.left == null && root.right == null) {
      minDepth = Math.min(minDepth, depth);
      return;
    }
    minDepthHelper(root.left, depth + 1);
    minDepthHelper(root.right, depth + 1);
  }

  public int minDepth(TreeNode root) {
    if(root == null) return 0;
    minDepth = Integer.MAX_VALUE;
    minDepthHelper(root, 1);
    return minDepth;
  }
}
