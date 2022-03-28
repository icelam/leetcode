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

class BSTIterator {
  private List<Integer> nodes;
  private int index;

  public BSTIterator(TreeNode root) {
    nodes = new ArrayList<Integer>();
    inOrder(root);
  }

  public final void inOrder(TreeNode root) {
    if (root != null) {
      inOrder(root.left);
      nodes.add(root.val);
      inOrder(root.right);
    }
  }

  public int next() {
    if (nodes.size() == 0 || index >= nodes.size()) {
      return -1;
    }

    int result = nodes.get(index);
    index++;
    return result;
  }

  public boolean hasNext() {
    return index < nodes.size();
  }
}
