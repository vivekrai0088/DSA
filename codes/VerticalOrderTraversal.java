import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

public class VerticalOrderTraversal {

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }

  class QueueNode {
    TreeNode treeNode;
    int level; // row
    int vertical; // col

    public QueueNode(TreeNode treeNode, int level, int vertical) {
      this.treeNode = treeNode;
      this.level = level;
      this.vertical = vertical;
    }
  }

  TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> verticalOrderMap;

  private void verticaleTraversalHelper(TreeNode root) {
    Queue<QueueNode> queue = new ArrayDeque<>();
    queue.add(new QueueNode(root, 0, 0));

    while(queue.size() > 0) {
      QueueNode queueNode = queue.poll();
      TreeNode treeNode = queueNode.treeNode;
      int level = queueNode.level;
      int vertical = queueNode.vertical;

      if(!verticalOrderMap.containsKey(vertical)) {
        verticalOrderMap.put(vertical, new TreeMap<Integer, PriorityQueue<Integer>>());
      }
      TreeMap<Integer, PriorityQueue<Integer>> verticalMap = verticalOrderMap.get(vertical);
      if(!verticalMap.containsKey(level)) {
        verticalMap.put(level, new PriorityQueue<>());
      }
      verticalOrderMap.get(vertical).get(level).add(treeNode.val);

      if(treeNode.left != null) {
        queue.add(new QueueNode(treeNode.left, level + 1, vertical - 1));
      }
      if(treeNode.right != null) {
        queue.add(new QueueNode(treeNode.right, level + 1, vertical + 1));
      }
    }
  }

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    verticalOrderMap = new TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>>();
    verticaleTraversalHelper(root);

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    for(TreeMap<Integer, PriorityQueue<Integer>> verticalLevels : verticalOrderMap.values()) {
      List<Integer> temp = new ArrayList<>();

      for(PriorityQueue<Integer> pq : verticalLevels.values()) {
        while(pq.size() > 0) {
          temp.add(pq.poll());
        }
      }

      result.add(temp);
    }
    return result;
  }
}
