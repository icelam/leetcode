class Solution {
  private int getMinSwap(int[] values) {
    int n = values.length;
    int operations = 0;
    int[] sortedValues = new int[n];

    for (int i = 0; i < n; i++) {
      sortedValues[i] = values[i];
    }

    Arrays.sort(sortedValues);

    HashMap<Integer, Integer> positions = new HashMap<>();
    for (int i = 0; i < n; i++) {
      positions.put(values[i], i);
    }

    for (int i = 0; i < n; i++) {
      if (values[i] != sortedValues[i]) {
        operations++;

        int newPosition = positions.get(sortedValues[i]);
        positions.put(values[i], newPosition);
        values[newPosition] = values[i];
      }
    }

    return operations;
  }

  public int minimumOperations(TreeNode root) {
    int result = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int batchSize = queue.size();
      int[] levelValues = new int[batchSize];

      for (int i = 0; i < batchSize; i++) {
        TreeNode currentNode = queue.remove();
        levelValues[i] = currentNode.val;

        if (currentNode.left != null) {
          queue.add(currentNode.left);
        }

        if (currentNode.right != null) {
          queue.add(currentNode.right);
        }
      }

      result += getMinSwap(levelValues);
    }

    return result;
  }
}
