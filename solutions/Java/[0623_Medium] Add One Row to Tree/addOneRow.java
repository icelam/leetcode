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
  public TreeNode addOneRow(TreeNode root, int val, int depth) {
    if (depth == 1) {
      return new TreeNode(val, root, null);
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int currentDepth = 1;

    while (currentDepth < depth - 1) {
      int batchSize = queue.size();

      for (int i = 0; i < batchSize; i++) {
        TreeNode currentNode = queue.remove();

        if (currentNode.left != null) {
          queue.add(currentNode.left);
        }

        if (currentNode.right != null) {
          queue.add(currentNode.right);
        }
      }

      currentDepth++;
    }

    while (queue.size() != 0) {
      TreeNode targetLevelNode = queue.remove();

      TreeNode newLeftNode = new TreeNode(val, targetLevelNode.left, null);
      TreeNode newRightNode = new TreeNode(val, null, targetLevelNode.right);

      targetLevelNode.left = newLeftNode;
      targetLevelNode.right = newRightNode;
    }

    return root;
  }
}
