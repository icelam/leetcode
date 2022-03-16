/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

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
  public boolean hasSubPath(ListNode head, TreeNode root) {
    // List reached end, then it is subpath
    if (head == null) {
      return true;
    }

    // Tree reached end, but list not yet end, terminate check
    if (root == null) {
      return false;
    }

    // If current list value is equal to current node value, check next
    if (head.val == root.val) {
      return hasSubPath(head.next, root.left) || hasSubPath(head.next, root.right);
    }

    // The values does not match, terminate check
    return false;
  }

  public boolean isSubPath(ListNode head, TreeNode root) {
    // Tree ends, cannot go any deeper
    if (root == null) {
      return false;
    }

    // Check if the current tree has subpath starting from root
    if (hasSubPath(head, root)) {
      return true;
    }

    // Shift to next tree node and search again
    return isSubPath(head, root.left) || isSubPath(head, root.right);
  }
}
