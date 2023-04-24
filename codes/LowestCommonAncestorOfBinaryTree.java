public class LowestCommonAncestorOfBinaryTree {
  class TreeNode {
    int val;
    BinaryTreeMaximumPathSum.TreeNode left;
    BinaryTreeMaximumPathSum.TreeNode right;
  }
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null || root == p || root == q) return root;

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if(left != null && right != null) return root;
    if(left != null) return left;
    return right;
  }
}
