/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
  class NodeInfo {
    private TreeNode node;
    private int position;

    NodeInfo(TreeNode node, int position) {
      this.node = node;
      this.position = position;
    }
  }

  public int widthOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<NodeInfo> queue = new LinkedList<>();
    queue.add(new NodeInfo(root, 0));

    int maxWidth = 0;

    while (!queue.isEmpty()) {
      NodeInfo head = queue.peek();
      NodeInfo tail = head;

      for (int i = queue.size(); i > 0; i--) {
        tail = queue.poll();

        if (tail.node.left != null) {
          queue.add(new NodeInfo(tail.node.left, 2 * tail.position));
        }

        if (tail.node.right != null) {
          queue.add(new NodeInfo(tail.node.right, 2 * tail.position + 1));
        }
      }

      maxWidth = Math.max(maxWidth, tail.position - head.position + 1);
    }

    return maxWidth;
  }
}
