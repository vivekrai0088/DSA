import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PostOrderTraversal {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }
  public List<Integer> postorderTraversal(TreeNode root) {
    Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
    LinkedList<Integer> result = new LinkedList<>();

    TreeNode temp = root;

    while(!stack.isEmpty() || temp != null) {
      if(temp != null) {
        stack.push(temp);
        result.addFirst(temp.val);
        temp = temp.right;
      } else {
        TreeNode node = stack.peek();
        stack.pop();
        temp = node.left;
      }
    }
    return result;
  }
}
