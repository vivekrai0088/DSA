// https://leetcode.com/problems/path-sum-iii/description/
// Brute force:
public class PathSumIII {
//  int count = 0;
//  public int pathSum(TreeNode root, int targetSum) {
//    if(root == null) return 0;
//    dfs(root, targetSum);
//    pathSum(root.left, targetSum);
//    pathSum(root.right, targetSum);
//    return count;
//  }
//
//  private void dfs(TreeNode root, int targetSum) {
//    if(root == null) return;
//    if(root.val == targetSum) {
//      count += 1;
//    }
//    dfs(root.left, targetSum - root.val);
//    dfs(root.right, targetSum - root.val);
//  }
}
