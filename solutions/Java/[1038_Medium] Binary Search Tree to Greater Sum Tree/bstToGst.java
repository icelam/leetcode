class Solution {
  private int currentSum = 0;

  public void reverseInorder(TreeNode root) {
    if (root == null) {
      return;
    }

    reverseInorder(root.right);
    currentSum += root.val;
    root.val = currentSum;
    reverseInorder(root.left);
  }

  public TreeNode bstToGst(TreeNode root) {
    reverseInorder(root);
    return root;
  }
}
