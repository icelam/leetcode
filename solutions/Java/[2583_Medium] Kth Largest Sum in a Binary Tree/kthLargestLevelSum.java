class Solution {
  public long kthLargestLevelSum(TreeNode root, int k) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    List<Long> sums = new ArrayList<>();

    while (!queue.isEmpty()) {
      int batchSize = queue.size();
      long levelSum = 0;

      for (int i = 0; i < batchSize; i++) {
        TreeNode current = queue.remove();
        levelSum += current.val;

        if (current.left != null) {
          queue.add(current.left);
        }

        if (current.right != null) {
          queue.add(current.right);
        }
      }

      sums.add(levelSum);
    }

    if (sums.size() < k) {
      return -1;
    }

    sums.sort(Comparator.reverseOrder());

    return sums.get(k - 1);
  }
}
