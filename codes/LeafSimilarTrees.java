import java.util.ArrayList;

// https://leetcode.com/problems/leaf-similar-trees/description/
public class LeafSimilarTrees {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }
  private void rec(TreeNode root, ArrayList<Integer> leafSequence) {
    if(root == null) return;
    if(root.left == null && root.right == null) {
      leafSequence.add(root.val);
      return;
    }
    rec(root.left, leafSequence);
    rec(root.right, leafSequence);
  }

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    ArrayList<Integer> firstLeafSequence = new ArrayList<>();
    ArrayList<Integer> secondLeafSequence = new ArrayList<>();

    rec(root1, firstLeafSequence);
    rec(root2, secondLeafSequence);

    if(firstLeafSequence.size() != secondLeafSequence.size()) {
      return false;
    }

    for(int i = 0; i < firstLeafSequence.size(); i++) {
      if(!firstLeafSequence.get(i).equals(secondLeafSequence.get(i))) {
        return false;
      }
    }
    return true;
  }
}
