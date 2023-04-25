// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
public class KthSmallestElementInBST {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }

  int count = 0;
  int ans = 0;

  public void inorder(TreeNode root,int k){
    if(root == null) return;

    inorder(root.left, k);
    count++;
    if(count == k){
      ans = root.val;
      return;
    }
    inorder(root.right, k);
  }

  public int kthSmallest(TreeNode root, int k) {
    inorder(root,k);
    return ans;
  }
}
