class Solution {
  private List<Integer> inorderNodes;

  private void inorder(TreeNode root) {
    if (root == null) {
      return;
    }

    inorder(root.left);
    inorderNodes.add(root.val);
    inorder(root.right);
  }

  private TreeNode createBalancedBST(int start, int end) {
    if (start > end) {
      return null;
    }

    int middle = (start + end) / 2;
    TreeNode node = new TreeNode(inorderNodes.get(middle));
    node.left = createBalancedBST(start, middle - 1);
    node.right = createBalancedBST(middle + 1, end);
    return node;
  }

  public TreeNode balanceBST(TreeNode root) {
    inorderNodes = new ArrayList<>();
    inorder(root);
    return createBalancedBST(0, inorderNodes.size() - 1);
  }
}
