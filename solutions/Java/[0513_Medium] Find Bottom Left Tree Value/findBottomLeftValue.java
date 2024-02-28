class Solution {
  public int findBottomLeftValue(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    int bottomLeftNode = root.val;

    while (!queue.isEmpty()) {
      int batchSize = queue.size();
      bottomLeftNode = queue.peek().val;

      for (int i = 0; i < batchSize; i++) {
        TreeNode currentNode = queue.remove();

        if (currentNode.left != null) {
          queue.add(currentNode.left);
        }

        if (currentNode.right != null) {
          queue.add(currentNode.right);
        }
      }
    }

    return bottomLeftNode;
  }
}
