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
  private List<int[]> nodeInfo;

  private void dfs(TreeNode root, int row, int column) {
    if (root == null) {
      return;
    }

    nodeInfo.add(new int[] {root.val, row, column});

    if (root.left != null) {
      dfs(root.left, row + 1, column - 1);
    }

    if (root.right != null) {
      dfs(root.right, row + 1, column + 1);
    }
  }

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    nodeInfo = new ArrayList<>();
    dfs(root, 0, 0);

    Collections.sort(nodeInfo, (a, b) -> (a[2] != b[2] ? a[2] - b[2] : (a[1] != b[1] ? a[1] - b[1] : a[0] - b[0])));

    List<List<Integer>> result = new ArrayList<>();

    int index = 0;
    int lastColumn = Integer.MIN_VALUE;

    while (index < nodeInfo.size()) {
      List<Integer> batch = new ArrayList<>();

      do {
        int[] currentNodeInfo = nodeInfo.get(index);
        batch.add(currentNodeInfo[0]);
        lastColumn = currentNodeInfo[2];
        index++;
      } while (index < nodeInfo.size() && nodeInfo.get(index)[2] == lastColumn);

      result.add(batch);
    }

    return result;
  }
}
