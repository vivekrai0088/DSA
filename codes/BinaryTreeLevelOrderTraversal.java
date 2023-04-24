import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

https://leetcode.com/problems/binary-tree-level-order-traversal/description/

public class BinaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(TreeNode root) {
    if(root == null) return new ArrayList<>(Arrays.asList());
    Queue<TreeNode> queue = new ArrayDeque<>();

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    queue.add(root);
    while(queue.size() > 0) {
      List<Integer> level = new ArrayList<>();
      int sz = queue.size();
      for(int i = 0; i < sz; i++) {
        TreeNode node = queue.poll();
        level.add(node.val);
        if(node.left != null) {
          queue.add(node.left);
        }
        if(node.right != null) {
          queue.add(node.right);
        }
      }
      result.add(level);
    }
    return result;
  }
}
