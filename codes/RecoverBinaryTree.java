// https://leetcode.com/problems/recover-binary-search-tree/description/
public class RecoverBinaryTree {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }

  TreeNode first;
  TreeNode second;
  TreeNode third;
  TreeNode prev;

  private void swapData(TreeNode first, TreeNode second) {
    int temp = first.val;
    first.val = second.val;
    second.val = temp;
  }

  private void recoverTreeHelper(TreeNode root) {
    if(root == null) return;

    recoverTreeHelper(root.left);

    if(prev != null && prev.val > root.val) {
      if(first == null && second == null) {
        first = prev;
        second = root;
      } else {
        third = root;
      }
    }
    prev = root;

    recoverTreeHelper(root.right);
  }

  public void recoverTree(TreeNode root) {
    first = null;
    second = null;
    third = null;
    prev = null;

    recoverTreeHelper(root);

    if(third == null) {
      swapData(first, second);
    } else {
      swapData(first, third);
    }
  }
}
