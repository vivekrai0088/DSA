// https://leetcode.com/problems/invert-binary-tree/description/

public class InvertBinaryTree {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }
  public TreeNode invertTree(TreeNode root) {
    if(root == null) return null;

    //swap
    TreeNode leftChild = root.left;
    root.left = root.right;
    root.right = leftChild;

    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);

    return root;
  }
}
