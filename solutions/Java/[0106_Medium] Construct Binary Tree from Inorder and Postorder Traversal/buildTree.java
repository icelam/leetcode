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
  private HashMap<Integer, Integer> position = new HashMap<>();

  public TreeNode constructTree(int[] inorder, int[] postorder, int inorderLeft, int inorderRight, int postorderLeft, int postorderRight) {
    if (postorderLeft > postorderRight) {
      return null;
    }

    int k = position.get(postorder[postorderRight]);
    TreeNode root = new TreeNode(postorder[postorderRight]);
    root.left  = constructTree(inorder, postorder, inorderLeft, k - 1, postorderLeft, postorderLeft + k - 1 - inorderLeft);
    root.right = constructTree(inorder, postorder, k + 1, inorderRight, postorderLeft + k - 1 - inorderLeft + 1, postorderRight - 1);
    return root;
  }

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    int n = inorder.length;

    for (int i = 0; i < n; i++) {
      position.put(inorder[i], i);
    }

    return constructTree(inorder, postorder, 0, n - 1, 0, n - 1);
  }
}
