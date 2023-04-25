import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// https://leetcode.com/problems/binary-tree-inorder-traversal/description/
public class IterativeInorderTraversal {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> ans = new ArrayList<>();

    while(root != null) {
      stack.push(root);
      root = root.left;
    }

    while(!stack.isEmpty()) {
      TreeNode node = stack.peek();
      stack.pop();
      ans.add(node.val);

      if(node.right != null) {
        node = node.right;
        while(node != null) {
          stack.push(node);
          node = node.left;
        }
      }
    }
    return ans;
  }
}
