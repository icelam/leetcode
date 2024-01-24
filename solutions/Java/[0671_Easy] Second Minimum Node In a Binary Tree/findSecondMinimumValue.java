class Solution {
  public int findSecondMinimumValue(TreeNode root) {
    if (root.left == null && root.right == null) {
      return -1;
    }

    int leftValue = root.left.val == root.val
      ? findSecondMinimumValue(root.left)
      : root.left.val;
    int rightValue = root.right.val == root.val
      ? findSecondMinimumValue(root.right)
      : root.right.val;

    if (leftValue == -1) {
      return rightValue;
    }

    if (rightValue == -1) {
      return leftValue;
    }

    return Math.min(leftValue, rightValue);
  }
}
