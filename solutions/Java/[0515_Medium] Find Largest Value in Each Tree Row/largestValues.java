class Solution {
  public List<Integer> largestValues(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int max = Integer.MIN_VALUE;
      int batchSize = queue.size();

      for (int i = 0; i < batchSize; i++) {
        TreeNode current = queue.remove();

        max = Math.max(max, current.val);

        if (current.left != null) {
          queue.add(current.left);
        }

        if (current.right != null) {
          queue.add(current.right);
        }
      }

      result.add(max);
    }

    return result;
  }
}
