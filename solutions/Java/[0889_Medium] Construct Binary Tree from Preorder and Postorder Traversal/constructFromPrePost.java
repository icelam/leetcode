class Solution {
  private int preIndex = 0;
  private int postIndex = 0;

  private TreeNode constructTree(int[] preorder, int[] postorder) {
    TreeNode root = new TreeNode(preorder[preIndex]);
    preIndex++;

    if (root.val != postorder[postIndex]) {
      root.left = constructTree(preorder, postorder);
    }

    if (root.val != postorder[postIndex]) {
      root.right = constructTree(preorder, postorder);
    }

    postIndex++;
    return root;
  }

  public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
    return constructTree(preorder, postorder);
  }
}
