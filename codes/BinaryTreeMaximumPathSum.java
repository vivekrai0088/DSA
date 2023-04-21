//import javax.swing.tree.TreeNode;
//
//// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
//public class BinaryTreeMaximumPathSum {
//  private int maxi = 0;
//  private int maxPathSumUtil(TreeNode root) {
//    if(root == null) return 0;
//    int leftChildMaxPathSum = Math.max(0, maxPathSumUtil(root.left));
//    int rightChildMaxPathSum = Math.max(0, maxPathSumUtil(root.right));
//
//    maxi = Math.max(maxi, leftChildMaxPathSum + root.val + rightChildMaxPathSum);
//    return leftChildMaxPathSum + root.val + rightChildMaxPathSum;
//  }
//
//  public int maxPathSum(TreeNode root) {
//    int pseudo = maxPathSumUtil(root);
//    return maxi;
//  }
//}
