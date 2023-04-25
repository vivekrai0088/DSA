// https://leetcode.com/problems/validate-binary-search-tree/description/
public class ValidateBinarySearchData {

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }

  private boolean isValidBSTHelper(TreeNode root, Long lowerLimit, Long upperLimit) {
    if(root == null) return true;

    return (root.val > lowerLimit && root.val < upperLimit) &&
            isValidBSTHelper(root.left, lowerLimit, Long.valueOf(root.val)) &&
            isValidBSTHelper(root.right, Long.valueOf(root.val), upperLimit);
  }

  public boolean isValidBST(TreeNode root) {
    return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
}
