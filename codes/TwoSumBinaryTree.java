import java.util.Stack;

// https://www.interviewbit.com/problems/2sum-binary-tree/
public class TwoSumBinaryTree {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }
  Stack<TreeNode> minStack;
  Stack<TreeNode> maxStack;

  private void initializeStacks(TreeNode A) {
    minStack = new Stack<>();
    maxStack = new Stack<>();
    TreeNode root = A;
    while(root != null) {
      minStack.push(root);
      root = root.left;
    }

    root = A;
    while(root != null) {
      maxStack.push(root);
      root = root.right;
    }
  }

  private int minStackElement() {
    if(minStack.size() == 0) return -1;
    return minStack.peek().val;
  }

  private int maxStackElement() {
    if(maxStack.size() == 0) return -1;
    return maxStack.peek().val;
  }

  private void incrementMinStack() {
    if(minStack.size() == 0) return;
    TreeNode node = minStack.peek();
    minStack.pop();

    if(node.right != null) {
      node = node.right;
      while(node != null) {
        minStack.push(node);
        node = node.left;
      }
    }
  }

  private void decrementMaxStack() {
    if(maxStack.size() == 0) return;
    TreeNode node = maxStack.peek();
    maxStack.pop();

    if(node.left != null) {
      node = node.left;
      while(node != null) {
        maxStack.push(node);
        node = node.right;
      }
    }
  }

  public int t2Sum(TreeNode A, int B) {
    initializeStacks(A);

    while(minStackElement() != -1 && maxStackElement() != -1 && minStackElement() < maxStackElement()) {
      if(minStackElement() + maxStackElement() == B) {
        return 1;
      } else if(minStackElement() + maxStackElement() < B) {
        incrementMinStack();
      } else {
        decrementMaxStack();
      }
    }
    return 0;
  }
}
