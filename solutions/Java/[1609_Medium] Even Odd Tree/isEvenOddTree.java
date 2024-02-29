class Solution {
  public boolean isEvenOddTree(TreeNode root) {
    int currentLevel = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int batchSize = queue.size();
      int previousValue = currentLevel % 2 == 0
        ? Integer.MIN_VALUE
        : Integer.MAX_VALUE;
      boolean isEvenIndexLevel = currentLevel % 2 == 0;

      for (int i = 0; i < batchSize; i++) {
        TreeNode currentNode = queue.remove();
        int currentValue = currentNode.val;
        boolean isEvenValue = currentValue % 2 == 0;

        if (
          // Even-indexed level: odd integer values in strictly increasing order
          (isEvenIndexLevel && (isEvenValue || previousValue >= currentValue))
          // Odd-indexed level: even integer values in strictly decreasing order
          || (!isEvenIndexLevel && (!isEvenValue || previousValue <= currentValue))
        ) {
          return false;
        }

        if (currentNode.left != null) {
          queue.add(currentNode.left);
        }

        if (currentNode.right != null) {
          queue.add(currentNode.right);
        }

        previousValue = currentNode.val;
      }

      currentLevel++;
    }

    return true;
  }
}
