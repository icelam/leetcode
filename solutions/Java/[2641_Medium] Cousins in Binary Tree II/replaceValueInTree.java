class Solution {
  public TreeNode replaceValueInTree(TreeNode root) {
    if (root == null) {
      return root;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int previousSum = root.val;

    while (!queue.isEmpty()) {
      int batchSize = queue.size();
      int sum = 0;

      for (int i = 0; i < batchSize; i++) {
        TreeNode node = queue.remove();
        node.val = previousSum - node.val;

        int siblingSum = 0;

        if (node.left != null) {
          siblingSum += node.left.val;
        }

        if (node.right != null) {
          siblingSum += node.right.val;
        }

        if (node.left != null) {
          sum += node.left.val;
          node.left.val = siblingSum;
          queue.add(node.left);
        }

        if (node.right != null) {
          sum += node.right.val;
          node.right.val = siblingSum;
          queue.add(node.right);
        }
      }

      previousSum = sum;
    }

    return root;
  }
}
