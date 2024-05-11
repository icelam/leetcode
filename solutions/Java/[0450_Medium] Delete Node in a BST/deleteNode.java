class Solution {
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return root;
    }

    if (root.val > key) {
      root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
      root.right = deleteNode(root.right, key);
    } else {
      // Case 1: Leaf node (no child) - Remove the node
      // Case 2: One Child - Replace node with child
      if (root.right == null) {
          return root.left;
      }

      if (root.left == null) {
          return root.right;
      }

      // Case 3: Two children - Replace with inorder successor,
      // which is the next node in inorder traversal (smallest in the right subtree)
      TreeNode successor = root.right;

      while (successor.left != null) {
        successor = successor.left;
      }

      // We have already saved the reference of successor in separate variable,
      // we can detach it from tree
      root.right = deleteNode(root.right, successor.val);

      // Attach child of node to be deleted to successor
      successor.left = root.left;
      successor.right = root.right;

      return successor;
    }

    return root;
  }
}
